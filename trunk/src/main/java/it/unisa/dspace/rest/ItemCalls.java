package it.unisa.dspace.rest;

import it.unisa.dspace.Exception.WrongTypeException;
import it.unisa.dspace.entities.request.items.AddMetadataRequest;
import it.unisa.dspace.entities.request.items.BitStream;
import it.unisa.dspace.entities.request.items.Bundle;
import it.unisa.dspace.entities.request.items.InsertItemRequest;
import it.unisa.dspace.entities.request.items.UpdateMetadataRequest;
import it.unisa.dspace.entities.response.items.Item;
import it.unisa.dspace.entities.response.items.Items;
import it.unisa.dspace.entities.response.items.Search;
import it.unisa.dspace.util.DSpaceConnection;
import it.unisa.dspace.util.DSpaceXMLEnvelope;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;










import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import com.sun.jersey.multipart.file.StreamDataBodyPart;


public class ItemCalls {
    private java.util.logging.Logger logger = java.util.logging.Logger.getLogger("edu.unisa.indianamas.dspace.ItemCalls");

	private String uri;
	private String login;
	private String password;
	
	public ItemCalls(String uri, String login, String password) {
		this.uri = uri ;
		this.login = login;
		this.password = password;
		logger.setLevel(Level.ALL);
	}
	
	   /*
     * 
     */
    public Search search(String token) throws JAXBException, IOException
    {
           Reader xml = DSpaceConnection.connection(uri).path("search.xml").queryParam("query", token).accept(MediaType.TEXT_XML).get(Reader.class);
           Search search = null;

             Unmarshaller um = DSpaceXMLEnvelope.unmarshaller();

             search = (Search) um.unmarshal(xml);
           return search;

    }
	
	
	/*
	 * 
	 */
	public ArrayList get() throws JAXBException{
	  	   Reader xml = DSpaceConnection.connection(uri).path("items.xml").accept(MediaType.TEXT_XML).get(Reader.class);
	  	   Unmarshaller um = DSpaceXMLEnvelope.unmarshaller();
	  	   Items items = (Items) um.unmarshal(xml);
	  	   return items;

	}
	
	
/***
 * 
 * @param id 
 * @return Returns the Item object identified by id
 * @throws JAXBException
 */
	public Object getById(int id) throws JAXBException{
		Reader xml = DSpaceConnection.connection(uri).path("items").path(id+".xml").accept(MediaType.TEXT_XML).get(Reader.class);
	  	Unmarshaller um = DSpaceXMLEnvelope.unmarshaller();
	  	Item user = (Item) um.unmarshal(xml);
	  	return user;
	}


	public int insert(InsertItemRequest r, ArrayList<String> filenames ) throws WrongTypeException, IOException, JAXBException, Exception {
		File f = pack(r, filenames);
		Marshaller m = DSpaceXMLEnvelope.marshaller();

		m.marshal(r, System.out);

		return insert(f);
	}
	
	

	public int insert(Object f) throws WrongTypeException, Exception {
	    if (f==null) throw new WrongTypeException("The object to insert cannot be null");
	    if (!(f instanceof File) ) throw new WrongTypeException("The object to insert is not a file or packing does not working");
	    File file = new File("package.zip");
	    FormDataMultiPart part = new FormDataMultiPart();
	    part.bodyPart(new FileDataBodyPart("filename", file, MediaType.valueOf("application/zip")));
	    part.field("name", "upload");
	    ClientResponse xml = DSpaceConnection.connection(uri).path("items.stream").header("user", login).header("pass", password).type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class,part);
	    String dato = xml.getEntity(String.class);
	    System.out.println(dato);
	   // file.delete();
	    return Integer.parseInt(dato);
	}


	public void update(Object o, int id) throws WrongTypeException, JAXBException {
		if (!(o instanceof UpdateMetadataRequest)) throw new WrongTypeException("");
		UpdateMetadataRequest updateMetadata = (UpdateMetadataRequest)o;
		WebResource resource = DSpaceConnection.connection(uri);
		Unmarshaller um = DSpaceXMLEnvelope.unmarshaller();
		Marshaller m = DSpaceXMLEnvelope.marshaller();
		StringWriter writer = new StringWriter();
		m.marshal(updateMetadata, writer);
		ClientResponse xml = resource.path("items").path(id+"").path("metadata.xml").header("user", login).header("pass", password).type("application/xml").put(ClientResponse.class, writer.toString());

	}


	public int deleteItem(int id) {
		WebResource resource = DSpaceConnection.connection(uri);
		ClientResponse clientResponse = resource.path("items").path(id+"").header("user", login).header("pass", password).type("application/xml").delete(ClientResponse.class);
		return clientResponse.getStatus();
	}

	
	public void addMetadata(AddMetadataRequest field, int id) throws JAXBException{
		
		WebResource resource = DSpaceConnection.connection(uri);
		Unmarshaller um = DSpaceXMLEnvelope.unmarshaller();
		Marshaller m = DSpaceXMLEnvelope.marshaller();
		StringWriter writer = new StringWriter();
		m.marshal(field, writer);
		ClientResponse xml = resource.path("items").path(id+"").path("metadata.xml").header("user", login).header("pass", password).type("application/xml").post(ClientResponse.class, writer.toString());

	}
	
	/*******
	 * build the bundles specified by the zipFiles array
	 * @param zipFiles
	 * @return
	 */
	private List<Bundle> buildBundlesFromFiles(ArrayList<String> zipFiles) {
	    List<Bundle> bundles = null;
	    System.out.println("in bundling ***************");
        if (zipFiles!=null && zipFiles.size() > 0) {
        
            int zipFileLenght = zipFiles.size();
            bundles = new ArrayList<Bundle>();
            Bundle bundle =  new Bundle();
            bundle.setName("ORIGINAL");
            List<BitStream> bitstreams = new ArrayList<BitStream>();
            for (int i=0; i < zipFileLenght;i++) {
                System.out.println("Bundling "+zipFiles.get(i)+" "+i);
                String filename = zipFiles.get(i);
                File file = new File(filename);
                String mimeType = URLConnection.guessContentTypeFromName(filename);
                
                BitStream bitstream = new BitStream();
                bitstream.setName(file.getName());
                bitstream.setMimeType(mimeType);
                bitstream.setPrimary(true);
                bitstream.setDescription(filename);
                bitstreams.add(bitstream);
                
           }
            bundle.setBitstreams(bitstreams);
            bundles.add(bundle);
        } 

        return bundles;
	}
	
	/**
	 * 
	 * @param request. the request will be transformed into the package.xml. It represents the metatada to store
	 * @param filenames. They are the bitstreams to store
	 * @return
	 * @throws IOException
	 * @throws JAXBException
	 */
	private File pack(InsertItemRequest request, ArrayList<String> zipFiles ) throws IOException, JAXBException{
	    List<Bundle> bundles = buildBundlesFromFiles(zipFiles);
	    request.setBundles(bundles);
	    File packageFile = new File("package.xml");
		Marshaller marshaller =  DSpaceXMLEnvelope.marshaller();
		marshaller.marshal(request, packageFile);
		
		if (zipFiles==null) zipFiles = new ArrayList<String>();
		
		zipFiles.add(packageFile.getName());
	     

    //   File zipFile = File.createTempFile("pack", ".zip");
    //   System.out.println("***************"+zipFile.getName());
        File zipFile = new File("package.zip");
        FileOutputStream fout = new FileOutputStream(zipFile);
        ZipOutputStream zout = new ZipOutputStream(fout);
        
        byte[] buffer = new byte[1024];
        for(String filename : zipFiles)  {
            System.out.println(filename);
            File file = new File(filename);
          	FileInputStream fin = new FileInputStream(file);
          	System.out.println("File: "+file.getName());
            zout.putNextEntry(new ZipEntry(file.getName()));
            int length;
            while((length = fin.read(buffer)) > 0) {
                zout.write(buffer, 0, length);
            }
            zout.closeEntry();
            fin.close();
         }
         zout.close();
         packageFile.delete();
        return zipFile;
	}
		
	
	

}

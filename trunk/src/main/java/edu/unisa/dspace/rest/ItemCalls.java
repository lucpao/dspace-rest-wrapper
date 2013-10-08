package edu.unisa.dspace.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import edu.unisa.dspace.Exception.WrongTypeException;
import edu.unisa.dspace.entities.request.items.AddMetadataRequest;
import edu.unisa.dspace.entities.request.items.Bundles;
import edu.unisa.dspace.entities.request.items.InsertItemRequest;
import edu.unisa.dspace.entities.request.items.UpdateMetadataRequest;
import edu.unisa.dspace.entities.response.bitstreams.BitStreamType;
import edu.unisa.dspace.entities.response.bitstreams.ResponseBitstream;
import edu.unisa.dspace.entities.response.items.Item;
import edu.unisa.dspace.entities.response.items.Items;
import edu.unisa.dspace.util.DSpaceConnection;
import edu.unisa.dspace.util.DSpaceXMLEnvelope;

public class ItemCalls {

	private String uri;
	private String login;
	private String password;
	
	public ItemCalls(String uri, String login, String password) {
		this.uri = uri ;
		this.login = login;
		this.password = password;
	}
	

	public ArrayList get() throws JAXBException{
	  	   Reader xml = DSpaceConnection.connection(uri).path("items.xml").accept(MediaType.TEXT_XML).get(Reader.class);
	  	   Unmarshaller um = DSpaceXMLEnvelope.unmarshaller();
	  	   Items items = (Items) um.unmarshal(xml);
	  	   return items;

	}
	
	

	public Object getById(int id) throws JAXBException{
		Reader xml = DSpaceConnection.connection(uri).path("items").path(id+".xml").accept(MediaType.TEXT_XML).get(Reader.class);
	  	Unmarshaller um = DSpaceXMLEnvelope.unmarshaller();
	  	Item user = (Item) um.unmarshal(xml);
	  	return user;
	}


	public void insert(InsertItemRequest r, ArrayList<String> filenames ) throws WrongTypeException, IOException, JAXBException, Exception {
		File f = pack(r, filenames);
		Marshaller m = DSpaceXMLEnvelope.marshaller();
		m.marshal(r, System.out);
		insert(f);
	}
	
	

	public int insert(Object f) throws WrongTypeException, Exception {
		if (f==null) throw new WrongTypeException("The object to insert cannot be null");
		if (!(f instanceof File) ) throw new WrongTypeException("The object to insert is not a file or packing does not working");
		// Create the form to send
		FormDataMultiPart part = new FormDataMultiPart();
		part.bodyPart(new FileDataBodyPart("filename", (File)f, MediaType.valueOf("application/zip")));
		part.field("name", "upload");
		
		ClientResponse xml = DSpaceConnection.connection(uri).path("items.stream").header("user", login).header("pass", password).type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class, part);
		
		return Integer.parseInt(xml.getEntity(String.class));
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
	
	/**
	 * 
	 * @param request. the request will be transformed into the package.xml. It represents the metatada to store
	 * @param filenames. They are the bitstreams to store
	 * @return
	 * @throws IOException
	 * @throws JAXBException
	 */
	private File pack(InsertItemRequest request, ArrayList<String> zipFiles ) throws IOException, JAXBException{

		File packageFile = new File("package.xml");
		Marshaller marshaller =  DSpaceXMLEnvelope.marshaller();
		marshaller.marshal(request, packageFile);
		
		
		zipFiles.add(packageFile.getName());
	     

        File zipFile = File.createTempFile("pack", ".zip");
        FileOutputStream fout = new FileOutputStream(zipFile);
        ZipOutputStream zout = new ZipOutputStream(fout);
        
        byte[] buffer = new byte[1024];
        for(String filename : zipFiles)  {
          	FileInputStream fin = new FileInputStream(filename);
            zout.putNextEntry(new ZipEntry(filename));
            int length;
            while((length = fin.read(buffer)) > 0) {
                zout.write(buffer, 0, length);
            }
            zout.closeEntry();
            fin.close();
         }
         zout.close();
        return zipFile;
	}
		
	
	
	

}

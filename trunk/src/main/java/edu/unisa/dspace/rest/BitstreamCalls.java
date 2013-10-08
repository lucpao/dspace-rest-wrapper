package edu.unisa.dspace.rest;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.header.ContentDisposition;

import edu.unisa.dspace.Exception.WrongTypeException;
import edu.unisa.dspace.entities.response.bitstreams.BitStreamType;
import edu.unisa.dspace.entities.response.bitstreams.ResponseBitstream;
import edu.unisa.dspace.entities.response.bitstreams.ResponseBundles;
import edu.unisa.dspace.util.DSpaceConnection;
import edu.unisa.dspace.util.DSpaceXMLEnvelope;

public class BitstreamCalls {

	private String uri;
	private String login;
	private String password;
	
	public BitstreamCalls(String uri, String login, String password) {
		this.uri = uri ;
		this.login = login;
		this.password = password;
	}
	
	
	/**
	 * NOT WORKING BECAUSE IT IS NOT IMPLEMENTED YET ON SERVER SIDE
	 * @param id
	 * @param type
	 * @return
	 * @throws JAXBException
	 * @throws WrongTypeException
	 */
	public ResponseBundles getBundlesByItemId(int id, BitStreamType type) throws JAXBException, WrongTypeException {
		   WebResource partialWR = DSpaceConnection.connection(uri).path("items.xml").path(id+"").path("bundles.xml");
		   if (type != BitStreamType.EMPTY && BitStreamType.contains(type.name())) partialWR.queryParam("type", type.name());
	  	   Reader xml = partialWR.accept(MediaType.TEXT_XML).get(Reader.class);
	  	   Unmarshaller um = DSpaceXMLEnvelope.unmarshaller();
	  	   ResponseBundles bundles = (ResponseBundles) um.unmarshal(xml);
	  	   return bundles;
	}
	/*TODO complete and test
	 * 
	 */
	public ResponseBitstream getMetadataBitstreamById(int id) throws JAXBException{
	  	   Reader xml = DSpaceConnection.connection(uri).path("bitstreams").path(id+".xml").accept(MediaType.TEXT_XML).get(Reader.class);
	  	   Unmarshaller um = DSpaceXMLEnvelope.unmarshaller();
	  	   ResponseBitstream bitstream = (ResponseBitstream) um.unmarshal(xml);
	  	   return bitstream;
	}
	/*TODO complete and test
	 * 
	 */
	public File getFileBitstreamById(int id) throws JAXBException, IOException,
			ParseException {
		ClientResponse output = DSpaceConnection.connection(uri)
				.path("bitstreams").path(id + "").path("download")
				.header("user", login).header("pass", password)
				.get(ClientResponse.class);
		List<String> contentDisposition = output.getHeaders().get(
				"Content-Disposition");
		String filename = "defaultName";
		if (contentDisposition != null && contentDisposition.get(0) != null) {
			String str = contentDisposition.get(0);
			filename = str.substring(str.indexOf("=") + 1, str.length());

		}
		InputStream inputStream = output.getEntityInputStream();
		File outputFile = new File(filename);
		OutputStream outputStream = new FileOutputStream(outputFile);
		int read = 0;
		byte[] bytes = new byte[1024];

		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}
		return outputFile;
	}
	
	/* TODO complete and test
	 * 
	 * 
	 */
	public int delete(int id) {
		WebResource resource = DSpaceConnection.connection(uri);
		ClientResponse clientResponse = resource.path("bitstreams").path(id+"").header("user", login).header("pass", password).type("application/xml").delete(ClientResponse.class);
		return clientResponse.getStatus();
	}

}
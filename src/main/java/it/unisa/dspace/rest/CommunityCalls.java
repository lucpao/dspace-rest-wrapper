package it.unisa.dspace.rest;

import it.unisa.dspace.Exception.WrongTypeException;
import it.unisa.dspace.entities.request.communities.CommunityRequest;
import it.unisa.dspace.entities.response.communities.CommunityResponse;
import it.unisa.dspace.util.DSpaceConnection;
import it.unisa.dspace.util.DSpaceXMLEnvelope;

import java.io.File;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;


public class CommunityCalls {

	private String uri;
	private String login;
	private String password;
	
	public CommunityCalls(String uri, String login, String password) {
		this.uri = uri ;
		this.login = login;
		this.password = password;
	}
	
	public int insert(CommunityRequest cr) throws WrongTypeException, Exception {
		WebResource resource = DSpaceConnection.connection(uri);
		Marshaller m = DSpaceXMLEnvelope.marshaller();
		StringWriter writer = new StringWriter();
		m.marshal(cr, writer);
		ClientResponse xml = resource.path("communities.xml").header("user", login).header("pass", password).type("application/xml").post(ClientResponse.class, writer.toString());
		return Integer.parseInt(xml.getEntity(String.class));
	}
	
	public void addLogo(int id, String filename) {
	        File file = new File(filename);
	        FormDataMultiPart part = new FormDataMultiPart();
	        part.bodyPart(new FileDataBodyPart("filename", file, MediaType.valueOf("image/png")));
	        part.field("name", "upload");
	        ClientResponse xml = DSpaceConnection.connection(uri).path("communities").path(id+"").path("logo.stream").header("user", login).header("pass", password).type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class,part);
	        String dato = xml.getEntity(String.class);
	        System.out.println(dato);
	}


}

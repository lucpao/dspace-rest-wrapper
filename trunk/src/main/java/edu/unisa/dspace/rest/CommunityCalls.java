package edu.unisa.dspace.rest;

import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.unisa.dspace.Exception.WrongTypeException;
import edu.unisa.dspace.entities.request.communities.CommunityRequest;
import edu.unisa.dspace.entities.response.communities.CommunityResponse;
import edu.unisa.dspace.util.DSpaceConnection;
import edu.unisa.dspace.util.DSpaceXMLEnvelope;

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


}

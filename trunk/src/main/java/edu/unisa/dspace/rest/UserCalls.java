package edu.unisa.dspace.rest;

import java.io.Reader;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import edu.unisa.dspace.entities.response.users.User;
import edu.unisa.dspace.entities.response.users.Users;
import edu.unisa.dspace.util.DSpaceConnection;
import edu.unisa.dspace.util.DSpaceXMLEnvelope;

public class UserCalls {

	private String uri;
	private String login;
	private String password;
	
	public UserCalls(String uri, String login, String password) {
		this.uri = uri ;
		this.login = login;
		this.password = password;
	}
	

	public ArrayList get() throws JAXBException{
	  	   Reader xml = DSpaceConnection.connection(uri).path("users.xml").accept(MediaType.TEXT_XML).get(Reader.class);
	  	   Unmarshaller um = DSpaceXMLEnvelope.unmarshaller();
	  	   Users users = (Users) um.unmarshal(xml);
	  	   return users;

	}

	
	public Object getById(int id) throws JAXBException{
		Reader xml = DSpaceConnection.connection(uri).path("users").path(id+".xml").queryParam("user", login).queryParam("pass", password).accept(MediaType.TEXT_XML).get(Reader.class);
	  	Unmarshaller um = DSpaceXMLEnvelope.unmarshaller();
	  	User user = (User) um.unmarshal(xml);
	  	return user;
	}




}

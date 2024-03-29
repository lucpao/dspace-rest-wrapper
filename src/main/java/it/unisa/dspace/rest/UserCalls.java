package it.unisa.dspace.rest;

import it.unisa.dspace.entities.response.users.User;
import it.unisa.dspace.entities.response.users.Users;
import it.unisa.dspace.util.DSpaceConnection;
import it.unisa.dspace.util.DSpaceXMLEnvelope;

import java.io.Reader;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


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

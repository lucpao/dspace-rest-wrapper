package edu.unisa.rest;

import java.io.Reader;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import edu.unisa.entities.User;
import edu.unisa.entities.Users;

public class UserCalls extends DSpaceREST{

	private String uri;
	private String login;
	private String password;
	
	public UserCalls(String uri, String login, String password) {
		this.uri = uri ;
		this.login = login;
		this.password = password;
	}
	
	@Override
	public ArrayList get() throws JAXBException{
	  	   Reader xml = DSpaceREST.connection(uri).path("users.xml").accept(MediaType.TEXT_XML).get(Reader.class);
	  	   Unmarshaller um = DSpaceREST.unmarshaller(uri);
	  	   Users users = (Users) um.unmarshal(xml);
	  	   return users;

	}

	@Override
	public Object getById(int id) throws JAXBException{
		Reader xml = DSpaceREST.connection(uri).path("users").path(id+".xml").queryParam("user", login).queryParam("pass", password).accept(MediaType.TEXT_XML).get(Reader.class);
	  	Unmarshaller um = DSpaceREST.unmarshaller(uri);
	  	User user = (User) um.unmarshal(xml);
	  	return user;
	}

	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}

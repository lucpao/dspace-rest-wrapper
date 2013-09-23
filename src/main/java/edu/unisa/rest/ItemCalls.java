package edu.unisa.rest;

import java.io.Reader;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import edu.unisa.entities.Item;
import edu.unisa.entities.Items;


public class ItemCalls extends DSpaceREST{

	private String uri;
	private String login;
	private String password;
	
	public ItemCalls(String uri, String login, String password) {
		this.uri = uri ;
		this.login = login;
		this.password = password;
	}
	
	@Override
	public ArrayList get() throws JAXBException{
	  	   Reader xml = DSpaceREST.connection(uri).path("items.xml").accept(MediaType.TEXT_XML).get(Reader.class);
	  	   Unmarshaller um = DSpaceREST.unmarshaller(uri);
	  	   Items items = (Items) um.unmarshal(xml);
	  	   return items;

	}

	@Override
	public Object getById(int id) throws JAXBException{
		Reader xml = DSpaceREST.connection(uri).path("items").path(id+".xml").queryParam("user", login).queryParam("pass", password).accept(MediaType.TEXT_XML).get(Reader.class);
	  	Unmarshaller um = DSpaceREST.unmarshaller(uri);
	  	Item user = (Item) um.unmarshal(xml);
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

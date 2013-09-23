package edu.unisa;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


import edu.unisa.entities.*;
import edu.unisa.rest.*;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/rest";

    private static WebResource service;
    

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    		/*
    		 * connect to DSpaceREST interface
    		 */
    		UserCalls userCalls = new UserCalls(Main.BASE_URI, "paolino.luca@gmail.com", "indianamas");

    	    try {
    	    	/*
    	    	 * call the get all users method
    	    	 */
    	    	Users users = (Users) userCalls.get();
    	    	
    	    	/*
    	    	 * iterate results
    	    	 */
    	    	Iterator<User> userIterator = users.getUsers().iterator();
				while(userIterator.hasNext()) {
					User user = userIterator.next();
					System.out.println(user.getEmail());
					System.out.println(user.getFirstName());
				}
				System.out.println(" ITEMS");
				ItemCalls itemCalls = new ItemCalls(Main.BASE_URI, "paolino.luca@gmail.com", "indianamas");
				Items items = (Items) itemCalls.get();
    	    	Iterator<Item> itemIterator = items.getItems().iterator();
				while(userIterator.hasNext()) {
					Item item = itemIterator.next();
					System.out.println(item.getId());
					System.out.println(item.getHandle());
				}

			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    System.out.println(" second call");
    	    User user;
			try {
				user = (User) userCalls.getById(1);
	    	    System.out.println(user.getEmail());
				System.out.println(user.getFirstName());
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    	    
    }

    
}


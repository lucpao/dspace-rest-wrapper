package edu.unisa.rest;

import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import edu.unisa.entities.Describe;
import edu.unisa.entities.Items;
import edu.unisa.entities.Users;

public abstract class DSpaceREST {
	protected DSpaceREST() {
	     // ...
	   }
	 

	   /**
	    * A handle to the unique Singleton instance.
	    */
	//   static private Connect _instance = null;
	   private static WebResource _instanceConnection = null;
	   private static Unmarshaller _instanceUnmarshaller = null;
	   /**
	    * @return The unique instance of this class.
	    */
	   static public WebResource connection(String uri) {
	      if(null == _instanceConnection) {
	    	    ClientConfig config = new DefaultClientConfig();
	    	    Client client = Client.create(config);
	    	    _instanceConnection =  client.resource(uri);
	         
	      }
	      return _instanceConnection;
	   }
	   
	   static public Unmarshaller unmarshaller(String uri) throws JAXBException {
		      if(null == _instanceUnmarshaller) {
			    	JAXBContext context = JAXBContext.newInstance(Items.class, Users.class,Describe.class);
		    	    _instanceUnmarshaller =  context.createUnmarshaller();
		         
		      }
		      return _instanceUnmarshaller;
		   }
	   
	   
		public abstract ArrayList get() throws JAXBException;
		public abstract Object getById(int id) throws JAXBException;
		public abstract void insert(Object o);
		public abstract void update(Object o);
		public abstract boolean delete(int id);
}

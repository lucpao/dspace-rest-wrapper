package edu.unisa.dspace.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class DSpaceConnection {
	protected DSpaceConnection() {
	     // ...
	   }
	private static WebResource _instanceConnection = null;
	
	   /**
	    * @return The unique instance of this class.
	    */
	   static public WebResource connection(String uri) {
	      if(null == _instanceConnection) {
	    	    ClientConfig config = new DefaultClientConfig();
	    	    Client client = Client.create(config);
	    	  //  client.addFilter(new LoggingFilter(System.out));
	    	    _instanceConnection =  client.resource(uri);
	         
	      }
	      return _instanceConnection;
	   }
}

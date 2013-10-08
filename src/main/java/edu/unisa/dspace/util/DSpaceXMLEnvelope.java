package edu.unisa.dspace.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import edu.unisa.dspace.entities.request.communities.CommunityRequest;
import edu.unisa.dspace.entities.request.items.AddMetadataRequest;
import edu.unisa.dspace.entities.request.items.BitStream;
import edu.unisa.dspace.entities.request.items.BitStreams;
import edu.unisa.dspace.entities.request.items.Bundle;
import edu.unisa.dspace.entities.request.items.Bundles;
import edu.unisa.dspace.entities.request.items.Field;
import edu.unisa.dspace.entities.request.items.InsertItemRequest;
import edu.unisa.dspace.entities.request.items.UpdateMetadataRequest;
import edu.unisa.dspace.entities.response.bitstreams.ResponseBitstream;
import edu.unisa.dspace.entities.response.bitstreams.ResponseBundle;
import edu.unisa.dspace.entities.response.bitstreams.ResponseBundles;
import edu.unisa.dspace.entities.response.communities.CommunityResponse;
import edu.unisa.dspace.entities.response.describe.Describe;
import edu.unisa.dspace.entities.response.items.Items;
import edu.unisa.dspace.entities.response.items.Metadata;
import edu.unisa.dspace.entities.response.users.Users;

public class DSpaceXMLEnvelope {
	
	
	   private static Unmarshaller _instanceUnmarshaller = null;
	   private static Marshaller _instanceMarshaller = null;
	   
		protected DSpaceXMLEnvelope() {
		     // ...
		   }
	   
	   static public Unmarshaller unmarshaller() throws JAXBException {
		      if(null == _instanceUnmarshaller) {
			    	JAXBContext context = JAXBContext.newInstance(ResponseBitstream.class, ResponseBundles.class, ResponseBundle.class, CommunityResponse.class, Metadata.class, Items.class, Users.class,Describe.class);
		    	    _instanceUnmarshaller =  context.createUnmarshaller();
		         
		      }
		      return _instanceUnmarshaller;
		   }
	   
	   
	   static public Marshaller marshaller() throws JAXBException {
		      if(null == _instanceMarshaller) {
			    	JAXBContext context = JAXBContext.newInstance( UpdateMetadataRequest.class,AddMetadataRequest.class, CommunityRequest.class,Metadata.class, Items.class, Users.class,Describe.class, InsertItemRequest.class);
		    	    _instanceMarshaller =  context.createMarshaller();
		         
		      }
		      return _instanceMarshaller;
		   }
	
	   
}

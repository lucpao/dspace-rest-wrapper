package it.unisa.dspace.util;

import it.unisa.dspace.entities.request.communities.CommunityRequest;
import it.unisa.dspace.entities.request.items.AddMetadataRequest;
import it.unisa.dspace.entities.request.items.BitStream;
import it.unisa.dspace.entities.request.items.BitStreams;
import it.unisa.dspace.entities.request.items.Bundle;
import it.unisa.dspace.entities.request.items.Bundles;
import it.unisa.dspace.entities.request.items.Field;
import it.unisa.dspace.entities.request.items.InsertItemRequest;
import it.unisa.dspace.entities.request.items.UpdateMetadataRequest;
import it.unisa.dspace.entities.response.bitstreams.ResponseBitstream;
import it.unisa.dspace.entities.response.bitstreams.ResponseBundle;
import it.unisa.dspace.entities.response.bitstreams.ResponseBundles;
import it.unisa.dspace.entities.response.communities.CommunityResponse;
import it.unisa.dspace.entities.response.describe.Describe;
import it.unisa.dspace.entities.response.items.Items;
import it.unisa.dspace.entities.response.items.Metadata;
import it.unisa.dspace.entities.response.items.Search;
import it.unisa.dspace.entities.response.items.SearchResultsInfo;
import it.unisa.dspace.entities.response.users.Users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class DSpaceXMLEnvelope {
	
	
	   private static Unmarshaller _instanceUnmarshaller = null;
	   private static Marshaller _instanceMarshaller = null;
	   
		protected DSpaceXMLEnvelope() {
		     // ...
		   }
	   
	   static public Unmarshaller unmarshaller() throws JAXBException {
		      if(null == _instanceUnmarshaller) {
			    	JAXBContext context = JAXBContext.newInstance(ResponseBitstream.class, ResponseBundles.class, ResponseBundle.class, CommunityResponse.class, Metadata.class, Items.class, Users.class,Describe.class,Search.class,SearchResultsInfo.class);
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
	   
	   static public void print(Reader reader) throws IOException {
	        BufferedReader fin = new BufferedReader(reader);
	        String line;
	        while((line=fin.readLine())!= null){
	            System.out.println(line);
	            System.out.flush();
	        }
	        fin.reset();
	   }
	
	   
}

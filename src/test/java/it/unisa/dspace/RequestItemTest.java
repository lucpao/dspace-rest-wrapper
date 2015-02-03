package it.unisa.dspace;

import it.unisa.dspace.Main;
import it.unisa.dspace.Exception.WrongTypeException;
import it.unisa.dspace.entities.request.items.AddMetadataRequest;
import it.unisa.dspace.entities.request.items.BitStream;
import it.unisa.dspace.entities.request.items.Bundle;
import it.unisa.dspace.entities.request.items.Field;
import it.unisa.dspace.entities.request.items.InsertItemRequest;
import it.unisa.dspace.entities.request.items.UpdateMetadataRequest;
import it.unisa.dspace.entities.response.items.Search;
import it.unisa.dspace.rest.ItemCalls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RequestItemTest {
	ItemCalls itemCalls = new ItemCalls(Main.BASE_URI, "lpaolino@unisa.it", "1811ferdi");
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {



	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void searchTest() throws JAXBException, IOException {
	    Search search = itemCalls.search("title:6 AND author:Daniela");
	    System.out.println("result search id "+search.getSearchResultsInfo().getId());
	    System.out.println("result search name "+search.getSearchResultsInfo().getName());
	    System.out.println("result count "+search.getSearchResultsInfo().getResultCount());
	       System.out.println("resultHandles size "+search.getSearchResultsInfo().getResultHandles().size());
//	        System.out.println("resultHandles size "+search.getSearchResultsInfo().getResultHandles().get(0));
	       System.out.println("resultIDs size "+search.getSearchResultsInfo().getResultIDs().size());
  //         System.out.println("resultHandles size "+search.getSearchResultsInfo().getResultIDs().get(0));
	       System.out.println("resultTypes size "+search.getSearchResultsInfo().getResultTypes().size());
    //       System.out.println("resultHandles size "+search.getSearchResultsInfo().getResultTypes().get(0));
	}
	
	@Test
	public void insertTest() throws WrongTypeException, IOException, JAXBException, Exception {
		List<Field> metadata = new ArrayList<Field>();
	Field field1 =  new Field("dlc.title", "Test Item2");
		Field field2 =  new Field("dc.contributor.author", "Luca Paolino");
	
		metadata.add(field1);
		metadata.add(field2);
		
//		BitStream bitstream1 = new BitStream("dspacehowtoguide.pdf", "application/pdf","A DSpace Howto guide4.",true);
//		//BitStream bitstream2 = new BitStream("test.mp3", "audio/x-mpeg","An MP3 file.",false);
//		
//		Bundle bundle = new Bundle();
//		bundle.setName("ORIGINAL4");
//		List<BitStream> bitstreams = new ArrayList<BitStream>();
//		bitstreams.add(bitstream1);
//	//	bitstreams.add(bitstream2);
//		bundle.setBitstreams(bitstreams);
//		List<Bundle> bundles = new ArrayList<Bundle>();
//		bundles.add(bundle);
		InsertItemRequest request = new InsertItemRequest();
		request.setMetadata(metadata);
//		request.setBundles(bundles);
		request.setCollectionId(2);
		ArrayList<String> filenames = new ArrayList<String>();
		 String current = new java.io.File( "." ).getCanonicalPath();
	        System.out.println("Current dir:"+current);
		filenames.add("src/test/resources/dspacehowtoguide.pdf");
		try {
		itemCalls.insert(request, filenames);
		} catch(Exception e) {
		    e.printStackTrace();
		}
	}
//
//	@Test
//	public void addMetadataTest() throws WrongTypeException, IOException, JAXBException, Exception {
//		AddMetadataRequest request = new AddMetadataRequest(10,"pippo");
//		itemCalls.addMetadata(request, 7);
//	}
//	
//	@Test
//	public void updateMetadataTest() throws WrongTypeException, IOException, JAXBException, Exception {
//		UpdateMetadataRequest request = new UpdateMetadataRequest();
//		Field field1 =  new Field("dlc.title", "Test Item2");
//		Field field2 =  new Field("dc.contributor.author", "Junwei Lu2");
//	
//		request.addMetadataField(field1);
//		request.addMetadataField(field2);
//		itemCalls.update(request, 7);
//	}
//	

	
}


package edu.unisa.dspace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.unisa.dspace.Exception.WrongTypeException;
import edu.unisa.dspace.entities.request.items.AddMetadataRequest;
import edu.unisa.dspace.entities.request.items.BitStream;
import edu.unisa.dspace.entities.request.items.Bundle;
import edu.unisa.dspace.entities.request.items.Field;
import edu.unisa.dspace.entities.request.items.InsertItemRequest;
import edu.unisa.dspace.entities.request.items.UpdateMetadataRequest;
import edu.unisa.dspace.rest.ItemCalls;

public class RequestItemTest {
	ItemCalls itemCalls = new ItemCalls(Main.BASE_URI, "paolino.luca@gmail.com", "indianamas");
	
	
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
	public void insertTest() throws WrongTypeException, IOException, JAXBException, Exception {
		List<Field> metadata = new ArrayList<Field>();
	/*	Field field1 =  new Field("dlc.title", "Test Item");
		Field field2 =  new Field("dc.contributor.author", "Junwei Lu");
	
		metadata.add(field1);
		metadata.add(field2);
		*/
		BitStream bitstream1 = new BitStream("dspacehowtoguide.pdf", "application/pdf","A DSpace Howto guide.",true);
//		BitStream bitstream2 = new BitStream("test.mp3", "audio/x-mpeg","An MP3 file.",false);
		
		Bundle bundle = new Bundle();
		bundle.setName("ORIGINAL");
		List<BitStream> bitstreams = new ArrayList<BitStream>();
		bitstreams.add(bitstream1);
	//	bitstreams.add(bitstream2);
		bundle.setBitstreams(bitstreams);
		List<Bundle> bundles = new ArrayList<Bundle>();
		bundles.add(bundle);
		InsertItemRequest request = new InsertItemRequest();
		request.setMetadata(metadata);
		request.setBundles(bundles);
		request.setCollectionId(2);
		ArrayList<String> filenames = new ArrayList<String>();
		 String current = new java.io.File( "." ).getCanonicalPath();
	        System.out.println("Current dir:"+current);
		filenames.add("dspacehowtoguide.pdf");
		itemCalls.insert(request, filenames);
	}

	@Test
	public void addMetadataTest() throws WrongTypeException, IOException, JAXBException, Exception {
		AddMetadataRequest request = new AddMetadataRequest(10,"pippo");
		itemCalls.addMetadata(request, 7);
	}
	
	@Test
	public void updateMetadataTest() throws WrongTypeException, IOException, JAXBException, Exception {
		UpdateMetadataRequest request = new UpdateMetadataRequest();
		Field field1 =  new Field("dlc.title", "Test Item2");
		Field field2 =  new Field("dc.contributor.author", "Junwei Lu2");
	
		request.addMetadataField(field1);
		request.addMetadataField(field2);
		itemCalls.update(request, 7);
	}
	

	
}


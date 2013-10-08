package edu.unisa.dspace;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.unisa.dspace.Exception.WrongTypeException;
import edu.unisa.dspace.entities.response.bitstreams.ResponseBitstream;
import edu.unisa.dspace.rest.BitstreamCalls;

public class RequestBitstreamTest {
	BitstreamCalls bitstreamCalls = new BitstreamCalls(Main.BASE_URI, "paolino.luca@gmail.com", "indianamas");
	
	
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


/*
 * REST CALL NOT IMPLEMENTED YET
 
	@Test
	public void getBundlesTest() throws WrongTypeException, IOException, JAXBException, Exception {
		ResponseBundles bundles = bitstreamCalls.getBundlesByItemId(1,BitStreamType.EMPTY);
		for (int i=0; i < bundles.size(); i++) {
			System.out.println("BUNDLE : "+bundles.get(i).toString());
		}
	}
	
*/

	@Test
	public void getMetadataBitstreamById() throws WrongTypeException, IOException, JAXBException, Exception {
		ResponseBitstream bitstream = bitstreamCalls.getMetadataBitstreamById(1);
		System.out.println(bitstream.toString());
	}
	
	@Test
	public void getFileBitstreamById() throws WrongTypeException, IOException, JAXBException, Exception {
		File file = bitstreamCalls.getFileBitstreamById(1);
	System.out.println(file.getName());

	}
	
	
}


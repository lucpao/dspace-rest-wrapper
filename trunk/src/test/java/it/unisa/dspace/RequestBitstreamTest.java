package it.unisa.dspace;

import it.unisa.dspace.Main;
import it.unisa.dspace.Exception.WrongTypeException;
import it.unisa.dspace.entities.response.bitstreams.ResponseBitstream;
import it.unisa.dspace.rest.BitstreamCalls;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RequestBitstreamTest {
	BitstreamCalls bitstreamCalls = new BitstreamCalls(Main.BASE_URI, "lpaolino@unisa.it", "1811ferdi");
	
	
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
		ResponseBitstream bitstream = bitstreamCalls.getMetadataBitstreamById(177);
		System.out.println(bitstream.toString());
	}
	
	@Test
	public void getFileBitstreamById() throws WrongTypeException, IOException, JAXBException, Exception {
		File file = bitstreamCalls.getFileBitstreamById(177);
	System.out.println(file.getName());

	}
	
	
}


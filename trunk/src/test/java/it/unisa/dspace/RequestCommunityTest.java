package it.unisa.dspace;

import static org.junit.Assert.*;
import it.unisa.dspace.Main;
import it.unisa.dspace.Exception.WrongTypeException;
import it.unisa.dspace.entities.request.communities.*;
import it.unisa.dspace.rest.CommunityCalls;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RequestCommunityTest {
	CommunityRequest request = new CommunityRequest();
	CommunityCalls communityCalls = new CommunityCalls(Main.BASE_URI, "lpaolino@unisa.it", "1811ferdi");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		request.setName("IndianaBoys");
		request.setCommunityId(3);
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void test() throws WrongTypeException, Exception {
//
//		communityCalls.insert(request);
//	}
	
	   @Test
	    public void addLogotest() throws WrongTypeException, Exception {

	        communityCalls.addLogo(1, "src/test/resources/test.gif");
	    }

}

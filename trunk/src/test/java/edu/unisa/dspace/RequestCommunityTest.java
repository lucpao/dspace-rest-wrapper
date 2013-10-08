package edu.unisa.dspace;

import static org.junit.Assert.*;

import java.util.ArrayList;

import edu.unisa.dspace.Exception.WrongTypeException;
import edu.unisa.dspace.entities.request.communities.*;
import edu.unisa.dspace.rest.CommunityCalls;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RequestCommunityTest {
	CommunityRequest request = new CommunityRequest();
	CommunityCalls communityCalls = new CommunityCalls(Main.BASE_URI, "paolino.luca@gmail.com", "indianamas");
	
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

	@Test
	public void test() throws WrongTypeException, Exception {

		communityCalls.insert(request);
	}

}

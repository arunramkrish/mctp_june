package com.mindtree.training.search;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mindtree.training.entity.Contact;
import com.mindtree.training.search.impl.LinearSearch;

public class SearchTest {
	private static Search search;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		search = new LinearSearch();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		search = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Inside setup");
		search.init();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("In tear down");
	}

	@Test
	public void testAddContacts() {
		Contact c1 = new Contact("Arun", "9449804064", new Date());
		Contact c2 = new Contact("Ram", "9486622713", new Date());
		Contact c3 = new Contact("Krish", "9449804063", new Date());
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c3);
		
		search.addContacts(contacts);
		assertEquals(3, search.getContactsCount());
	}

	@Test
	public void testSearchContactContact() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchContactString() {
		fail("Not yet implemented");
	}

}

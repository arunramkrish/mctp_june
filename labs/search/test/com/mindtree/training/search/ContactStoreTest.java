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
import com.mindtree.training.io.ContactStore;
import com.mindtree.training.search.impl.LinearSearch;

public class ContactStoreTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Search search = new LinearSearch();
		Contact c1 = new Contact("Arun", "9449804064", new Date());
		Contact c2 = new Contact("Ram", "9486622713", new Date());
		Contact c3 = new Contact("Krish", "9449804063", new Date());

		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c3);

		search.addContacts(contacts);

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
	public void test() {
		ContactStore store = new ContactStore("contacts.csv");
		List<Contact> loadedContacts = store.loadContacts();
		
		assertEquals(3, loadedContacts.size());
	}

}

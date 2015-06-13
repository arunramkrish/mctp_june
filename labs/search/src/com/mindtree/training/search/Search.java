package com.mindtree.training.search;

import java.util.List;

import com.mindtree.training.entity.Contact;

public interface Search {
	void addContacts(List<Contact> contacts);

	Contact searchContact(Contact contactToSearch);
	
	List<Contact> searchContact(String name);
}

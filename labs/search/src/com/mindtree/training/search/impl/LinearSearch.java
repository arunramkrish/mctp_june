package com.mindtree.training.search.impl;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.training.entity.Contact;
import com.mindtree.training.io.ContactStore;
import com.mindtree.training.search.Search;

public class LinearSearch implements Search {
	private List<Contact> contacts = new ArrayList<Contact>(); 
	private ContactStore contactStore = new ContactStore("contacts.csv");
	
	@Override
	public void addContacts(List<Contact> contacts) {
		if (contacts == null) {
			return;
		}
		for(Contact contact : contacts) {
			this.contacts.add(contact);
		}
		
		contactStore.addContacts(contacts);
		
		//below code is same as the above one
//		this.contacts.addAll(contacts);
	}

	@Override
	public Contact searchContact(Contact contactToSearch) {
		for (Contact contact : contacts) {
			if (contact.equals(contactToSearch)) {
				return contact;
			}
		}
		
		
		return null;
		
		//this code is equivalent to above
//		int index = contacts.indexOf(contactToSearch);
//		return (index != -1) ? contacts.get(index) : null;
	}

	@Override
	public List<Contact> searchContact(String name) {
		List<Contact> matchingContacts = new ArrayList<Contact>();
		
		for (Contact contact : contacts) {
			String contactName = contact.getName();
			
			if (contactName != null) {
				if (contactName.equalsIgnoreCase(name)) {
					matchingContacts.add(contact);
				}
			} else if (name == null) {
				matchingContacts.add(contact);
			}
			
		}
		return matchingContacts;
	}

	@Override
	public void init() {
		contacts.clear();
	}

	@Override
	public int getContactsCount() {
		return contacts.size();
	}

}

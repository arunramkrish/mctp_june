package com.mindtree.training.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mindtree.training.entity.Contact;

public class ContactStore {
	private PrintStream contactWriter;
	private String fileName;
	private Map<String, Contact> contactsMap = new HashMap<String, Contact>();

	public ContactStore(String fileName) {
		this.fileName = fileName;

		try {
			contactWriter = new PrintStream(
					new FileOutputStream(fileName, true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Contact> loadContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));

			String line = reader.readLine();

			while (line != null) {
				Contact contact = parseLine(line);
				contacts.add(contact);
				contactsMap.put(contact.getName(), contact);

				// read the next line
				line = reader.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFileFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return contacts;
	}

	private Contact parseLine(String line) throws InvalidFileFormatException {
		String[] fields = line.split(",");
		if (fields.length != 3) {
			throw new InvalidFileFormatException(
					"Expected 3 fields in the line " + line);
		}

		String name = fields[0];
		String phone = fields[1];
		String dateStr = fields[2];

		SimpleDateFormat format = new SimpleDateFormat(
				"EEE MMM dd HH:mm:ss zzz yyyy");
		Date date = null;
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Contact contact = new Contact(name, phone, date);

		return contact;
	}
	static class ContactComparator implements Comparator<Contact> {

		@Override
		public int compare(Contact o1, Contact o2) {
			return o1.getPhoneNo().compareTo(o2.getPhoneNo());
		}
		
	}
	public static void main(String[] args) {
		ContactStore store = new ContactStore("contacts.csv");
		List<Contact> contacts = store.loadContacts();
		Collections.sort(contacts, new ContactComparator());
		
		for(Contact c : contacts) {
			System.out.println(c);
		}
		
		for (String name : store.contactsMap.keySet()) {
			System.out.println(store.contactsMap.get(name));
		}

		for (Entry<String, Contact> entry : store.contactsMap.entrySet()) {
			System.out.println(entry.getKey() + ":"
					+ store.contactsMap.get(entry.getKey()));
		}
	}

	public void addContacts(List<Contact> contacts) {
		if (contacts == null) {
			return;
		}

		for (Contact c : contacts) {
			contactWriter.println(c);
		}
	}

	public void close() {
		contactWriter.close();
	}
}

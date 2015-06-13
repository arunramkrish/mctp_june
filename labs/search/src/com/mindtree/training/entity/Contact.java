package com.mindtree.training.entity;

import java.util.Date;

public class Contact implements Comparable<Contact> {
	private String name;
	private String phoneNo;
	private Date dateOfBirth;

	public Contact() {
		super();
	}

	public Contact(String name, String phoneNo, Date dateOfBirth) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return name + "," + phoneNo + "," + dateOfBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		return true;
	}

	public static void main(String[] args) {
		Contact a = new Contact("Arun", "9449804064", new Date());
		Contact b = new Contact("Arun", "9449804064", null);

		System.out.println(a.equals(b));
	}

	@Override
	public int compareTo(Contact o) {
		return this.name.toLowerCase().compareTo(o.name.toLowerCase());
	}
}

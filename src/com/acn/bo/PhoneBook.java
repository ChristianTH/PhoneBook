package com.acn.bo;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

	public static final String NOT_FOUND = "No contact found.";

	private static final PhoneBook phoneBook = new PhoneBook();
	private static final String NO_ADDRESS = "No address saved for ";
	private static final String NO_PHONENUMBER = "No phone number saved for ";
	private final Map<String, Contact> contactMap;

	private PhoneBook() {
		contactMap = new HashMap<String, Contact>();
	}

	public static PhoneBook getInstance() {
		return phoneBook;
	}

	public boolean contactExists(String key) {
		return contactMap.containsKey(key);
	}
	
	public String getAddress(String key) {
		Contact contact = this.contactMap.get(key);
		if (contact != null) {
			String address = contact.getPerson().getAddress();
			return address != null ? address : NO_ADDRESS + key;
		}
		return NOT_FOUND;
	}

	public String getPhoneNumber(String key) {
		Contact contact = this.contactMap.get(key);
		if (contact != null) {
			String phonenumber = contact.getPhonenumber();
			return phonenumber != null ? phonenumber : NO_PHONENUMBER + key;			
		}
		return NOT_FOUND;
	}

	public void addContact(String name, String address, String phonenumber) {
		contactMap.put(name, new Contact(new Person(name, address), phonenumber));
	}
	
	public void deleteContact(String key) {
		contactMap.remove(key);
	}
	
}

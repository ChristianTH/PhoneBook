package com.acn.bo;

public class Contact {

	private Person person;
	private String phonenumber;

	public Contact(Person person, String phonenumber) {
		super();
		this.person = person;
		this.phonenumber = phonenumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}

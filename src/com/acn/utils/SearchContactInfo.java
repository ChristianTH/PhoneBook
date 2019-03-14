package com.acn.utils;

import java.util.Scanner;

import com.acn.bo.PhoneBook;

public class SearchContactInfo {

	private static final String ADD = "add ";
	private static final String DELETE = "delete ";
	private static final String CLOSE_APP = "closeapp";
	private static final String BYE = "bye";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String input;
		
		System.out.println("Welcome in PhoneBook.");
		while (true) {
			System.out.println("");
			System.out.print("Name: ");
			input = scanner.nextLine();

			if (input.equals(CLOSE_APP)) {
				System.out.println(BYE);
				break;
			}

			PhoneBook phoneBook = PhoneBook.getInstance();

			if (input.startsWith(DELETE)) {
				input = input.substring(DELETE.length());
				phoneBook.deleteContact(input);
				continue;
			}

			if (input.startsWith(ADD)) {
				input = input.substring(ADD.length());
				String[] splittedInput = input.split(" ");
				phoneBook.addContact(splittedInput[0], splittedInput[1], splittedInput[2]);
				continue;
			}

			if (phoneBook.contactExists(input)) {
				System.out.println(phoneBook.getAddress(input));
				System.out.println(PhoneBook.getInstance().getPhoneNumber(input));
			} else {
				System.out.println(PhoneBook.NOT_FOUND);
			}
		}
		
		scanner.close();
		
	}

}

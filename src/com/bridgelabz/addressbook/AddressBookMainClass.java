package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMainClass {
	private static Scanner sc = new Scanner(System.in);
	private static AddressBook addressbook = new AddressBook();
	private List<Contact> contacts = new ArrayList<>();
	private static AddressBookMainClass addressbooks = new AddressBookMainClass();

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program\n");

		addressbooks.addContacts();

	}

	public void addContacts() {

		String value;

		System.out.println("Do You Want Use Address Book Press Yes for Continue");
		value = sc.next();

		while (value.equals("yes")) {
			System.out.println("Enter your choice");
			System.out
					.println("1 : Add new contact    2 : Edit contact  3 : Delete contact  4: Add Multiple Contacts ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:

				System.out.println("Enter the First Name");
				String firstName = sc.next();

				System.out.println("Enter the Last Name");
				String lastName = sc.next();

				System.out.println("Enter the Address Name");
				String address = sc.next();

				System.out.println("Enter the City Name");
				String city = sc.next();

				System.out.println("Enter the State Name");
				String state = sc.next();

				System.out.println("Enter the Zip Name");
				int zip = sc.nextInt();

				System.out.println("Enter the PhoneNumber");
				long phoneNumber = sc.nextLong();

				System.out.println("Enter the email");
				String email = sc.next();
				Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
				contacts.add(contact);
				addressbook.setContacts(contacts);
				addressbooks.displayContacts(addressbook);

				break;
			case 2:
				System.out.println("Enter the name of user to Edit");
				String nameToEdit = sc.next();
				addressbooks.editContact(nameToEdit);

			case 3:
				System.out.println("Enter the person Name");
				String deletename = sc.next();
				addressbooks.deleteContactDetails(deletename);
				break;

			case 4:

				addressbooks.addMultipleContacts();
				break;

			default:
				System.out.println("Please Enter correct choice");
			}
		}
	}

	public void editContact(String name) {
		List<Contact> contactDetails = addressbook.getContacts();
		for (int i = 0; i <= contactDetails.size() - 1; i++) {

			Contact contactperson = contactDetails.get(i);
			if (contactperson.getFirstName().equals(name)) {

				System.out.println("Please Select Your Choice to Edit");
				System.out.println("1:Firstname 2:Lastname 3:Address 4:City 5:State 6:Zip Code 7:Phone Number");
				int yourChoice = sc.nextInt();
				switch (yourChoice) {
				case 1:
					System.out.println("Enter the First Name");
					String firstName = sc.next();
					contactperson.setFirstName(firstName);

					break;
				case 2:
					System.out.println("Enter the Last Name");
					String lastName = sc.next();
					contactperson.setLastName(lastName);

					break;
				case 3:
					System.out.println("Enter The Address");
					String address = sc.next();
					contactperson.setAddress(address);

					break;
				case 4:
					System.out.println("Enter the city");
					String city = sc.next();
					contactperson.setCity(city);
					break;
				case 5:
					System.out.println("Enter the state");
					String state = sc.next();
					contactperson.setState(state);
					break;
				case 6:
					System.out.println("Enter the zip Code");
					int zip = sc.nextInt();
					contactperson.setZip(zip);
					break;
				case 7:
					System.out.println("Enter the Phone number");
					long phone = sc.nextLong();
					contactperson.setPhoneNumber(phone);
					break;
				default:
					System.out.println("Please Enter correct choice");
					break;
				}
				contactDetails.set(i, contactperson);
				addressbook.setContacts(contactDetails);

			}
		}
		addressbooks.displayContacts(addressbook);
	}

	public void displayContacts(AddressBook addressBook) {
		List<Contact> contactDetails = addressBook.getContacts();

		for (int i = 0; i <= contactDetails.size() - 1; i++) {
			Contact contactperson = contactDetails.get(i);
			if (!contactperson.getFirstName().equals("")) {
				System.out.println("Conatct Details :");
				System.out.println("FirstName :" + contactperson.getFirstName() + "      LastName :"
						+ contactperson.getLastName() + "     Address :" + contactperson.getAddress() + "      City :"
						+ contactperson.getCity() + "       State :" + contactperson.getState() + "     Zip :"
						+ contactperson.getZip() + "     Phone Number :" + contactperson.getPhoneNumber());
			} else {

				System.out.println("No Conatct Details available :");
			}
		}
	}

	public void deleteContactDetails(String name) {
		List<Contact> contactDetails = addressbook.getContacts();
		for (int i = 0; i <= contactDetails.size() - 1; i++) {
			Contact contactperson = contactDetails.get(i);
			if (contactperson.getFirstName().equals(name)) {
				contactDetails.remove(i);
				addressbook.setContacts(contactDetails);
			}
		}
		System.out.println("Contact deleted Successfully");
		addressbooks.displayContacts(addressbook);
	}

	public void addMultipleContacts() {

		System.out.println("Enter the First Name");
		String firstName = sc.next();

		System.out.println("Enter the Last Name");
		String lastName = sc.next();

		System.out.println("Enter the Address Name");
		String address = sc.next();

		System.out.println("Enter the City Name");
		String city = sc.next();

		System.out.println("Enter the State Name");
		String state = sc.next();

		System.out.println("Enter the Zip Name");
		int zip = sc.nextInt();

		System.out.println("Enter the PhoneNumber");
		long phoneNumber = sc.nextLong();

		System.out.println("Enter the email");
		String email = sc.next();
		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
		contacts.add(contact);
		addressbook.setContacts(contacts);

		System.out.println("Do you want add one more Contact Details");
		System.out.println("1 :Yes     2 :No");
		int choice = sc.nextInt();
		switch (choice) {

		case 1:
			addressbooks.addMultipleContacts();
			break;
		case 2:
			addressbooks.displayContacts(addressbook);
			addressbooks.addContacts();
			break;
		default:
			System.out.println("Please Enter correct choice");

		}

		addressbooks.displayContacts(addressbook);
		addressbooks.addContacts();

	}

}

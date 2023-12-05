package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/*
@desc: This Java program serves as an address book management system with a menu-driven interface.
        The main method contains a loop that presents a menu of options to the user, including initializing a new address book,
        adding, editing, and removing contacts, printing contact details and the address book, and exiting the program.
        The program utilizes switch-case statements to handle different user choices.

The major functionalities include:
        Initializing New Address Book: Creates a new AddressBook and adds it to the list.
        Adding New Contact: Retrieves an existing address book and adds a new contact using user input.
        Editing Existing Contact: Edits details of an existing contact within a specified address book.
        Removing Existing Contact: Removes a contact from the specified address book.
        Displaying Address Book: Prints the contents of the specified address book.
        Displaying Contact Details: Prints the details of a specific contact within a specified address book.
 */

public class Main {
    public static final int CREATE_NEW_ADDRESS_BOOK = 1;
    public static final int ADD_NEW_CONTACT = 2;
    public static final int EDIT_EXISTING_CONTACT = 3;
    public static final int REMOVE_EXISTING_CONTACT = 4;
    public static final int DISPLAY_CONTACT_DETAILS = 5;
    public static final int DISPLAY_ADDRESS_BOOK = 6;
    public static final int FILTER_CONTACTS_BY_CITY_NAME = 7;
    public static final int GROUP_ALL_CONTACTS_BY_CITY_NAME = 8;

    public static final int EXIT_PROGRAM = 9;
    public static void main(String[] args) {
        AddressBookApplication newAddressBooks = new AddressBookApplication();

        System.out.println("1.To initialize new address book");
        System.out.println("2.To add contact to the address book");
        System.out.println("3.To edit contact in the address book");
        System.out.println("4.To remove contact from the address book ");
        System.out.println("5.To print the contact details ");
        System.out.println("6.To print the address book");
        System.out.println("7.To print contacts filtered by city name");
        System.out.println("8.group all contacts by city name");
        System.out.println("9.To exit");

        System.out.println("choose an option from the above every time : ");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        String addressId = null;
        while(option != EXIT_PROGRAM){
            if(option != FILTER_CONTACTS_BY_CITY_NAME) {
                System.out.println("Enter the id/username of address book : ");
                addressId = input.next();
            }
            switch(option){
                case CREATE_NEW_ADDRESS_BOOK -> {
                    while(!newAddressBooks.checkDuplicateAddressByAddressId(addressId)){
                        System.out.println("Enter new address id this is already taken");
                        System.out.println("Enter new address id : ");
                        addressId = input.next();
                    }
                    AddressBook registry = new AddressBook(addressId);
                    newAddressBooks.insertAddressBook(registry);
                    System.out.println("address book created");
                }
                case ADD_NEW_CONTACT -> {
                    AddressBook existingRegistry = newAddressBooks.getAddressBook(addressId);
                    if(existingRegistry != null) {
                        boolean isValidContact;
                        ContactPerson newContact;
                        do {
                            System.out.println("Enter Contact Details : ");
                            newContact = AddressBook.getContactDetailsFromUser();
                            isValidContact = existingRegistry.checkDuplicateContactByPersonName(newContact.getFullName());
                            if(!isValidContact){
                                System.out.println("previous details has found a duplicate full name with our database please update it");
                            }
                        }while(!isValidContact);
                        existingRegistry.addContactToAddressBook(newContact);
                    }
                }
                case EDIT_EXISTING_CONTACT -> {
                    AddressBook existingRegistry = newAddressBooks.getAddressBook( addressId);
                    System.out.println("Enter the full name in a single line : ");
                    input.nextLine();
                    String fullName = input.nextLine();
                    if(existingRegistry != null) {
                        ContactPerson existingContact = existingRegistry.getContactDetail(fullName);
                        if (existingContact != null) {
                            existingRegistry.OptionsToEditContactDetails(existingContact);
                        }
                    }
                }
                case REMOVE_EXISTING_CONTACT -> {
                    AddressBook existingRegistry =  newAddressBooks.getAddressBook( addressId);
                    System.out.println("Enter the full name in a single line : ");
                    input.nextLine();
                    String fullName = input.nextLine();
                    if(existingRegistry != null) {
                        existingRegistry.removeContactFromAddressBookByName(fullName);
                    }
                }
                case DISPLAY_ADDRESS_BOOK -> {
                    AddressBook existingRegistry = newAddressBooks.getAddressBook( addressId);
                    System.out.println("Address Book : \n" + existingRegistry);
                }
                case DISPLAY_CONTACT_DETAILS -> {
                    AddressBook existingRegistry = newAddressBooks.getAddressBook( addressId);
                    System.out.println("Enter the full name in a single line : ");
                    input.nextLine();
                    String fullName = input.nextLine();
                    if(existingRegistry != null) {
                        ContactPerson existingContact = existingRegistry.getContactDetail(fullName);
                        if (existingContact != null) {
                            System.out.println("Contact Details : \n" + existingContact);
                        }
                    }
                }
                case FILTER_CONTACTS_BY_CITY_NAME -> {
                    System.out.println("Enter the city name: ");
                    String cityName = input.next();
                    ArrayList<ContactPerson> filteredContactByCity = newAddressBooks.getAllContactByCity(cityName);
                     System.out.println("filterd contacts are : " + filteredContactByCity);

                }
                case GROUP_ALL_CONTACTS_BY_CITY_NAME->{
                    System.out.println();
                    Map<String , List<ContactPerson>> contactsGroupByCity =  newAddressBooks.getAllContactsByCityAndGroupThem();

                    contactsGroupByCity.forEach((city, contactPersons) ->
                            System.out.println("City: " + city + ", Contact Count: " + contactPersons.size())
                    );

                    System.out.println("sorted by city name : " + contactsGroupByCity);
                }

                default -> System.out.println("Choose the correct from the given option");

            }
            System.out.println("choose an option from the above every time : ");
            option = input.nextInt();
        }
    }
}

package com.bridgelabz.AddressBook;

import java.util.ArrayList;
import java.util.Scanner;

/*
@desc : The class AddressBook is used to store a group of contacts , each address book has a specific id , an array of contacts
        it has methods such as to get the contact by using full name , to verify fullname , and function to give user menu to edit
        the contact once created , method to create , remove the contact .
 */
public class AddressBook {
    public String addressBookId;
    ArrayList<ContactPerson> contacts;

    /*
    @desc : it returns the unique id of the address book
    @params : no params
    @return : returns an addressbookid in string format
     */
    public String getAddressBookId() {
        return addressBookId;
    }

    /*
    @desc : parameter constructor , initializes the address book and its contacts list
    @params : addressBookId - an address book id in string format
    @return : no return , its just initializes
     */
    public AddressBook(String addressBookId) {
        this.addressBookId = addressBookId;
        this.contacts = new ArrayList<>();
    }

    /*
    @desc : addContactToAddressBook is a function , it will add the new contact to your contact book
    @param : user - it is a contactPerson user which has all required fields
    @return : it just adds , won't return anything
     */
    public void addContactToAddressBook(ContactPerson user){
        contacts.add(user);
        System.out.println("contact has been added to Address Book");
    }

    /*
    @desc: removeContactFromAddressBookByName, is designed to remove a contact from an address book based on the provided full name.
         It iterates through the contacts in the address book, and if a contact with a matching full name is found,
         it is removed from the address book. The method then prints a message indicating whether the contact was successfully removed or not.
     @params: fullName (String) - The full name of the contact to be removed from the address book.
     @return: This method does not have a return type (void). It performs the operation of removing a contact from the address book.
     */
    public void removeContactFromAddressBookByName(String fullName){
        for(ContactPerson user : contacts){
            if(user.getFullName().equals(fullName)){
                contacts.remove(user);
                System.out.println("Contact has been removed from the address book");
                return;
            }
        }
        System.out.println("Contact has been not found in the address book");
    }

   /*
   @desc:   getValidationFullName, serves to validate whether a provided full name is unique within a collection of ContactPerson objects.
            It iterates through the existing contacts, checking if any contact already has the specified full name. If a match is found,
            it prints a message indicating that a contact with the same full name exists,
            and the method returns false to signify that a new contact cannot be created. If no match is found, it prints a message stating that the name is unique and returns true.
    @params: fullName (String) - The full name to be validated for uniqueness.
    @return: This method returns a boolean value, true if the provided full name is unique, and false if it already exists in the collection of contacts
    */

    public boolean getValidationFullName(String fullName){
        for(ContactPerson user : contacts){
            if(user.getFullName().equals(fullName)){
                System.out.println("This Full name has a contact with other user \n so contact cant be created");
                return false;
            }
        }
        System.out.println("This Name is unique");
        return true;
    }

    /*
    @desc: getContactDetailsFromUser, facilitates the input of contact details from the user through the console.
             It gathers information such as contact ID, first name, last name, address, city, pincode, phone number, and email.
             The method prompts the user for each piece of information and ensures proper handling of input using next() and nextLine() methods.
             After collecting the necessary details, it creates a new ContactPerson object with the provided information and returns it.
     @param : no params
     @return : returns an object instance of ContactPerson
     */
    public static ContactPerson getContactDetailsFromUser(){
        Scanner inputContact = new Scanner(System.in);
        String firstName , lastName , address , city , pincode , phoneNumber , email , contactId;
        System.out.print("\nEnter contact id : ");
        contactId = inputContact.next();
        System.out.print("\nEnter First name : ");
        firstName = inputContact.next();
        System.out.print("\nEnter Last name : ");
        lastName = inputContact.next();
        System.out.print("\nEnter address in single line: ");
        inputContact.nextLine();
        address = inputContact.nextLine();
        System.out.print("\nEnter city in single word : ");
        city = inputContact.next();
        System.out.print("\nEnter pincode : ");
        pincode = inputContact.next();
        System.out.print("\nEnter phone number : ");
        phoneNumber = inputContact.next();
        System.out.print("\nEnter email : ");
        email = inputContact.next();
        return new ContactPerson(firstName , lastName , address , city , pincode , phoneNumber , email , contactId);
    }

    /*
    @desc: OptionsToEditContactDetails, provides a console-based menu for users to edit various details of a contact.
            It presents a menu with options to edit the first name, last name, address, city, pincode, phone number, and email of an existing contact.
            The method utilizes a while loop to repeatedly prompt the user until they choose to exit.
    @param: existingContact (Type: ContactPerson): The contact whose details are to be edited.
    @return: This method doesn't return any value (void).
     */

    public void OptionsToEditContactDetails(ContactPerson existingContact){
        Scanner input = new Scanner(System.in);
        System.out.println("1. To Edit first name enter FirstName");
        System.out.println("2. To Edit last name enter LastName");
        System.out.println("3. To Edit address enter Address ");
        System.out.println("4. To Edit city enter City ");
        System.out.println("5. To Edit pincode enter Pincode ");
        System.out.println("6. To Edit phone number enter PhoneNumber");
        System.out.println("7. To Edit email enter Email ");
        System.out.println("8  To Exit enter Exit");
        System.out.println("choose an option from till you wanted to edit");
        String choose = input.next();
        String newValue;
        while(!choose.equals("Exit")){
            switch(choose){
                case ContactPerson.EDIT_FIRST_NAME ->{
                    System.out.println("Enter you new first name : ");
                    newValue = input.next();
                    existingContact.editContactDetails(ContactPerson.EDIT_FIRST_NAME , newValue);
                }
                case ContactPerson.EDIT_LAST_NAME -> {
                    System.out.println("Enter you new last name : ");
                    newValue = input.next();
                    existingContact.editContactDetails(ContactPerson.EDIT_LAST_NAME , newValue);
                }
                case ContactPerson.EDIT_CITY -> {
                    System.out.println("Enter you new city : ");
                    newValue = input.next();
                    existingContact.editContactDetails(ContactPerson.EDIT_CITY , newValue);
                }
                case ContactPerson.EDIT_PIN_CODE -> {
                    System.out.println("Enter you new pincode : ");
                    newValue = input.next();
                    existingContact.editContactDetails(ContactPerson.EDIT_PIN_CODE , newValue);
                }
                case ContactPerson.EDIT_PHONE_NUMBER -> {
                    System.out.println("Enter you new phone number : ");
                    newValue = input.next();
                    existingContact.editContactDetails(ContactPerson.EDIT_PHONE_NUMBER , newValue);
                }
                case ContactPerson.EDIT_EMAIL -> {
                    System.out.println("Enter you new email : ");
                    newValue = input.next();
                    existingContact.editContactDetails(ContactPerson.EDIT_EMAIL , newValue);
                }
                case ContactPerson.EDIT_ADDRESS->{
                    System.out.println("Enter you new address : ");
                    newValue = input.nextLine();
                    existingContact.editContactDetails(ContactPerson.EDIT_ADDRESS , newValue);
                }
                default -> {
                    System.out.println("enter the key value correctly , id and full cant be changes by user");
                }
            }
            System.out.println("choose an option from till you wanted to edit");
            choose = input.next();
        }
    }

    /*
       @desc: getContactDetail, is designed to return a contact from an address book based on the provided full name.
             It iterates through the contacts in the address book, and if a contact with a matching full name is found, it is returns
    @params: fullName (String) - The full name of the contact to be removed from the address book.
    @return: returns the matched ContactPerson object

     */
    public ContactPerson getContactDetail(String fullName){
        for(ContactPerson details : contacts){
            if(details.getFullName().equals(fullName)){
                return details;
            }
        }
        System.out.println("Contact not found with name " + fullName + " in the address book");
        return null;
    }

    /*
    @desc : it returns the complete address book as a string format
    @param : no params
    @return : a string which contain all the details of the address book
     */

    public String toString() {
        return "{" +
                "\naddressBookId : " + addressBookId + "\n "+
                "contacts : " + contacts +
                '}';
    }
}

package com.bridgelabz.AddressBook;

import java.util.Scanner;

public class AddressBookApplication {
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
    public static void main(String[] args) {
        System.out.println("!! Welcome to address book program !! ");
        //usecase 1
        ContactPerson newContact = getContactDetailsFromUser();
        System.out.println("enter contact is : " + newContact);
    }
}

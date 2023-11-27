package com.bridgelabz.AddressBook;

import java.util.*;


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

public class AddressBookApplication {

    public static final int CREATE_NEW_ADDRESS_BOOK = 1;
    public static final int ADD_NEW_CONTACT = 2;
    public static final int EDIT_EXISTING_CONTACT = 3;
    public static final int REMOVE_EXISTING_CONTACT = 4;
    public static final int DISPLAY_CONTACT_DETAILS = 5;
    public static final int DISPLAY_ADDRESS_BOOK = 6;

    public static final int EXIT_PROGRAM = 7;

    // Create a Dictionary to store AddressBook objects with unique keys (addressId)
    private static HashMap<String, AddressBook> addressBookDictionary = new HashMap<>();

    // Method to check if the addressId is available in the Dictionary
    /*
     * @desc : Checks if the specified addressId is available in the AddressBook Dictionary.
     *
     * @param addressId The unique identifier for the AddressBook.
     * @return true if the addressId is available, false otherwise.
     */
    public static boolean isAddressIdAvailable(String addressId) {
        if(addressBookDictionary.isEmpty()){
            return false;
        }
        return addressBookDictionary.containsKey(addressId);
    }

    // Method to insert an AddressBook into the Dictionary
    /*

     @desc : Inserts an AddressBook into the AddressBook Dictionary.
     @param addressId The unique identifier for the AddressBook.
     @param addressBook The AddressBook object to be inserted.
     */
    public static void insertAddressBook(String addressId, AddressBook addressBook) {
        addressBookDictionary.put(addressId, addressBook);
    }

    // Method to get an AddressBook from the Dictionary
    /*

     @desc : Retrieves an AddressBook from the AddressBook Dictionary based on the specified addressId.
     @param addressId The unique identifier for the AddressBook.
     @return The AddressBook object associated with the provided addressId, or null if not found.
     */
    public static AddressBook getAddressBook(String addressId) {
        return addressBookDictionary.get(addressId);
    }

    // Method to remove an AddressBook from the Dictionary
    /*

     @desc : Removes an AddressBook from the AddressBook Dictionary based on the specified addressId.
     @param addressId The unique identifier for the AddressBook to be removed.
     @return : no return
     */
    public static void removeAddressBook(String addressId) {
        addressBookDictionary.remove(addressId);
    }



    /*
@desc: getAddressFromAddressBook, searches for an AddressBook object within an ArrayList<AddressBook> based on a provided addressId.
        If a match is found, the corresponding AddressBook is returned. If no match is found,
        a message is printed to the console indicating that there is no book with the specified address ID.
@param: addressBookArrayList (Type: ArrayList<AddressBook>): The list of address books to search through.
        addressId (Type: String): The ID of the address book to be retrieved.
@return:
        Type: AddressBook if a match is found.
        Type: null if no matching address book is found.
     */
    public static AddressBook getAddressFromAddressBook(ArrayList<AddressBook>addressBookArrayList , String addressId){
        for(AddressBook book : addressBookArrayList){
            if(book.getAddressBookId().equals(addressId)){
                return book;
            }
        }
        System.out.println("There is no book with " + addressId + " id");
        return null;
    }

    /*
@desc: isAddressIdAvailable, searches for an AddressBook object within an ArrayList<AddressBook> based on a provided addressId.
    If a match is found, the false is return. If no match is found,then return true.
@param: addressBookArrayList (Type: ArrayList<AddressBook>): The list of address books to search through.
    addressId (Type: String): The ID of the address book to be retrieved.
@return:
    Type: boolean - true / false.
 */
    public static boolean isAddressIdAvailable(ArrayList<AddressBook>addressBookArrayList , String addressId){
        for(AddressBook book : addressBookArrayList){
            if(book.getAddressBookId().equals(addressId)){
                System.out.println("There is  book with " + addressId + " id");
                return false;
            }
        }

        return true;
    }


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

    public static void main(String[] args) {

        System.out.println("1.To initialize new address book");
        System.out.println("2.To add contact to the address book");
        System.out.println("3.To edit contact in the address book");
        System.out.println("4.To remove contact from the address book ");
        System.out.println("5.To print the contact details ");
        System.out.println("6.To print the address book");
        System.out.println("7.To exit");

        System.out.println("choose an option from the above every time : ");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        String addressId;
        ArrayList<AddressBook> addressBookArrayList = new ArrayList<>();
        while(option != EXIT_PROGRAM){
            System.out.println("Enter the id/username of address book : ");
            addressId = input.next();
            switch(option){
                case CREATE_NEW_ADDRESS_BOOK -> {
                    while(isAddressIdAvailable(addressId)){
                        System.out.println("Enter new address id this is already taken");
                        System.out.println("Enter new address id : ");
                        addressId = input.next();
                    }
                    AddressBook registery = new AddressBook(addressId);
                    addressBookArrayList.add(registery);
                    insertAddressBook(addressId , registery);
                    System.out.println("address book created");
                }
                case ADD_NEW_CONTACT -> {
                    AddressBook existingRegistry = getAddressFromAddressBook(addressBookArrayList , addressId);
                    if(existingRegistry != null) {
                        ContactPerson newContact = AddressBook.getContactDetailsFromUser();
                        existingRegistry.addContactToAddressBook(newContact);
                    }
                }
                case EDIT_EXISTING_CONTACT -> {
                    AddressBook existingRegistry = getAddressFromAddressBook(addressBookArrayList , addressId);
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
                    AddressBook existingRegistry = getAddressFromAddressBook(addressBookArrayList , addressId);
                    System.out.println("Enter the full name in a single line : ");
                    input.nextLine();
                    String fullName = input.nextLine();
                    if(existingRegistry != null) {
                        existingRegistry.removeContactFromAddressBookByName(fullName);
                    }
                }
                case DISPLAY_ADDRESS_BOOK -> {
                    AddressBook existingRegistry = getAddressFromAddressBook(addressBookArrayList , addressId);
                    System.out.println("Address Book : \n" + existingRegistry);
                }
                case DISPLAY_CONTACT_DETAILS -> {
                    AddressBook existingRegistry = getAddressFromAddressBook(addressBookArrayList , addressId);
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
                default -> System.out.println("Choose the correct from the given option");

            }
            System.out.println("choose an option from the above every time : ");
            option = input.nextInt();
        }
    }
}

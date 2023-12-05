package com.bridgelabz.addressbook;


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

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AddressBookApplication {

  private ArrayList<AddressBook> stackOfAddressBooks;

    public AddressBookApplication() {
        stackOfAddressBooks = new ArrayList<>();
    }


    // Method to check if the addressId is available in the Dictionary
    /*
     * @desc : Checks if the specified addressId is available in the AddressBook Dictionary.
     *
     * @param addressId The unique identifier for the AddressBook.
     * @return true if the addressId is available, false otherwise.
     */
/*
@desc : finding the duplicate contact in our address book by fuyll name as unique key
@params : String - full name
@return : boolean
 */

    public  boolean checkDuplicateAddressByAddressId(String addressId){
        if(stackOfAddressBooks.isEmpty()){
            return true;
        }
        int noOfPeopleMatched = (int) stackOfAddressBooks.stream().
                filter((address)->address.getAddressBookId().equals(addressId)).count();
        return noOfPeopleMatched==0;
    }

    public void addAddressToAddressBook(AddressBook address){
        if(stackOfAddressBooks.isEmpty() || checkDuplicateAddressByAddressId(address.getAddressBookId())){
            stackOfAddressBooks.add(address);
            System.out.println("address has been added to Address Book");
        }else{
            System.out.println("Theres id is already preset in our address books");
        }
    }


    public void removeAddressFromAddressBook(String addressId){
           stackOfAddressBooks.removeIf(address -> address.getAddressBookId().equals(addressId));
    }

    // Method to insert an AddressBook into the Dictionary
    /*

     @desc : Inserts an AddressBook into the AddressBook Dictionary.
     @param addressId The unique identifier for the AddressBook.
     @param addressBook The AddressBook object to be inserted.
     */
    public  void insertAddressBook(AddressBook addressBook) {
        addAddressToAddressBook(addressBook);
    }

    // Method to get an AddressBook from the Dictionary
    /*

     @desc : Retrieves an AddressBook from the AddressBook Dictionary based on the specified addressId.
     @param addressId The unique identifier for the AddressBook.
     @return The AddressBook object associated with the provided addressId, or null if not found.
     */
    public  AddressBook getAddressBook(String addressId) {
       return stackOfAddressBooks.stream()
                .filter(addressBook -> addressBook.getAddressBookId().equals(addressId))
                .findFirst()
                .orElse(null);
    }

    // Method to remove an AddressBook from the Dictionary
    /*

     @desc : Removes an AddressBook from the AddressBook Dictionary based on the specified addressId.
     @param addressId The unique identifier for the AddressBook to be removed.
     @return : no return
     */
    public  void removeAddressBook(String addressId) {
        removeAddressFromAddressBook(addressId);
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
    public static AddressBook getAddressFromAddressBook(ArrayList<AddressBook> addressBookArrayList , String addressId){
        for(AddressBook book : addressBookArrayList){
            if(book.getAddressBookId().equals(addressId)){
                return book;
            }
        }
        System.out.println("There is no book with " + addressId + " id");
        return null;
    }

/*
@desc : finding all contacts using city name from all address books
@prams - String - city name
@return - ArrayList<ContactPerson>
 */
    public ArrayList<ContactPerson> getAllContactByCity(String city){
        return stackOfAddressBooks.stream()
                .flatMap(addressBook -> addressBook.getContacts().stream())
                .filter(contact -> contact.getCity().equals(city))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /*
@desc: isAddressIdAvailable, searches for an AddressBook object within an ArrayList<AddressBook> based on a provided addressId.
    If a match is found, the false is return. If no match is found,then return true.
@param: addressBookArrayList (Type: ArrayList<AddressBook>): The list of address books to search through.
    addressId (Type: String): The ID of the address book to be retrieved.
@return:
    Type: boolean - true / false.
 */
    public boolean isAddressIdAvailable(String addressId){
        return stackOfAddressBooks.stream().anyMatch(address -> address.getAddressBookId().equals(addressId)); // Check if any address has the specified addressId
    }




}

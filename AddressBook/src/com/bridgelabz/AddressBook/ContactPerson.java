package com.bridgelabz.AddressBook;
/*
@desc :
     this class is to create a behavior of a contact person , which has details like , name , address , city , pincode , email , phonhe number
     where we can edit , and set these details , and can print complete person details.
     but id is immutable
     it is a public class , we can use this class in any package
 */

public class ContactPerson {
    public static final String EDIT_FIRST_NAME = "FirstName";
    public static final String EDIT_LAST_NAME = "LastName";
    public static final String EDIT_ADDRESS = "Address";
    public static final String EDIT_CITY = "City";
    public static final String EDIT_PHONE_NUMBER = "PhoneNumber";
    public static final String EDIT_PIN_CODE = "Pincode";
    public static final String EDIT_EMAIL = "Email";
    private String firstName;
    private String lastName;
    private String fullName;
    private String address;
    private String city;
    private String pincode;
    private String phoneNumber;
    private String email;
    private String id;

    /*
    @desc : default constructor , initialzes with empty values for the person
    @param : no parameters
    @return : don't return
     */
    public ContactPerson(){
        this("" , "" , "" , "" , "" , "" , "" , "");
    }

    /*
    @desc: This Java constructor initializes a ContactPerson object with the provided parameters,
           setting various attributes like first name, last name, address, etc.
           It calculates the full name by concatenating the first and last names.
    @params:
            firstName (String) - The first name of the contact person.
            lastName (String) - The last name of the contact person.
            address (String) - The address of the contact person.
            city (String) - The city of the contact person.
            pincode (String) - The pin code of the contact person's location.
            phoneNumber (String) - The phone number of the contact person.
            email (String) - The email address of the contact person.
            id (String) - The unique identifier for the contact person.
    @return: This constructor does not have a return type (void). It is used to initialize the attributes of the ContactPerson object.
     */
    public ContactPerson(String firstName, String lastName, String address, String city, String pincode, String phoneNumber, String email , String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id = id;
        this.fullName = firstName + " " + lastName;
    }





    /*
      @desc : it gives first name of the contact person
      @params : no parameter
      @return : return firstName(string) of a person
     */
    public String getFirstName() {
        return firstName;
    }

    /*
  @desc : it sets/updates the first name of the person
  @params : no parameter
  @return : don't return
 */
    public void setFirstName(String firstName) {
        this.fullName = firstName +" "+ this.lastName;
        this.firstName = firstName;
    }
    /*
      @desc : it gives last name of the contact person
      @params : no parameter
      @return : return lastName(string) of a person
     */
    public String getLastName() {
        return lastName;
    }
    /*
  @desc : it sets/updates the last name of the person
  @params : no parameter
  @return : don't return
 */
    public void setLastName(String lastName) {
        this.fullName = this.firstName +" "+ lastName;
        this.lastName = lastName;
    }

    /*
  @desc : it gives address of the contact person
  @params : no parameter
  @return : return address(string) of a person
 */
    public String getAddress() {
        return address;
    }

    /*
@desc : it sets/updates the  address of the person
@params : no parameter
@return : don't return
*/
    public void setAddress(String address) {
        this.address = address;
    }

    /*
  @desc : it gives city  of the contact person
  @params : no parameter
  @return : return city(string) of a person
 */
    public String getCity() {
        return city;
    }
    /*
  @desc : it sets/updates the city of the person
  @params : no parameter
  @return : don't return
 */
    public void setCity(String city) {
        this.city = city;
    }
    /*
      @desc : it gives pincode of the contact person
      @params : no parameter
      @return : return pincode(string) of a person
     */
    public String getPincode() {
        return pincode;
    }
    /*
  @desc : it sets/updates the pincode of the person
  @params : no parameter
  @return : don't return
 */
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    /*
  @desc : it gives phone number of the contact person
  @params : no parameter
  @return : return phoneNumber(string) of a person
 */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /*
  @desc : it sets/updates the phone number of the person
  @params : no parameter
  @return : don't return
 */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*
  @desc : it gives email of the contact person
  @params : no parameter
  @return : return email(string) of a person
 */
    public String getEmail() {
        return email;
    }
    /*
      @desc : it gives full name of the contact person
      @params : no parameter
      @return : return fullname(string) of a person
     */
    public String getFullName() {
        return fullName;
    }

    /*
  @desc : it gives details of the contact person
  @params : no parameter
  @return : return complete person details as string
 */
    public String toString() {
        return "{" +
                "\nfirstName = " + firstName + ",\n" +
                "lastName = " + lastName + ",\n" +
                "fullName = " + fullName + ",\n" +
                "address = " + address + ",\n" +
                "city = " + city + ",\n" +
                "pincode = " + pincode + ",\n" +
                "phoneNumber = " + phoneNumber + ",\n" +
                "email = " + email + ",\n" +
                "id = " + id + "\n" +
                "}\n";
    }
    /*
  @desc : it sets/updates the email of the person
  @params : no parameter
  @return : don't return
 */
    public void setEmail(String email) {
        this.email = email;
    }
    /*
  @desc : it gives specific id  of the contact person
  @params : no parameter
  @return : return id(string) of a person
 */

    public String getId() {
        return id;
    }

/*
@desc : The method editContactDetails edits contact details
       based on the provided key and new value using a switch statement.
 @param : key: The key representing the contact detail to edit.
          newValue: The new value to set for the specified contact detail
  @return : no return
 */
    public void editContactDetails(String key, String newValue) {
        switch (key){
            case EDIT_FIRST_NAME -> setFirstName(newValue);
            case EDIT_LAST_NAME -> setLastName(newValue );
            case EDIT_ADDRESS -> setAddress(newValue);
            case EDIT_CITY -> setCity(newValue);
            case EDIT_PIN_CODE -> setPincode(newValue);
            case EDIT_PHONE_NUMBER -> setPhoneNumber(newValue);
            case EDIT_EMAIL -> setEmail(newValue);
            default->System.out.println("choose proper key to edit");
        }
    }
}


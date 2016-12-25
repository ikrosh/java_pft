package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String email;
  private final String home;
  private final String address;

  public ContactData(String firstname, String middlename, String lastname, String email, String home, String address) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.email = email;
    this.home = home;
    this.address = address;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getEmail() {
    return email;
  }

  public String getHome() {
    return home;
  }

  public String getAddress() {
    return address;
  }
}

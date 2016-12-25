package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    initContactCreation();
    fillContactForm(new ContactData("test1", "test2", "test4", "test@gmail.com", "1112223334455", "test3"));
    submitContactCreation();
  }

}

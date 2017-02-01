package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification () {
    app.getNavigationHelper().goToContactPage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", "test2", "test4", "test@gmail.com", null, null));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm (new ContactData("test1", "test2", "test4", "test@gmail.com", "1112223334455", "test3"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToContactPage();

  }

}

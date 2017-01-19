package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification () {
    app.getNavigationHelper().goToContactPage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm (new ContactData("test1", "test2", "test4", "test@gmail.com", "1112223334455", null, null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToContactPage();

  }

}

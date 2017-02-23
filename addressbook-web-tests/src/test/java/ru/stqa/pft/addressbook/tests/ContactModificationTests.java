package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification () {
    app.getNavigationHelper().goToContactPage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", "test2", "test4", "test@gmail.com", null, null));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    //int before;
    //before = app.getContactHelper().getContactCount();
    //app.getContactHelper().selectContact(before - 1);//Contact selection by index (now it is the penultimate element)

    app.getContactHelper().initContactModification(before.size() - 1);
    app.getContactHelper().fillContactForm (new ContactData("test1", "test2", "test4", "test@gmail.com", "1112223334455", "test3"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

  }

}

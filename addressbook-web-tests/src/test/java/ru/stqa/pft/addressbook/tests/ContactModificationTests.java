package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goToContactPage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("test1").withMiddlename("test2")
              .withLastname("test4").withEmail("test@gmail.com"));
    }
  }

  @Test
  public void testContactModification () {

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("test4")
            .withMiddlename("test4").withLastname("test4").withEmail("test@gmail.com")
            .withHome("1112223334455").withAddress("test3");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }



}











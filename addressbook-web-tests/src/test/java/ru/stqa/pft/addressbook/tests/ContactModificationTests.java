package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goToContactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("test1").withMiddlename("test2")
              .withLastname("test4").withEmail("test@gmail.com"));
    }
  }

  @Test
  public void testContactModification () {

    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("test4")
            .withMiddlename("test4").withLastname("test4").withEmail("test@gmail.com")
            .withHome("1112223334455").withAddress("test3");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size() ));
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}











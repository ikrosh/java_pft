package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToContactPage();
        int before = app.getContactHelper().getContactCount();
        System.out.println ("b=" + before);
        if (! app.getContactHelper().isThereAContact()) {
           app.getContactHelper().createContact(new ContactData("test1", "test2", "test4", "test@gmail.com", null, null));
        }
        app.getContactHelper().selectContact(before);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().conformContactDeletion();
        app.getNavigationHelper().goToContactPage();
        int after = app.getGroupHelper().getGroupCount();
        System.out.println ("a=" + after);
        Assert.assertEquals(after, before - 1);
    }

}

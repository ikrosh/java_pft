package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.goToGroupPage();
        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().deleteSelectedGroups();
        app.getGroupsHelper().returnToGroupPage();
    }

}

package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
   click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("email"), contactData.getEmail());
    type(By.name("home"), contactData.getHome());
    type(By.name("address"), contactData.getAddress());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

    //click(By.name("selected[]"));
  }

  public void conformContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification(int index) {
    //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    wd.findElements(By.name("entry")).get(index).findElement(By.xpath("td[8]/a/img")).click();
  }

  public void submitContactModification() { click(By.name("update"));
  }



    //public int getContactCount() {
    //  return wd.findElements(By.name("selected[]")).size();
    //}

    //public void selectContact(int index) {
    //  wd.findElements(By.xpath("//*[@id='maintable']/tbody/tr/td[8]")).get(index).click();
    //  }



  public void createContact(ContactData contactData) {
    initContactCreation();
    fillContactForm(contactData);
    submitContactCreation();
  }

  public boolean isThereAContact() { return isElementPresent(By.name("selected[]"));  }

  //public int getContactCount() {
  //  return wd.findElements(By.name("entry")).size();
  //}

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr.entry"));
    for (WebElement element : elements) {
      String name = element.getText();
      ContactData contact = new ContactData("test1", "test2", "test4", "test@gmail.com", "1112223334455", "test3");
      contacts.add(contact);
    }
    return contacts;
  }


}

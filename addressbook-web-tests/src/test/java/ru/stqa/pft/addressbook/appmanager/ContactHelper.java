package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

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

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void conformContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() { click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")); }

  public void submitContactModification() { click(By.name("update"));
  }

  public void createContact(ContactData contactData) {
    initContactCreation();
    fillContactForm(contactData);
    submitContactCreation();
  }

  public boolean isThereAContact() { return isElementPresent(By.name("selected[]"));  }

  public int getContactCount() {
    return wd.findElements(By.name("entry")).size();
  }
}

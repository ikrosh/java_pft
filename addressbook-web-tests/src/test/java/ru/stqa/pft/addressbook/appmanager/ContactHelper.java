package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public void selectContact(int index) {
    if (!wd.findElements(By.name("selected[]")).get(index).isSelected()) {
      wd.findElements(By.name("selected[]")).get(index).click();
    }
  }

  public void initContactModification(int index) {
    wd.findElements(By.name("entry")).get(index).findElement(By.xpath("td[8]/a/img")).click();
    //click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    //click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void conformContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contactData) {
    initContactCreation();
    fillContactForm(contactData);
    submitContactCreation();
  }

  public void modify(int index, ContactData contact) {
    initContactModification(index);
    fillContactForm (contact);
    submitContactModification();
    //goTo().goToContactPage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContact();
    conformContactDeletion();
    //app.goTo().goToContactPage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement element : rows){
            String firstname = element.findElements(By.tagName("td")).get(2).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            contacts.add(new ContactData().withId(id).withFirstname(firstname)
                      .withLastname(lastname));
        }
        return contacts;
      }

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement element : rows){
      String firstname = element.findElements(By.tagName("td")).get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = element.findElements(By.tagName("td")).get(1).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname)
              .withLastname(lastname));
    }
    return contacts;
  }

}



















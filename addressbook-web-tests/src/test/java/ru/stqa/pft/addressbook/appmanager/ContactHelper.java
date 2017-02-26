package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("address"), contactData.getAddress());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("mobile"), contactData.getMobilePhone());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void selectContact(int index) {
    //if (!wd.findElements(By.name("selected[]")).get(index).isSelected()) {
      wd.findElements(By.name("selected[]")).get(index).click();
    //}
  }

    public void selectContactById(int id) {
    //if (!wd.findElement(By.cssSelector("input[value='" + id +"']")).isSelected()) {
    wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
  // }
  }

  public void initContactModification(int index) {
    wd.findElements(By.name("entry")).get(index).findElement(By.xpath("td[8]/a/img")).click();
    //click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector("a[href*='edit.php?id="+id+"']")).click();
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
    contactCache = null;
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm (contact);
    submitContactModification();
    contactCache = null;
    //goTo().goToContactPage();
  }

  /*
  public void delete(int index) {

    selectContact(index);
    deleteSelectedContact();
    conformContactDeletion();
    //app.goTo().goToContactPage();
  }
  */

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    conformContactDeletion();
    contactCache = null;
    //app.goTo().goToContactPage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  /*
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
  */

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement element : rows){
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = element.findElements(By.tagName("td")).get(2).getText();
      String lastname = element.findElements(By.tagName("td")).get(1).getText();
      String allPhones = element.findElements(By.tagName("td")).get(5).getText();
      String[] phones = element.findElements(By.tagName("td")).get(5).getText().split("\n");
      contactCache.add(new ContactData().withId(id).withFirstname(firstname)
              .withLastname(lastname).withAllPhones(allPhones));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    app.goTo().homePage();
    return new ContactData().withId(contact.getId()).withFirstname("test1").withMiddlename("test2")
            .withLastname("test4").withEmail("test@gmail.com").withMobilePhone(mobilePhone).withWorkPhone(workPhone);
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();

  }




}



















package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  FirefoxDriver wd;

  private final GroupsHelper groupsHelper = new GroupsHelper();

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupsHelper = new GroupsHelper(wd);
    login("admin", "secret");
  }

  private void login(String username, String password) {
    groupsHelper.wd.findElement(By.name("user")).click();
    groupsHelper.wd.findElement(By.name("user")).clear();
    groupsHelper.wd.findElement(By.name("user")).sendKeys(username);
    groupsHelper.wd.findElement(By.name("pass")).click();
    groupsHelper.wd.findElement(By.name("pass")).clear();
    groupsHelper.wd.findElement(By.name("pass")).sendKeys(password);
    groupsHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void goToGroupPage() {
    groupsHelper.wd.findElement(By.linkText("groups")).click();
  }

  public void stop() {
    groupsHelper.wd.quit();
  }

  public void submitContactCreation() {
    groupsHelper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData) {
    groupsHelper.wd.findElement(By.name("firstname")).click();
    groupsHelper.wd.findElement(By.name("firstname")).clear();
    groupsHelper.wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    groupsHelper.wd.findElement(By.name("middlename")).click();
    groupsHelper.wd.findElement(By.name("middlename")).clear();
    groupsHelper.wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
    groupsHelper.wd.findElement(By.name("lastname")).click();
    groupsHelper.wd.findElement(By.name("lastname")).clear();
    groupsHelper.wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    groupsHelper.wd.findElement(By.name("email")).click();
    groupsHelper.wd.findElement(By.name("email")).clear();
    groupsHelper.wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    groupsHelper.wd.findElement(By.name("home")).click();
    groupsHelper.wd.findElement(By.name("home")).clear();
    groupsHelper.wd.findElement(By.name("home")).sendKeys(contactData.getHome());
    groupsHelper.wd.findElement(By.name("address")).click();
    groupsHelper.wd.findElement(By.name("address")).clear();
    groupsHelper.wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
  }

  public void initContactCreation() {
    groupsHelper.wd.findElement(By.linkText("add new")).click();
  }

  public GroupsHelper getGroupsHelper() {
    return groupsHelper;
  }
}

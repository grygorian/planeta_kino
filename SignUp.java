package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUp {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSignUp() throws Exception {
    driver.get("https://planetakino.ua/odessa2/");
    driver.findElement(By.linkText("Реєстрація")).click();
    try {
      assertTrue(isElementPresent(By.id("btn-login-page")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("signupform-email")).click();
    driver.findElement(By.id("signupform-email")).clear();
    driver.findElement(By.id("signupform-email")).sendKeys("dfgadfgdfg@fgdfgdf.fgd");
    driver.findElement(By.id("signupform-password")).click();
    driver.findElement(By.id("signupform-password")).clear();
    driver.findElement(By.id("signupform-password")).sendKeys("Test111");
    driver.findElement(By.id("signupform-passwordconfirm")).click();
    driver.findElement(By.id("signupform-passwordconfirm")).clear();
    driver.findElement(By.id("signupform-passwordconfirm")).sendKeys("Test111");
    driver.findElement(By.id("signupform-sword")).click();
    driver.findElement(By.id("signupform-sword")).clear();
    driver.findElement(By.id("signupform-sword")).sendKeys("Епта");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

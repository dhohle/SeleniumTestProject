package org.dhohle.selenium

import org.scalatest._
import org.scalatest.matchers._
import org.scalatestplus.selenium.Chrome.webDriver
import org.scalatestplus.selenium._

class TestSeleniumExample extends flatspec.AnyFlatSpec with should.Matchers with WebBrowser {

  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/DriverFiles/chromedriver")
  //reading location of chrome driver
  val host = "https://login.salesforce.com/?locale=in"
  // storing URL to be automated
  val extractedData = DataDriven.extractData("Sheet1", "Login", "TestCases")
  //call the function from DataDriven.scala
  "The blog app home page" should "have the correct title" in {
    go to host
    //Hit the required URL
    emailField("username").value = extractedData.get(1)
    //Find the email field and enter the email data from the excel sheet
    pwdField("password").value = extractedData.get(2)
    //Find the password field and enter the password data from the excel sheet
    click on id("Login")
    //Click on login button
    pageTitle should be("Login | Salesforce")
    //Validate that the title of the page is correct
    webDriver.close()
    //Close the web browser
  }
}
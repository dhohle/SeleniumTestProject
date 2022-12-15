package org.dhohle.selenium
package playground

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated

import java.time.Duration

object WebdriverConnectionTest extends App{

  val driver:WebDriver = FirefoxDriver
  val wait:WebDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10))

  import org.openqa.selenium.By
  import org.openqa.selenium.Keys
  import org.openqa.selenium.WebElement

  try {
    driver.get("https://google.com/ncr")
    driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER)
    val firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")))
    println(firstResult.getAttribute("textContent"))
  } finally driver.quit

  println("Huh")
}

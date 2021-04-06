name := "SeleniumTestProject"

version := "0.1"

scalaVersion := "2.13.5"

idePackagePrefix := Some("org.dhohle.selenium")
libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "3.141.59"
//libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "4.0.0-beta-2"

// https://mvnrepository.com/artifact/org.apache.poi/poi
libraryDependencies += "org.apache.poi" % "poi" % "5.0.0"
// https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml
libraryDependencies += "org.apache.poi" % "poi-ooxml" % "5.0.0"

// https://mvnrepository.com/artifact/org.scalatestplus/selenium-3-141
libraryDependencies += "org.scalatestplus" %% "selenium-3-141" % "3.2.7.0" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.5" % "test"
// https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java

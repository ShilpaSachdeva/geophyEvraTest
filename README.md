# Geophy Evra Test Challenge

This Project contains the various tests related to Geophy Evra for new user registration process, already registered user Login and Logout, running valuation for property,seraching reports from history.

## Concepts Included

* Cucumber with TestNg.xml
* Page factory design pattern
* Maven Project
* Externalised test configuration using config file
* Common web page interaction methods
* Commonly used test utility classes
* HTML report generation with Extent report
* Capturing screenshots for failed test cases
* BDD style
* Test cases in Gherkin format
* Cross Browser support
* Support Windows and Mac-OS

## Software

* Maven
* TestNg
* Selenium Webdriver
* Java
* Cucumber
* Gherkin test cases
* Page-factory design pattern

## Project setup:-

Pre-requisites: IntelliJ IDE installation is desired. Can work on eclipse also.

The project setup can be done in either of the below mentioned ways:

First Method:
#Download the project from the GitHub link:  “https://github.com/ShilpaSachdeva/geophyEvraTest.git”

#Import the maven project in IntelliJ IDEA:
*  Note: How to import maven project in IntelliJ IDEA
*  Link: https://www.jetbrains.com/help/idea/maven-support.html#maven_add_module

#Run the Testng tests using testng.xml. 
    - Right click testng.xml under geophyEvraTest
    - Click on Run.



Second Method:
* GitHub Project location: https://github.com/ShilpaSachdeva/geophyEvraTest.git
* Import GitHub Project into IntelliJ IDEA/Eclipse:
  Note: How to import maven project in Eclipse Link:https://github.com/collab-uniba/socialcde4eclipse/wiki/How-to-import-a-GitHub-project-into-Eclipse
  
* As it is maven project, all the dependencies will be downloaded on its own
* Run the Testng tests using testng.xml. 
    - Right click testng.xml under geophyEvraTest
    - Click on Run.
    
    
    Alternate Ways of running test scripts:
    - Test Runner class
    - Maven terminal commands
    
## Reporting

* Extent Report is used to create reports
* Open the HTML report generated under "test-output" folder 
    - Right click  GeophyEvraAutomationReport.html
    - Open with Web Browser
 * Logger report generated under "test-output" folder   
* Screenshots of failed steps are attached to reports, which are also placed under images folder


## Requirements

In order to utilise this project you need to have the following installed locally:

* The scripts are made operating system independent. You can use windows 64 bit or Mac-os.
* The test scripts supports cross browser testing. Currently supporting Chrome and Firefox browsers.( UI tests use Chrome by default, can be changed in config)
* Latest Java Version : Java 14.0.1 ( can be lowered to java 8 also)
* IntelliJ
* Since it is maven Project, it will auto install all dependencies


## Framework

*Cucumber with Test-Ng. 

* Features files using Gherkin Syntax.

*Page factory design pattern to make code reusable, reliable, maintainable, readable and to eliminate duplicity.

*The framework will be capable of creating interactive reports using extent reports.Also, the framework will capture screenshots for failed test scnearios.






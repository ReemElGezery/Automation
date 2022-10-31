# Automation

Table of contents
-----------------

* Introduction
* Components
* Features
* how solution works
* Tools
* Reporting


Introduction
------------
I implemented a simple test scenario that opens google website
and search for a specific word then it navigates to next pages 
and count and validate the search results.


Components
-----------
The Src code is divided into two packages according to page object model design pattern:
*main package: That contains the logic classes.
*test package: That contains the Test classes that will run in the execution phase.

main package is divided into two packages the java and resources packages. The java
package contains pages package that is consisted of home class and results class
and utils package that has utilities class.in addition the resources package contains
the properties file used in cross browser testing.

test package is divided into two packages java package that contains the base test class and 
task class and the TestData package has CSV file to read test Data from it.


Features
---------
* Scenario created using Maven Project.
* Implemented using page object Model design pattern.
* Created utilities class to read excel and properties files.
* supports cross browser testing to be able to work on (Edge,CH,FF).
* Used TestNG to assert that each action was performed successfully.
* Used allure reports to show the detailed execution of the scenario.


how solution works
-------------------
* In the beginning open  maven project on the preferred IDE.
* Go to browser.properties file to be able to choose the browser.
you would like to run the scenario on so open "/src/main/resources/browser.properties"
* Type Edge , CH or FF.
* Press on Run as testNG.
* allure reports folder will be created automatically.
* To check the report using html run command < allure serve "allure results path" >.
* Check the detailed Execution status in allure reports.

Tools
-----
* Maven project
* TestNG 
* WebDriver Manger
* JAVA
* Selenium WebDriver
* Allure reports
* intellij IDE


Reporting
----------
I used allure reports to display the detailed execution status of the 
executed scenarios and I created an execution Screen shots folder that has screen shots
of the scenario when it pass or fail.

* To run the allure report on your machine please type 
< allure serve "allure results path" > in your command prompt
and the report will be created in html format on your browser.









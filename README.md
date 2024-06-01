# Halo Automation Framework

## Objectives
The purpose of this framework is to comply with Halo's coding challenge. This framework has been built using the following tools and libraries:
* Java: As the selected programming language. If you do not have Java installed, please follow this [guide](https://www.java.com/en/download/help/download_options.html)
* Maven: As the project's structure and project tasks. If you don't have Maven installed, please follow this [guide](https://maven.apache.org/install)
* Selenium: As it provides with the necessary functionalities for testing web applications
* TestNG: As the test runner and executioner

## Why?
The choosing of these tools and libraries responds to the robust set of capabilities provided by Selenium when needing to test a web application or web page.
Many libraries exist and would be perfectly fine selections for this task. However, In my most personal opinion, Selenium is one of the best libraries for web testing.
If you want, you could also read a little [Blog](https://blog.makingsense.com/2020/05/how-to-choose-an-automation-framework-without-dying-in-the-process/) I wrote a couple of years ago talking about this topic.

Now, Why Java? I Just love it and have a lot of experience working with it 😅.

## Scenarios to test
The Web page selected for testing is the **[Nasa page](https://www.nasa.gov/)**. This is because it has a lot of sections to navigate to, actions and cool pictures to contemplate about the universe.
The list of tests to be executed are:
1. Validate that the title of the section "Search For Life" is displayed.
2. Validate that the search functionality works as expected.


## Introduction
to clone this repository you need to execute the following command:
```
git clone https://github.com/fabianlevin88/HaloAutomationFramework.git
```
> Note: if you don't have git installed on your computer, please refer to the **[Git official's page](https://git-scm.com/)**.

Once you cloned the repository you need to execute the following command to install dependencies and build the project:
`mvn install -DskipTests` The "DskipTests" is necessary because to effectively run the tests you would need to provide the route of the regression.xml file as well as the browser in which you want to run the tests.

## Technical Solution Design
### Design Patterns
Several design patters have been implemented for this solution and across the entire automation framework.The idea is to make use of the benefits and best practices around them so that the code is clean, understandable, maintainable and easy for other developers (or Automators) to work and follow the logic implemented.

For every pattern described here you can check the documentation related to it. The list of design patterns are:
* **[Page Object](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)**: This has been used when creating a class for every page that the automation framework interacts.
* **[Page Factory](https://www.seleniumeasy.com/selenium-tutorials/page-factory-pattern-in-selenium-webdriver)**: When instantiating an object from a page-class, the locators and elements defined within its scope are linked to that page instance though the line
`
PageFactory.initElements(driver, pageInstance)
`

### Testing purpose and criteria
The idea behind this automation solution is to implement simple and effective tests, but also to display how the separation of responsibilities between classes, definitions and methods are built following
principle "separation of tasks" (or responsibilities).
For this reason, the structure follows this pattern:
```
src
|-> pages
       |-> ExamplePage
|-> locators
       |-> ExamplePageLocators
|-> questions
       |-> ExamplePageQuestions 
```
Under this structure, the idea is to define every aspect of the page in different, consistent and coherent classes. The responsibilities of each class is:
* ***Pages***: Every method that is needed to interact with the different components of the page.
* ***Locators***: All the locators of a particular page.
* ***Questions***: All the validations for a specific page and for one or multiple locators.

## Execution of the tests
Once the repository has been cloned, the tests can be executed following two different ways:
* Through TestNG execution file: When using an IDE like [IntelliJ](https://www.jetbrains.com/es-es/idea/), you can right-click on the regression.xml file located in `src/test/java/com/halonasaframework/automation/suites/regression.xml` and select the option `run src/test/java/com/halonasaframework/automation/suites/regression.xml`
* Through a Maven command: Assuming that you have already installed Maven (see guide above if not under the Introduction section). You need to execute the following command, specifying the desired browser and the headless flag. For example, if we want to execute the tests on chrome on headless mode, the command is:
```
mvn clean test -DsuiteXmlFile=src/test/java/com/halonasaframework/automation/suites/regression.xml -Dbrowser=chrome -Dheadless=true
```
> NOTE: Keep in mind that if one or more of these parameters is not passed when execution the Maven command, it will throw an execution error.

## CI Implementation
The pipeline implemented is a simple one just to execute every time a pull request is created with changes. By default, the execution will be performed using Chrome. The explanation of every step you can find it in the yml file.





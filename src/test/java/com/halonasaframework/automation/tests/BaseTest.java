package com.halonasaframework.automation.tests;

import Config.DriverCreator;
import Config.Logger;
import Config.MyDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.NasaLandingPage;

import static Config.MyDriver.getMyDriver;


public abstract class BaseTest {

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser) {
        MyDriver.setMyDriver(new DriverCreator(browser));
    }

    /**
     * This method returns an instance of the landing page that should be changed to the project's landing page
     * @return an instance of the entry page
     */
    public NasaLandingPage getLandingPage() {
        Logger.printInfo("NASA Landing page instance returned");
        return new NasaLandingPage(getMyDriver(), "https://www.nasa.gov/");
    }

    /**
     * Once the tests have been executed, the tear down method is executed
     * In this case, the disposal of the webdriver, so it does not use a lot of memory and the session can be cleaned up
     * for the rest of the testing Classes (if there are more)
     * This method is used to take a screenshot of the application whenever a test fails
     * The screenshots are stored in a folder inside resources/results
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        Logger.printInfo("After test started and disposing resources");
        String[] testName = result.getName().split(("(?=\\p{Upper})"));
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < testName.length; i++) {
            sb.append(testName[i]);
            sb.append(" ");
        }
        getMyDriver().closeDriver();
        Logger.printInfo("###################################################***###################################################");
        Logger.printInfo("End of Test: " + sb.toString().toUpperCase());
        Logger.printInfo("###################################################***###################################################");
    }
}

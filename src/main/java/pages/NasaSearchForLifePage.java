package pages;

import Config.MyDriver;
import Validations.NasaSearchForLifeQuestions;
import locators.NasaSearchForLifeLocators;
import org.openqa.selenium.support.PageFactory;

public class NasaSearchForLifePage extends BasePage {


    private NasaSearchForLifeLocators nasaSearchForLifeLocators;
    private NasaSearchForLifeQuestions nasaSearchForLifeQuestions;
    /**
     * This method will relate the page instance and the webdriver instance using the Page factory.
     * Creates the explicit wait and sets the timeout to 20 seconds.
     *
     * @param pDriver the MyDriver instance (it can be a webdriver or an appiumDriver)
     */
    public NasaSearchForLifePage(MyDriver pDriver) {
        super(pDriver);
        nasaSearchForLifeLocators = new NasaSearchForLifeLocators();
        nasaSearchForLifeQuestions = new NasaSearchForLifeQuestions(pDriver, nasaSearchForLifeLocators);
        PageFactory.initElements(pDriver.getDriver(), nasaSearchForLifeLocators);
    }

    public NasaSearchForLifeQuestions getNasaSearchForLifeQuestions() { return nasaSearchForLifeQuestions; }
}

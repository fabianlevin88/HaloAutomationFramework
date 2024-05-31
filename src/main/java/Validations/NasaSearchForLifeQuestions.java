package Validations;

import Config.CustomActions;
import Config.MyDriver;
import locators.NasaSearchForLifeLocators;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NasaSearchForLifeQuestions extends BaseQuestion {

    private NasaSearchForLifeLocators nasaSearchForLifeLocators;

    /**
     *
     * @param pDriver
     * @param nasaSearchForLifeLocators
     */
    public NasaSearchForLifeQuestions(MyDriver pDriver, NasaSearchForLifeLocators nasaSearchForLifeLocators) {
        super(new CustomActions(pDriver.getDriver()));
        this.nasaSearchForLifeLocators = nasaSearchForLifeLocators;
        PageFactory.initElements(pDriver.getDriver(), nasaSearchForLifeLocators);
    }

    /**
     *
     */
    public void isSectionTitleDisplayed() {
        Assert.assertTrue(getCustomActions().isDisplayed(nasaSearchForLifeLocators.getAreWeAloneTitle()));
    }
}

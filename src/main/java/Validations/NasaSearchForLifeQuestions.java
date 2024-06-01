package Validations;

import Config.CustomActions;
import Config.Logger;
import Config.MyDriver;
import locators.NasaSearchForLifeLocators;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NasaSearchForLifeQuestions extends BaseQuestion {

    private NasaSearchForLifeLocators nasaSearchForLifeLocators;

    /**
     * {@link NasaSearchForLifeQuestions} constructor
     * @param pDriver
     * @param nasaSearchForLifeLocators
     */
    public NasaSearchForLifeQuestions(MyDriver pDriver, NasaSearchForLifeLocators nasaSearchForLifeLocators) {
        super(new CustomActions(pDriver.getDriver()));
        this.nasaSearchForLifeLocators = nasaSearchForLifeLocators;
        PageFactory.initElements(pDriver.getDriver(), nasaSearchForLifeLocators);
    }

    /**
     * This method validates if the section's title is displayed or not
     */
    public void isSectionTitleDisplayed() {
        Logger.printInfo("Validating if the Page title is the correct one");
        Assert.assertTrue(getCustomActions().isDisplayed(nasaSearchForLifeLocators.getAreWeAloneTitle()));
        Logger.printDebug("The title is the correct one: " + nasaSearchForLifeLocators.getAreWeAloneTitle().getText());
    }
}

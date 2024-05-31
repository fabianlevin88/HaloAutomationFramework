package Validations;

import Config.CustomActions;
import Config.Logger;
import Config.MyDriver;
import locators.NasaLandingPageLocators;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NasaLandingPageQuestions extends BaseQuestion {

    private final NasaLandingPageLocators nasaLocators;

    /**
     *
     * @param pDriver
     * @param nasaLandingPageLocators
     */
    public NasaLandingPageQuestions(MyDriver pDriver, NasaLandingPageLocators nasaLandingPageLocators) {
        super(new CustomActions(pDriver.getDriver()));
        this.nasaLocators = nasaLandingPageLocators;
        PageFactory.initElements(pDriver.getDriver(), nasaLandingPageLocators);
    }

    /**
     *
     */
    public void validateNasaLogoIsDisplayed() {
        Logger.printInfo("Validating if the NASA logo is displayed or not");
        Assert.assertTrue(getCustomActions().isDisplayed(nasaLocators.getNasaLogo()));
        Logger.printDebug("The NASA logo is displayed");
    }
}

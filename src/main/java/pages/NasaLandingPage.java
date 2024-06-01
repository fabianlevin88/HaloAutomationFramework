package pages;

import Config.Logger;
import Config.MyDriver;
import Validations.NasaLandingPageQuestions;
import locators.NasaLandingPageLocators;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class NasaLandingPage extends BasePage {

    private NasaLandingPageLocators nasaLandingPageLocators;
    private NasaLandingPageQuestions nasaLandingPageQuestions;

    /**
     * {@link NasaLandingPage} constructor
     * @param pDriver
     * @param url
     */
    public NasaLandingPage(MyDriver pDriver, String url) {
        super(pDriver);
        pDriver.getDriver().get(url);
        nasaLandingPageLocators = new NasaLandingPageLocators();
        nasaLandingPageQuestions = new NasaLandingPageQuestions(pDriver, nasaLandingPageLocators);
        PageFactory.initElements(pDriver.getDriver(), nasaLandingPageLocators);
    }

    /**
     * Opens the EXPLORE menu
     */
    public void openExploreMenu() {
        try {
            Logger.printInfo("Opening the EXPLORE section");
            customActions.waitFor.exist(nasaLandingPageLocators.getExploreLinkBtn());
            customActions.waitFor.clickable(nasaLandingPageLocators.getExploreLinkBtn());

            Logger.printDebug("Clicking on the EXPLORE link to expand the sections menu");
            customActions.clickElement(nasaLandingPageLocators.getExploreLinkBtn());
        } catch (Exception exception) {
            Logger.printWarning("The explore link is not yet displayed or clickable");

            getWait().pollingEvery(Duration.of(getInterval(), ChronoUnit.SECONDS))
                    .until(ExpectedConditions.visibilityOf(nasaLandingPageLocators.getExploreLinkBtn()));

            Logger.printDebug("Clicking on the EXPLORE link to expand the sections menu");
            customActions.clickElement(nasaLandingPageLocators.getExploreLinkBtn());
        }
    }

    /**
     * Clicks on the "The Universe" section
     */
    public void selectTheUniverseSection() {
        try {
            Logger.printInfo("Selecting the item \"The Universe\"");
            customActions.waitFor.exist(nasaLandingPageLocators.getTheUniverseMenu());
            customActions.waitFor.clickable(nasaLandingPageLocators.getTheUniverseMenu());

            Logger.printDebug("Clicking on the \"The Universe\" link to expand the sections menu");
            customActions.clickElement(nasaLandingPageLocators.getTheUniverseMenu());
        } catch (Exception exception) {
            Logger.printWarning("\"The Universe\" link is not yet displayed or clickable");

            getWait().pollingEvery(Duration.of(getInterval(), ChronoUnit.SECONDS))
                            .until(ExpectedConditions.visibilityOf(nasaLandingPageLocators.getTheUniverseMenu()));

            Logger.printDebug("Clicking on \"The Universe\" link to expand the sections menu");
            customActions.clickElement(nasaLandingPageLocators.getTheUniverseMenu());
        }
    }

    /**
     * Clicks on the "Search for Life..." section
     * @return
     */
    public NasaSearchForLifePage openSearchForLifeLink() {
        try {
            Logger.printInfo("Selecting the item \"Search For Life in the Universe\"");
            customActions.waitFor.exist(nasaLandingPageLocators.getTheSearchForLifeLink());
            customActions.waitFor.clickable(nasaLandingPageLocators.getTheSearchForLifeLink());

            Logger.printDebug("Clicking on the \"search for life...\"");
            customActions.clickElement(nasaLandingPageLocators.getTheSearchForLifeLink());
        } catch (Exception exception) {
            Logger.printWarning("The \"search for life...\" link is not yet displayed or clickable");

            getWait().pollingEvery(Duration.of(getInterval(), ChronoUnit.SECONDS))
                    .until(ExpectedConditions.visibilityOf(nasaLandingPageLocators.getTheSearchForLifeLink()));

            Logger.printDebug("Clicking on the \"search for life...\" link");
            customActions.clickElement(nasaLandingPageLocators.getTheSearchForLifeLink());
        }

        return new NasaSearchForLifePage(getDriver());
    }

    public NasaLandingPageQuestions getNasaLandingPageQuestions() {
        return nasaLandingPageQuestions;
    }
}

package Validations;

import Config.CustomActions;
import Config.Logger;
import Config.MyDriver;
import locators.NasaSearchResultPageLocators;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NasaSearchResultPageQuestions extends BaseQuestion {

    private NasaSearchResultPageLocators nasaSearchResultPageLocators;

    /**
     *
     * @param pDriver
     * @param nasaSearchResultPageLocators
     */
    public NasaSearchResultPageQuestions(MyDriver pDriver, NasaSearchResultPageLocators nasaSearchResultPageLocators) {
        super(new CustomActions(pDriver.getDriver()));
        this.nasaSearchResultPageLocators = nasaSearchResultPageLocators;
        PageFactory.initElements(pDriver.getDriver(), nasaSearchResultPageLocators);
    }

    /**
     * Validates if the search result page title contains the text that was entered in the search input
     * @param blogSearch
     */
    public void validateSearchTitleIsCorrect(String blogSearch) {
        Logger.printInfo("Validating that the results for " + blogSearch + " are displayed");
        Assert.assertTrue(nasaSearchResultPageLocators.getSearchResultTitle().getText().contains(blogSearch), "The title displayed does not contain the word: " + blogSearch);
        Logger.printDebug("The title is correctly displayed");
    }

    /**
     * Validates if the filter is displayed on top of the result page after applying the selected filters
     */
    public void isFilterButtonDisplayed() {
        Logger.printInfo("Validating that the Remove filters button is displayed");
        Assert.assertTrue(getCustomActions().isDisplayed(nasaSearchResultPageLocators.getRemoveAppliedFiltersBtn()), "The remove filters button is not displayed");
        Logger.printDebug("The remove applied filters is displayed");
    }

    /**
     * Validates if the remove filter button is displayed after removing it
     */
    public void isFilterButtonRemoved() {
        Logger.printInfo("Validating that the Remove filters button is displayed");
        Assert.assertFalse(getCustomActions().isDisplayed(nasaSearchResultPageLocators.getRemoveAppliedFiltersBtn()), "The remove filters button is still displayed");
        Logger.printDebug("The remove applied filters is displayed");
    }
}

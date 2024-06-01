package pages;

import Config.Logger;
import Config.MyDriver;
import Validations.NasaSearchResultPageQuestions;
import locators.NasaSearchResultPageLocators;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class NasaSearchResultPage extends BasePage {

    private NasaSearchResultPageLocators nasaSearchResultPageLocators;
    private NasaSearchResultPageQuestions nasaSearchResultPageQuestions;

    /**
     * This method will relate the page instance and the webdriver instance using the Page factory.
     * Creates the Fluent wait and sets the timeout to 20 seconds.
     *
     * @param pDriver the MyDriver instance (it can be a webdriver or an appiumDriver)
     */
    public NasaSearchResultPage(MyDriver pDriver) {
        super(pDriver);
        nasaSearchResultPageLocators = new NasaSearchResultPageLocators();
        nasaSearchResultPageQuestions = new NasaSearchResultPageQuestions(MyDriver.getMyDriver(), nasaSearchResultPageLocators);
        PageFactory.initElements(pDriver.getDriver(), nasaSearchResultPageLocators);
    }

    public void applyFilters() {
        try {
            // Selecting the ARTICLES filter
            selectArticlesFilter();

            // Selecting the LAST YEAR filter
            selectLastYearFilter();

            // Applying the selected filters
            applyFilter();

        } catch (Exception exception) {
            Logger.printWarning("There was an error when trying to select the filters.");

            // Selecting the ARTICLES filter
            selectArticlesFilter();

            // Selecting the LAST YEAR filter
            selectLastYearFilter();

            // Applying the selected filters
            applyFilter();
        }
    }

    /**
     * Selects the checkbox called ARTICLES
     */
    private void selectArticlesFilter() {
        try {
            Logger.printInfo("Applying filters to the list of results");

            customActions.waitFor.exist(nasaSearchResultPageLocators.getArticlesCheckbox());
            customActions.waitFor.clickable(nasaSearchResultPageLocators.getArticlesCheckbox());

            Logger.printDebug("Selecting the filter ARTICLES");
            customActions.clickElement(nasaSearchResultPageLocators.getArticlesCheckbox());
        } catch (Exception exception) {
            Logger.printWarning("The articles checkbox is not yet displayed");

            getWait().pollingEvery(Duration.of(getInterval(), ChronoUnit.SECONDS))
                    .until(ExpectedConditions.visibilityOf(nasaSearchResultPageLocators.getArticlesCheckbox()));

            customActions.waitFor.exist(nasaSearchResultPageLocators.getArticlesCheckbox());
            customActions.waitFor.clickable(nasaSearchResultPageLocators.getArticlesCheckbox());

            Logger.printDebug("Selecting the filter ARTICLES");
            customActions.clickElement(nasaSearchResultPageLocators.getArticlesCheckbox());
        }
    }

    /**
     * Selects the time filter called LAST YEAR
     */
    private void selectLastYearFilter() {
        try {
            Logger.printInfo("Selecting the last year filter to the list of results");

            customActions.waitFor.exist(nasaSearchResultPageLocators.getLastYearRadioBtn());
            customActions.waitFor.clickable(nasaSearchResultPageLocators.getLastYearRadioBtn());

            Logger.printDebug("Selecting only the ARTICLES from LAST YEAR");
            customActions.clickElement(nasaSearchResultPageLocators.getLastYearRadioBtn());
        } catch (Exception exception) {
            Logger.printWarning("The Last Year radio button is not yet displayed");

            getWait().pollingEvery(Duration.of(getInterval(), ChronoUnit.SECONDS))
                    .until(ExpectedConditions.visibilityOf(nasaSearchResultPageLocators.getLastYearRadioBtn()));

            customActions.waitFor.exist(nasaSearchResultPageLocators.getLastYearRadioBtn());
            customActions.waitFor.clickable(nasaSearchResultPageLocators.getLastYearRadioBtn());

            Logger.printDebug("Selecting only the ARTICLES from LAST YEAR");
            customActions.clickElement(nasaSearchResultPageLocators.getLastYearRadioBtn());
        }

    }

    /**
     * Clicks on the Apply Filter button
     */
    private void applyFilter() {
        try {
            Logger.printInfo("Applying the filters");
            customActions.waitFor.exist(nasaSearchResultPageLocators.getApplyFilterBtn());
            customActions.waitFor.clickable(nasaSearchResultPageLocators.getApplyFilterBtn());

            Logger.printDebug("Clicking on the Apply Filters button");
            customActions.clickElement(nasaSearchResultPageLocators.getApplyFilterBtn());
        } catch (Exception exception) {
            Logger.printWarning("The Apply Filters button is not yet displayed");

            getWait().pollingEvery(Duration.of(getInterval(), ChronoUnit.SECONDS))
                    .until(ExpectedConditions.visibilityOf(nasaSearchResultPageLocators.getApplyFilterBtn()));

            Logger.printDebug("Clicking on the Apply Filters button");
            customActions.clickElement(nasaSearchResultPageLocators.getApplyFilterBtn());
        }
    }

    /**
     * Removes the applied filters
     */
    public void removeTheAppliedFilters() {
        try {
            Logger.printInfo("Removing the applied filters");
            customActions.waitFor.exist(nasaSearchResultPageLocators.getRemoveAppliedFiltersBtn());
            customActions.waitFor.clickable(nasaSearchResultPageLocators.getRemoveAppliedFiltersBtn());

            Logger.printDebug("Clicking on the remove filter button");
            customActions.clickElement(nasaSearchResultPageLocators.getRemoveAppliedFiltersBtn());
        } catch (Exception exception) {
            Logger.printWarning("The remove filter button is not yet displayed");

            getWait().pollingEvery(Duration.of(getInterval(), ChronoUnit.SECONDS))
                    .until(ExpectedConditions.visibilityOf(nasaSearchResultPageLocators.getRemoveAppliedFiltersBtn()));

            Logger.printDebug("Clicking on the remove filter button");
            customActions.clickElement(nasaSearchResultPageLocators.getRemoveAppliedFiltersBtn());
        }
    }

    public NasaSearchResultPageQuestions getNasaSearchResultPageQuestions() { return nasaSearchResultPageQuestions; }
}

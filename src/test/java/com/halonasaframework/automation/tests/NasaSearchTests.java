package com.halonasaframework.automation.tests;

import Config.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.NasaLandingPage;
import pages.NasaSearchResultPage;

public class NasaSearchTests extends BaseTest {

    private NasaLandingPage nasaLandingPage;
    private NasaSearchResultPage nasaSearchResultPage;

    @Test
    @Parameters({ "blogSearch" })
    public void validateSearchFeatureTest(String blogSearch) {
        Logger.printTitle("Validate Search Feature Test");

        nasaLandingPage = getLandingPage();

        nasaLandingPage.getNasaLandingPageQuestions().validateNasaLogoIsDisplayed();

        nasaSearchResultPage = nasaLandingPage.search(blogSearch);

        nasaSearchResultPage.getNasaSearchResultPageQuestions().validateSearchTitleIsCorrect(blogSearch);

        nasaSearchResultPage.applyFilters();

        nasaSearchResultPage.getNasaSearchResultPageQuestions().isFilterButtonDisplayed();

        nasaSearchResultPage.removeTheAppliedFilters();

        nasaSearchResultPage.getNasaSearchResultPageQuestions().isFilterButtonRemoved();
    }
}

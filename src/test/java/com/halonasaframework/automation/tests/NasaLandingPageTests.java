package com.halonasaframework.automation.tests;

import org.testng.annotations.Test;
import pages.NasaLandingPage;
import pages.NasaSearchForLifePage;

public class NasaLandingPageTests extends BaseTest {

    private NasaLandingPage nasaLandingPage;
    private NasaSearchForLifePage nasaSearchForLifePage;

    @Test
    public void openNasaLandingPageTest() {
        nasaLandingPage = getLandingPage();

        nasaLandingPage.getNasaLandingPageQuestions().validateNasaLogoIsDisplayed();

        nasaLandingPage.openExploreMenu();

        nasaLandingPage.selectTheUniverseSection();

        nasaSearchForLifePage = nasaLandingPage.openSearchForLifeLink();

        nasaSearchForLifePage.getNasaSearchForLifeQuestions().isSectionTitleDisplayed();
    }
}

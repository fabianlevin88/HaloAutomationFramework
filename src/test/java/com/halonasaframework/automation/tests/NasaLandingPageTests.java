package com.halonasaframework.automation.tests;

import Config.Logger;
import org.testng.annotations.Test;
import pages.NasaLandingPage;
import pages.NasaSearchForLifeSectionPage;

public class NasaLandingPageTests extends BaseTest {

    private NasaLandingPage nasaLandingPage;
    private NasaSearchForLifeSectionPage nasaSearchForLifeSectionPage;

    @Test
    public void openNasaLandingPageTest() {
        Logger.printTitle("Validate Nasa's Landing Page Test");

        nasaLandingPage = getLandingPage();

        nasaLandingPage.getNasaLandingPageQuestions().validateNasaLogoIsDisplayed();

        nasaLandingPage.openExploreMenu();

        nasaLandingPage.selectTheUniverseSection();

        nasaSearchForLifeSectionPage = nasaLandingPage.openSearchForLifeLink();

        nasaSearchForLifeSectionPage.getNasaSearchForLifeQuestions().isSectionTitleDisplayed();
    }
}

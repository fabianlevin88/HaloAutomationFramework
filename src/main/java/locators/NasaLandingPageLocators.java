package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NasaLandingPageLocators {
    @FindBy(xpath = "//a[@id='header-logo' and @href='https://www.nasa.gov/']")
    private WebElement nasaLogo;
    @FindBy(xpath = "//button/span[text()='Explore']")
    private WebElement exploreLinkBtn;
    @FindBy(xpath = "//li[@submenu-id='global-nav-universe']/a/span[text()='The Universe']")
    private WebElement theUniverseMenu;
    @FindBy(xpath = "//a/span[text()='The Search for Life in the Universe']")
    private WebElement theSearchForLifeLink;
    @FindBy(xpath = "//header//form//input[@name='search']")
    private WebElement searchInput;

    public WebElement getNasaLogo() { return nasaLogo; }
    public WebElement getExploreLinkBtn() { return exploreLinkBtn; }
    public WebElement getTheUniverseMenu() { return theUniverseMenu; }
    public WebElement getTheSearchForLifeLink() { return theSearchForLifeLink; }
    public WebElement getSearchInput() { return searchInput; }
}

package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NasaSearchResultPageLocators {
    @FindBy(xpath = "//h1")
    private WebElement searchResultTitle;
    @FindBy(xpath = "//input[@id='content_typearticles']")
    private WebElement articlesCheckbox;
    @FindBy(xpath = "//input[@value='Last Year']")
    private WebElement lastYearRadioBtn;
    @FindBy(xpath = "//button/span[text()='Apply Filters']")
    private WebElement applyFilterBtn;
    @FindBy(xpath = "//button[@aria-label='Remove articles filter from search']")
    private WebElement removeAppliedFiltersBtn;

    public WebElement getSearchResultTitle() { return searchResultTitle; }
    public WebElement getArticlesCheckbox() { return articlesCheckbox; }
    public WebElement getLastYearRadioBtn() { return lastYearRadioBtn; }
    public WebElement getApplyFilterBtn() { return applyFilterBtn; }
    public WebElement getRemoveAppliedFiltersBtn() { return removeAppliedFiltersBtn; }
}

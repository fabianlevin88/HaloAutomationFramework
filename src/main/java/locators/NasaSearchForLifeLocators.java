package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NasaSearchForLifeLocators {

    @FindBy(xpath = "//h1")
    private WebElement areWeAloneTitle;


    public WebElement getAreWeAloneTitle() { return areWeAloneTitle; }
}

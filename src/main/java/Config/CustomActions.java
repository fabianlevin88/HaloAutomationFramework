package Config;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static Config.MyDriver.getBrowser;

public class CustomActions {
    public static final int DELAY_BETWEEN_ACTIONS_IN_SECONDS = 2;
    private JavascriptExecutor js;
    private WebDriver driver;
    public WaitForActions waitFor;
    public Delays delay;
    private Actions driverActions;

    public CustomActions(WebDriver webdriver) {
        driver = webdriver;
        driverActions = new Actions(driver);
        waitFor = new WaitForActions(driver, this);
        delay = new Delays();
        js = (JavascriptExecutor) driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Performs a click action on the target element
     * @param element
     */
    public void clickElement(WebElement element) {
        delay.seconds(WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
        try {
            clickByBrowser(element);
        } catch (WebDriverException e) {
            // Retry previous click if click is intercepted
            Logger.printWarning("Click Failed, trying to click the element again. Exception" + e);
            delay.seconds( 5, true);
            try {
                clickByBrowser(element);
            } catch (Exception ex){
                Logger.printDebug("Clicked failed in the second time. Exceptions is " + ex);
            }
        }
        delay.seconds(WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
    }

    /**
     * This method clicks on a selected element according to the browser used. This is because sometimes, specially with SAFARI, the click
     * event does not respond. For this reason, the idea is to use the javascript executor to perform the click action when this happens.
     * @param element
     */
    private void clickByBrowser(WebElement element) {
        if (!getBrowser().equalsIgnoreCase("safari")) {
            try {
                element.click();
            } catch (Exception exception) {
                Logger.printWarning("The element could not be clicked, trying with the javascript executor");
                js.executeScript("arguments[0].click();", element);
            }
        } else {
            js.executeScript("arguments[0].click();", element);
        }
    }

    /**
     * This method is used to wait for an element to be displayed
     * @param element
     * @return
     */
    public boolean isDisplayed(WebElement element) {
        if (waitFor.exist(element, 6, false) && element.isDisplayed()){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Grabs the current text of the element
     * @param element
     * @return
     */
    public String getText(WebElement element) {
        try {
            waitFor.exist(element);
            return element.getText();
        } catch (StaleElementReferenceException ex) {
            Logger.printWarning("Stale element exception.");
        }
        return null;
    }

    /**
     * Types the text within the element
     *
     * @param element
     * @param text
     */
    public void type(WebElement element, String text) {
        delay.seconds(DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
        element.sendKeys(text);
    }

    /**
     *
     * @param element
     * @param selectedKey
     */
    public void sendKey(WebElement element, Keys selectedKey) {
        delay.seconds(DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
        try {
            waitFor.exist(element);
            element.sendKeys(selectedKey);
            delay.seconds(DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
        } catch (Exception exception) {
            Logger.printWarning("Exception raised when trying to send a key to the element: " + element);
            waitFor.exist(element);
            element.sendKeys(selectedKey);
            delay.seconds(DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
        }
    }
}

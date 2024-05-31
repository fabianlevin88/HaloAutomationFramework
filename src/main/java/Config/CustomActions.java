package Config;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static Config.MyDriver.getBrowser;
import static Config.WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS;

public class CustomActions {
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

    /**
     * This method is used to execute javascript command to bring an element into the view
     * @param element
     */
    public void scrollIntoElementView(By element) {
        delay.seconds(2);
        js.executeScript("arguments[0].scrollIntoView(true);", findElement(element));
    }

    /**
     * This method is used to execute javascript command to bring an element into the view
     * @param element
     */
    public void scrollIntoElementViewByLocator(WebElement element) {
        delay.seconds(2);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver webdriver) {
        driver = webdriver;
    }


    /**
     * Looks for the element. Provide child By locators to look for elements under elements.
     *
     * @param element
     * @return
     */
    public List<WebElement> findElements(By element) {
        List<WebElement> elements = new ArrayList<WebElement>();
        try {
            elements = driver.findElements(element);
        } catch (Exception e) {
            Logger.printError(e.toString());
        }
        if (elements.size() == 0) {
            Logger.printError("No elements found");
            return null;
        }
        return elements;
    }

    /**
     * Allows tester to pass a IWebElement or By object for most actions
     *
     * @param element
     * @return
     */
    public WebElement findElement(By element) {
        return findElements(element).get(0);
    }

    /**
     *
     * @param element
     * @return
     */
    public boolean exist(By element) {
        return findElements(element) != null;
    }

    /**
     * This method clears the text present in any given input
     * @param element
     */
    public void clearField(WebElement element) {
        delay.milliseconds(WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);

        if (!getBrowser().equalsIgnoreCase("safari")) {
            if (!element.getText().equals("")) {
                if (!System.getProperty("os.name").equalsIgnoreCase("mac os x")) {
                    element.sendKeys(Keys.chord(Keys.CONTROL + "a"));
                    element.sendKeys(Keys.BACK_SPACE);
                } else {
                    element.sendKeys(Keys.chord(Keys.COMMAND + "a"));
                    element.sendKeys(Keys.BACK_SPACE);
                }
            } else {
                Logger.printWarning("Field is already empty");
            }
            // element.sendKeys(Keys.DELETE);
        } else {
            // SAFARI solution
            String inputText = element.getAttribute("value");
            if( !inputText.equals("") ) {
                for(int i = 0; !inputText.equals("");i++) {
                    element.sendKeys("");
                    element.sendKeys(Keys.BACK_SPACE);
                    element.sendKeys(Keys.DELETE);
                    inputText = element.getAttribute("value");
                }
            }
        }
    }

    /**
     * Types the text within the element
     *
     * @param element
     * @param text
     */
    public void type(WebElement element, String text) {
        delay.seconds(WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
        element.sendKeys(text);
    }

    public void input(By element, String text) {
        delay.seconds(4);
        clearField(findElement(element));
        delay.seconds(10);
        findElement(element).sendKeys(text);
    }

    /**
     * Performs a click action on the target element
     * @param element
     */
    public void click(WebElement element) {
        delay.seconds(WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
        try {
            Logger.printDebug("Clicking on the element: " + element.getText());
            clickOrSendKey(element);
        } catch (WebDriverException e) {
            // Retry previous click if click is intercepted
            Logger.printWarning("Click intercepted, trying to click");
            delay.seconds(4);
            clickOrSendKey(element);
        }
        delay.seconds(WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);

    }

    public void sendKey(WebElement element, Keys selectedKey) {
        delay.seconds(WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
        try {
            waitFor.exist(element);
            Logger.printDebug("Sending: " + selectedKey);
            element.sendKeys(selectedKey);
            delay.seconds(WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
        } catch (Exception exception) {
            Logger.printWarning("Exception raised when trying to send a key to the element: " + element);
            waitFor.exist(element);
            Logger.printDebug("Sending: " + selectedKey);
            element.sendKeys(selectedKey);
            delay.seconds(WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
        }
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

    public void clickOpenListedExhibitDropDownMenu(WebElement element) {
        delay.seconds(WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);

        try {
            if (!getBrowser().equalsIgnoreCase("safari")) {
                element.click();
            } else {
                Logger.printDebug("Click performed on: " + getBrowser());
                element.click();
            }
            Logger.printDebug("Clicked '"+element+"'");
        } catch (WebDriverException e) {
            // Retry previous click if click is intercepted
            Logger.printWarning("Click intercepted, trying to click the element again");
            delay.seconds(3);
            if (!getBrowser().equalsIgnoreCase("safari")) {
                element.click();
            } else {
                Logger.printDebug("Click performed on: " + getBrowser());
                element.click();
            }
        }
        delay.seconds(WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
    }

    /**
     * Performs a click action on the target element
     * @param by
     */
    public void click(By by) {
        delay.seconds(WaitForActions.DELAY_BETWEEN_ACTIONS_IN_SECONDS, true);
        WebElement element = findElement(by);
        click(element);
    }

    private void clickOrSendKey(WebElement element) {
        if (!getBrowser().equalsIgnoreCase("safari")) {
            element.click();
        } else {
            element.sendKeys(Keys.ENTER);
        }
    }

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

    public boolean isDisplayed(List<WebElement> listOfElements) {
        for (WebElement element : listOfElements) {
            if (waitFor.exist(element, 6, false) && element.isDisplayed()){
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isDisplayed(WebElement element, int timeout) {
        return (waitFor.exist(element, timeout, false) && element.isDisplayed());
    }

    public boolean isDisplayed(WebElement element, int timeout, boolean throwException) {
        return (waitFor.exist(element, timeout, throwException) && element.isDisplayed());
    }

    public boolean notIsDisplayed(By element) {
        return waitFor.notExist(element, 6);
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

    public void refreshView() {
        Logger.printDebug("Refresh View");
        driver.navigate().refresh();
        delay.seconds(15, true);
    }

    public void mouseHover(By element) {
        Logger.printDebug("Mouse over will be executed");
        Actions action = new Actions(driver);
        action.moveToElement(findElement(element)).build().perform();
        delay.seconds(10);
        Logger.printDebug("Mouse hover executed");
    }

    public void clickElement(By by) {
        Logger.printDebug("Desktop Current session: " + driver.getWindowHandle());
        clickElement(findElement(by));
    }

    public void selectFromCombo(By select, By option) {
        waitFor.exist(select);
        clickElement(select);
        delay.seconds(6);
        try{
            clickElement(option);
        }catch(Exception e){
            Logger.printWarning("Could not select the Role");
            clickElement(select);
            delay.seconds(1);
            clickElement(option);
        }
    }

    public String getAttributeValue(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }

    /**
     * This method is used to execute javascript command to bring a color property of stamps
     * @param element
     * @return
     */
    public String getCssProperty(By element, String attribute) {
        delay.seconds(2);
        String query = String.format("return window.getComputedStyle(arguments[0]).getPropertyValue('%s')", attribute);
        return (String) js.executeScript(query, findElement(element));
    }

    /**
     * This method is used to get current url
     * @return
     */
    public String getCurrentUrl() {

        return (driver.getCurrentUrl());
    }

    /**
     * This method is used to get page title
     * @return
     */
    public String getPageTitle() {

        return (driver.getTitle());
    }

    /**
     * This method is used to switch to a frame
     */
    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}

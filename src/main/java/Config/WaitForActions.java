package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class WaitForActions {
    public static final float DELAY_FACTOR = 1.0f;
    public static final int WAIT_FOR_TIMEOUT_IN_SECONDS = 20;
    public static final int DELAY_BETWEEN_ACTIONS_IN_SECONDS = 2;
    private static final long min = 0;
    private static final long max = 1000000000;
    private CustomActions customActions;
    private WebDriverWait wait;

    /**
     * Custom actions constructor
     * @param driver
     * @param actions
     */
    public WaitForActions(WebDriver driver, CustomActions actions) {
        customActions = actions;
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_TIMEOUT_IN_SECONDS).getSeconds());
    }

    /**
     * This method waits for an element to exist when providing a Web element
     * @param element
     * @return
     */
    public boolean exist(WebElement element) {
        int timeoutInSeconds = WAIT_FOR_TIMEOUT_IN_SECONDS;
        try{
            Logger.printDebug("Waiting for the element to exist");
            wait.withTimeout(ofSeconds(timeoutInSeconds))
                    .until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception ex){
            Logger.printError("Element not found. Waited for "+ timeoutInSeconds + " seconds before failing.");
            int count = 0;
            while (count < 2) {
                Logger.printWarning("Executing again Wait For Exist for element " + element);
                if (customActions.isDisplayed(element)) {
                    return true;
                }
                count++;
                customActions.delay.seconds(8);
                Logger.printDebug("Waiting for the new try");
            }
            throw ex;
        }
    }

    /**
     * This method waits for an element to be clickable
     * @param element
     * @return
     */
    public boolean clickable(WebElement element) {
        int timeoutInSeconds = WAIT_FOR_TIMEOUT_IN_SECONDS;

        try{
            Logger.printDebug("Waiting for element to be clickable");
            wait.withTimeout(ofSeconds(timeoutInSeconds))
                    .until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }catch (Exception ex){
            Logger.printError("Element not found. Waited for "+ timeoutInSeconds + " seconds before failing.");
            throw ex;
        }
    }

    /**
     * This method waits for an element to be visible. Moreover, this method contemplates
     * the timeout required for the condition to be met and indicate if an exception should
     * be thrown or not
     * @param element
     * @param timeoutInSeconds
     * @param throwException
     * @return
     */
    public boolean exist(WebElement element, int timeoutInSeconds, boolean throwException){
        if (timeoutInSeconds < 0)  timeoutInSeconds = WAIT_FOR_TIMEOUT_IN_SECONDS;
        try{
            wait.withTimeout(ofSeconds(timeoutInSeconds))
                    .until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception ex){
            if (throwException) {
                Logger.printError("Wait for failed after "+timeoutInSeconds+"  seconds.");
                throw ex;
            }
            return false;
        }
    }

    /**
     * This method validates that an element contains specific text.
     * @param element
     * @param text
     * @param caseSensitive
     * @return
     */
    public boolean textEqual(WebElement element, String text, boolean caseSensitive) {
        return textEqual(element,text,caseSensitive,WAIT_FOR_TIMEOUT_IN_SECONDS);
    }

    /**
     * This method validates that an element contains specific text. Moreover, this method contemplates
     * the timeout required for the condition to be met and indicate if an exception should
     * be thrown or not.
     * @param element
     * @param text
     * @param caseSensitive
     * @param timeoutInSeconds
     * @return
     */
    public boolean textEqual(WebElement element, String text, boolean caseSensitive, int timeoutInSeconds) {
        if (timeoutInSeconds < 0) timeoutInSeconds = WAIT_FOR_TIMEOUT_IN_SECONDS;
        String currentText = new String();

        for (int i = 0; i < timeoutInSeconds; i++) {
            currentText = customActions.getText(element);
            if (caseSensitive) {
                text = text.toLowerCase();
                currentText = currentText.toLowerCase();
            }
            if (currentText.equals(text)) {
                return true;
            }
            customActions.delay.seconds(1, true);
        }
        Logger.printDebug("'" + element + "' text does not equal '" + text + "' after " + timeoutInSeconds + " seconds (currently: '" + currentText + "')");
        return false;
    }
}

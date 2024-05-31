package Config;

import java.util.concurrent.TimeUnit;

public class Delays {
    public Delays() { delayFactor = WaitForActions.DELAY_FACTOR; }
    private float delayFactor;

    private void delay(int ms) {
        ms = (int) (ms * delayFactor); // adjust total delay by DelayFactor
        if (ms <= 0) return;
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void delay(int ms, boolean ignoreDelayFactor) {
        if (!ignoreDelayFactor) ms = (int) (ms * delayFactor); // adjust total delay by DelayFactor
        if (ms <= 0) return;
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void milliseconds(int millisec)
    {
        delay(millisec);
    }

    public void seconds(int seconds)
    {
        delay(seconds * 1000);
    }

    public void minutes(int minutes)
    {
        delay(minutes * 60 * 1000);
    }

    public void milliseconds(int milliseconds, boolean ignoreDelayFactor)
    {
        delay(milliseconds,ignoreDelayFactor);
    }

    public void seconds(int seconds, boolean ignoreDelayFactor)
    {
        delay(seconds * 1000,ignoreDelayFactor);
    }

    public void minutes(int minutes, boolean ignoreDelayFactor)
    {
        delay(minutes * 60 * 1000,ignoreDelayFactor);
    }
}

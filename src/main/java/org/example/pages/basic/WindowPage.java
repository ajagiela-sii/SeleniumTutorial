package org.example.pages.basic;

import org.bouncycastle.cms.jcajce.JcaX509CertSelectorConverter;
import org.example.base.PageBase;
import org.example.enums.WindowButtons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowPage extends PageBase {
    private static Logger logger = LoggerFactory.getLogger(WindowPage.class);
    @FindBy(id = "newBrowserWindow")
    private WebElement newBrowserWindowButton;
    @FindBy(id = "newMessageWindow")
    private WebElement newMessageWindowButton;
    @FindBy(id = "newBrowserTab")
    private WebElement newBrowserTabButton;

    @FindBy(tagName = "body")
    private WebElement body;

    String originalWindow;

    public WindowPage(WebDriver driver) {
        super(driver);
    }

    public void clickButton(WindowButtons windowButtons) {
        switch (windowButtons) {
            case BROWSER_WINDOW -> newBrowserWindowButton.click();
            case MESSAGE_WINDOW -> newMessageWindowButton.click();
            case BROWSER_TAB -> newBrowserTabButton.click();
            default -> logger.info("Cannot click chosen button");
        }
    }

    public void setOriginalWindow(){
        originalWindow = driver.getWindowHandle();
    }

    public void switchToNewWindow() {
        driver.getWindowHandles().forEach(newWindow->driver.switchTo().window(newWindow));
    }

    public void switchToOriginalWindow() {
        driver.switchTo().window(originalWindow);
    }

    public void closeWindow() {
        driver.close();
    }

    public void printBody(){
        System.out.println(body.getText());
    }

    public boolean buttonIsVisible(WindowButtons windowButtons) {
        switch (windowButtons) {
            case BROWSER_WINDOW -> {
                return  newBrowserWindowButton.isEnabled();
            }
            case MESSAGE_WINDOW -> {
                return newMessageWindowButton.isEnabled();
            }
            case BROWSER_TAB -> {
                return newBrowserTabButton.isEnabled();
            }
            default -> {
                logger.info("Button does not available");
                return false;
            }
        }
    }
}

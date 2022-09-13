package org.example.pages.others;

import org.example.base.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HighSitePage extends PageBase {
    public HighSitePage(WebDriver driver) {
        super(driver);
    }
    private static Logger logger = LoggerFactory.getLogger(HighSitePage.class);

    @FindBy(id = "scroll-button")
    private WebElement submitButton;
    @FindBy(tagName = "body")
    private WebElement body;

    public void scrollToButton() {
        int webHigh = body.getSize().height;
        int currentHigh = 0;
        System.out.println(webHigh);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while(!isDisplayed(submitButton)){
            System.out.println(currentHigh);
            js.executeScript("window.scrollBy(0,100)");
            currentHigh += 100;
            if (currentHigh > webHigh) {
                logger.error("Submit Button does not exist!");
                break;
            }
        }
    }
}

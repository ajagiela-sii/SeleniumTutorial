package org.example.pages.widgets;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressbarPage extends PageBase {
    public ProgressbarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "ui-progressbar-complete")
    private WebElement progressbarComplete;
    @FindBy(className = "progress-label")
    private WebElement progressbarLabel;


    public void waitUntilProgressbarComplete() {
        waitToBeVisible(progressbarComplete);
    }

    public String getProgressbarLabel() {
        return progressbarLabel.getText();
    }
}

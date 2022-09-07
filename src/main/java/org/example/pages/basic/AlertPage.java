package org.example.pages.basic;

import org.example.base.PageBase;
import org.example.enums.AlertButtons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends PageBase {

    @FindBy(id="simple-alert")
    private WebElement simpleAlertButton;

    @FindBy(id="prompt-alert")
    private WebElement promptAlertButton;

    @FindBy(id="confirm-alert")
    private WebElement confirmAlertButton;

    @FindBy(id="delayed-alert")
    private WebElement delayedAlertButton;

    @FindBy(id="simple-alert-label")
    private WebElement simpleAlertLabel;

    @FindBy(id="prompt-label")
    private WebElement promptAlertLabel;

    @FindBy(id="confirm-label")
    private WebElement confirmAlertLabel;

    @FindBy(id="delayed-alert-label")
    private WebElement delayedAlertLabel;

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void clickButton(AlertButtons alertButtons) {
        switch (alertButtons) {
            case SIMPLE -> simpleAlertButton.click();
            case PROMPT -> promptAlertButton.click();
            case CONFIRM -> confirmAlertButton.click();
            case DELAYED-> delayedAlertButton.click();
        }
    }

    public String getButtonLabel(AlertButtons alertButtons) {
        switch (alertButtons) {
            case SIMPLE -> {
                return simpleAlertLabel.getText();
            }
            case PROMPT -> {
                return promptAlertLabel.getText();
            }
            case CONFIRM -> {
                return confirmAlertLabel.getText();
            }
            case DELAYED -> {
                return delayedAlertLabel.getText();
            }
            default -> {
                return "";
            }
        }
    }




}

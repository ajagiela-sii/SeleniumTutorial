package org.example.pages.interactions;

import org.example.base.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectablePage extends PageBase {
    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#selectable .ui-widget-content")
    private List<WebElement> items;
    @FindBy(id = "feedback")
    private  WebElement feedback;

    public void selectItems(int[] items) {
        actions.keyDown(Keys.CONTROL).perform();
        for (int item : items) {
            this.items.get(item-1).click();
        }
        actions.keyUp(Keys.CONTROL).perform();
    }

    public String getFeedback() {
        return feedback.getText();
    }
}

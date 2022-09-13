package org.example.pages.interactions;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends PageBase {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    private WebElement drag;
    @FindBy(id = "droppable")
    private WebElement drop;

    public void dropSmallSquareToBigOne() {
        actions.dragAndDrop(drag, drop).perform();
    }

    public String getBigSquareText() {
        return drop.getText();
    }
}

package org.example.pages.interactions;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraggablePage extends PageBase {
    public DraggablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    private WebElement draggableSquare;

    public void moveObjectToUpperRight() {
        int xOffset = getInnerWindowWidth() - draggableSquare.getLocation().x - draggableSquare.getSize().width;
        int yOffset = -draggableSquare.getLocation().y;

        actions.dragAndDropBy(draggableSquare, xOffset, yOffset).perform();
    }

    public void moveObjectToBottomRight() {
        int xOffset = getInnerWindowWidth() - draggableSquare.getLocation().x - draggableSquare.getSize().width;
        int yOffset = getInnerWindowHeight() - draggableSquare.getLocation().y - draggableSquare.getSize().height;

        actions.dragAndDropBy(draggableSquare, xOffset, yOffset).perform();
    }

    public void moveObjectToCenter() {
        int xOffset = getInnerWindowWidth() / 2 - draggableSquare.getSize().width / 2 - draggableSquare.getLocation().x;
        int yOffset = getInnerWindowHeight() / 2 - draggableSquare.getSize().height / 2 - draggableSquare.getLocation().y;

        actions.dragAndDropBy(draggableSquare, xOffset, yOffset).perform();
    }

    public void moveObjectToBottomLeft() {
        int xOffset = -draggableSquare.getLocation().x;
        int yOffset = getInnerWindowHeight() - draggableSquare.getLocation().y - draggableSquare.getSize().height;

        actions.dragAndDropBy(draggableSquare, xOffset, yOffset).perform();
    }

    public void moveObjectToUpperLeft() {
        int xOffset = -draggableSquare.getLocation().x;
        int yOffset = -draggableSquare.getLocation().y;

        actions.dragAndDropBy(draggableSquare, xOffset, yOffset).perform();
    }
}

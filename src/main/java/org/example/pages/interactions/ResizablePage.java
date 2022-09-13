package org.example.pages.interactions;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResizablePage extends PageBase {
    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "resizable")
    private WebElement resizableBlock;
    @FindBy(className = "ui-resizable-se")
    private WebElement resizeRightAndBottom;

    public void resizeRightAndBottom(int xOffset, int yOffset) {
        int leftAndRightPadding = Integer.parseInt(resizableBlock.getCssValue("padding-left").substring(0,1))
                + Integer.parseInt(resizableBlock.getCssValue("padding-right").substring(0,1));
        int topAndBottomPadding = Integer.parseInt(resizableBlock.getCssValue("padding-top").substring(0,1))
                + Integer.parseInt(resizableBlock.getCssValue("padding-bottom").substring(0,1));

        int leftAndRightBorder = Integer.parseInt(resizableBlock.getCssValue("border-left-width").substring(0,1))
                + Integer.parseInt(resizableBlock.getCssValue("border-right-width").substring(0,1));
        int topAndBottomBorder = Integer.parseInt(resizableBlock.getCssValue("border-top-width").substring(0,1))
                + Integer.parseInt(resizableBlock.getCssValue("border-bottom-width").substring(0,1));

        actions.clickAndHold(resizeRightAndBottom).moveByOffset(xOffset + leftAndRightPadding + leftAndRightBorder,
                yOffset + topAndBottomPadding + topAndBottomBorder).release().build().perform();
    }

    public int getActualHeight() {
        return resizableBlock.getSize().height;
    }

    public int getActualWidth() {
        return resizableBlock.getSize().width;
    }


}

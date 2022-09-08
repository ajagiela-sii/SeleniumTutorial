package org.example.pages.widgets;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TooltipPage extends PageBase {
    public TooltipPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".tooltips [title]")
    private List<WebElement> tooltips;

    public void printAllTooltipsText() {
        for (WebElement tooltip : tooltips) {
            System.out.println(tooltip.getAttribute("title"));
        }
    }
}

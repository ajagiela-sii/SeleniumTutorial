package org.example.pages.widgets;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SelectMenuPage extends PageBase {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    private Logger logger = LoggerFactory.getLogger(SelectMenuPage.class);
    @FindBy(id = "speed-button")
    private WebElement speedBtn;
    @FindBy(css = "#speed-menu .ui-menu-item")
    private List<WebElement> speedOptions;
    @FindBy(id = "files-button")
    private WebElement filesBtn;
    @FindBy(css = "#files-menu .ui-menu-item")
    private List<WebElement> filesOptions;
    @FindBy(id = "number-button")
    private WebElement numberBtn;
    @FindBy(css = "#number-menu .ui-menu-item")
    private List<WebElement> numberOptions;
    @FindBy(id = "salutation-button")
    private WebElement titleBtn;
    @FindBy(css = "#salutation-menu .ui-menu-item")
    private List<WebElement> titleOptions;

    @FindBy(css = "#salutation-button .ui-selectmenu-text")
    private WebElement titleLabel;


    public SelectMenuPage selectRndSpeed() {
        if (speedBtn.getAttribute("aria-expanded").equals("false")) {
            speedBtn.click();
        }
        getRandomObject(speedOptions).click();

        return this;
    }

    public SelectMenuPage selectFile(String fileName) {
        if (filesBtn.getAttribute("aria-expanded").equals("false")) {
            filesBtn.click();
        }
        filesOptions.stream().filter(fileOption -> fileOption.getText().equals(fileName)).findAny().get().click();
        return this;
    }

    public SelectMenuPage selectNumber(int index) {
        if (numberBtn.getAttribute("aria-expanded").equals("false")) {
            numberBtn.click();
        }
        numberOptions.get(index).click();
        return this;
    }

    public SelectMenuPage selectRndTitle() {
        if (titleBtn.getAttribute("aria-expanded").equals("false")) {
            titleBtn.click();
        }
        getRandomObject(titleOptions).click();
        return this;
    }

    public String getTitleValue() {
        return titleLabel.getText();
    }


}

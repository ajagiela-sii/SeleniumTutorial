package org.example.pages.widgets;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccordionPage extends PageBase {

    @FindBy(css = "[aria-controls='ui-id-2']")
    private WebElement section1;

    @FindBy(id = "ui-id-2")
    private WebElement section1Field;

    @FindBy(css = "#ui-id-2 > *")
    private List<WebElement> section1Children;

    @FindBy(id = "ui-id-3")
    private WebElement section2;

    @FindBy(id = "ui-id-4")
    private WebElement section2Field;

    @FindBy(css = "#ui-id-4 > *")
    private List<WebElement> section2Children;

    @FindBy(id = "ui-id-5")
    private WebElement section3;

    @FindBy(id = "ui-id-6")
    private WebElement section3Field;

    @FindBy(css = "#ui-id-6 > *")
    private List<WebElement> section3Children;

    @FindBy(id = "ui-id-7")
    private WebElement section4;

    @FindBy(id = "ui-id-8")
    private WebElement section4Field;

    @FindBy(css = "#ui-id-8 > *")
    private List<WebElement> section4Children;
    @FindBy(className = "ui-accordion-header")
    private List<WebElement> sectionHeaders;
    @FindBy(className = "ui-accordion-content")
    private List<WebElement> sectionContents;


    public AccordionPage(WebDriver driver) {
        super(driver);
    }

    public void printTextInSection(int sectionNumber) {
        switch (sectionNumber) {
            case 1 -> {
                if (!section1Field.isDisplayed()) {
                    section1.click();
                    section1.click();
                }
                for (WebElement section1Child : section1Children) {
                    System.out.println(section1Child.getText());
                }
            }
            case 2 -> {
                if (!section2Field.isDisplayed()) {
                    section2.click();
                    section2.click();
                }
                for (WebElement section2Child : section2Children) {
                    System.out.println(section2Child.getText());
                }
            }
            case 3 -> {
                if (!section3Field.isDisplayed()) {
                    section3.click();
                    section3.click();
                }
                for (WebElement section3Child : section3Children) {
                    System.out.println(section3Child.getText());
                }
            }
            case 4 -> {
                if (!section4Field.isDisplayed()) {
                    section4.click();
                    section4.click();
                }
                for (WebElement section4Child : section4Children) {
                    System.out.println(section4Child.getText());
                }
            }
        }
    }
}

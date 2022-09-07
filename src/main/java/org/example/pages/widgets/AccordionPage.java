package org.example.pages.widgets;

import org.example.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public AccordionPage(WebDriver driver) {
        super(driver);
    }

    public String getTextInSection(int sectionNumber) {
        StringBuilder textToReturning = new StringBuilder("");
        switch (sectionNumber) {
            case 1 -> {
                if (!section1Field.isDisplayed()) {
                    section1.click();
                    section1.click();
                }
                for (WebElement section1Child : section1Children) {
                    textToReturning.append(section1Child.getText());
                    textToReturning.append("\n");
                }
            }
            case 2 -> {
                if (!section2Field.isDisplayed()) {
                    section2.click();
                    section2.click();
                }
                for (WebElement section2Child : section2Children) {
                    textToReturning.append(section2Child.getText());
                    textToReturning.append("\n");
                }
            }
            case 3 -> {
                if (!section3Field.isDisplayed()) {
                    section3.click();
                    section3.click();
                }
                for (WebElement section3Child : section3Children) {
                    textToReturning.append(section3Child.getText());
                    textToReturning.append("\n");
                }
            }
            case 4 -> {
                if (!section4Field.isDisplayed()) {
                    section4.click();
                    section4.click();
                }
                for (WebElement section4Child : section4Children) {
                    textToReturning.append(section4Child.getText());
                    textToReturning.append("\n");
                }
                return textToReturning.toString();
            }

        }
        //System.out.println(textToReturning);
        return textToReturning.toString();
    }

    public void printAllSections() {
        for(int i = 1; i < 8; i += 2) {
            driver.findElement(By.cssSelector("#ui-id-" + i)).click();
            driver.findElement(By.cssSelector("#ui-id-" + i)).click();
            int sectionId = i+1;
            List<WebElement> allChildInSection = driver.findElements(By.cssSelector("#ui-id-" + sectionId + " > *"));
            for (WebElement oneChildInSection : allChildInSection) {
                System.out.println(oneChildInSection.getText());
            }
        }
    }
}

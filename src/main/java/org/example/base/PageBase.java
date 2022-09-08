package org.example.base;

import org.example.enums.Menu;
import org.example.enums.URLs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class PageBase {
    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);

    }

    private static Logger logger = LoggerFactory.getLogger(PageBase.class);
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    private By menuCSS = By.cssSelector(".nav-link");


    public void navigateToPage(URLs tab) {
        driver.get(tab.toString());
    }

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }


    public static int getRandomInt(int bound) {
        return new Random().nextInt(bound);
    }

    public static int getRandomInt(int origin, int bound) {
        return new Random().nextInt(origin, bound);
    }

    public static WebElement getRandomObject(List<WebElement> objectList) {
        return objectList.get(new Random().nextInt(0, objectList.size()));
    }

    public String menuNavigation(Menu menuOption) {
        List<WebElement> menu = driver.findElements(menuCSS);
        if (!menu.isEmpty()) {
            switch (menuOption) {
                case BASIC -> {
                    menu.get(0).click();
                    return menu.get(0).getText();
                }
                case INTERACTIONS -> {
                    menu.get(1).click();
                    return menu.get(1).getText();
                }
                case WIDGETS -> {
                    menu.get(2).click();
                    return menu.get(2).getText();
                }
                case OTHERS -> {
                    menu.get(3).click();
                    return menu.get(3).getText();
                }
                default -> logger.info("MENU does not contains " + menuOption);
            }
        }
        logger.info("MENU is empty");
        return "MENU is empty";
    }

    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitToBeVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void moveMouseToElement(WebElement webElement) {
        actions.moveToElement(webElement).perform();
    }

}

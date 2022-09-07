package org.example.base;

import org.example.enums.AllTabs;
import org.example.enums.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class PageBase {

    private static Logger logger = LoggerFactory.getLogger(PageBase.class);
    protected WebDriver driver;
    private static final Random random = new Random();
    private static By menuCSS = By.cssSelector(".nav-link");


    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToPage(AllTabs tab){
        driver.get(tab.toString());
    }

    public void sendTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(){
        driver.switchTo().alert().dismiss();
    }


    public static int getRandomInt(int bound) {
        return random.nextInt(bound);
    }

    public static int getRandomInt(int origin, int bound) {
        return random.nextInt(origin, bound);
    }

    public static <T> Object getRandomObject(List<T> objectList) {
        return objectList.get(random.nextInt(0, objectList.size()));
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
                    return menu.get(1).getText();}
                case WIDGETS -> {
                    menu.get(2).click();
                    return menu.get(2).getText();}
                case OTHERS -> {
                    menu.get(3).click();
                    return menu.get(3).getText();}
                default -> logger.info("MENU does not contains " + menuOption);
            }
        }
        logger.info("MENU is empty");
        return "MENU is empty";
    }

    public void waitForAlert(int timeInSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForVisibilityOfElement(int timeInSec, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

}

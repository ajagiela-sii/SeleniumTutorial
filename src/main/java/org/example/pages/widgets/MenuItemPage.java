package org.example.pages.widgets;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuItemPage extends PageBase {
    public MenuItemPage(WebDriver driver) {
        super(driver);
    }

    private static Logger logger = LoggerFactory.getLogger(MenuItemPage.class);

    @FindBy(id = "ui-id-2")
    private WebElement books;
    @FindBy(id = "ui-id-3")
    private WebElement clothing;
    @FindBy(id = "ui-id-4")
    private WebElement electronics;
    @FindBy(id = "ui-id-6")
    private WebElement carHiFi;
    @FindBy(id = "ui-id-7")
    private WebElement utilities;
    @FindBy(id = "ui-id-8")
    private WebElement movies;
    @FindBy(id = "ui-id-9")
    private WebElement music;
    @FindBy(id = "ui-id-10")
    private WebElement rock;
    @FindBy(id = "ui-id-11")
    private WebElement alternative;
    @FindBy(id = "ui-id-12")
    private WebElement classic;
    @FindBy(id = "ui-id-13")
    private WebElement jazz;
    @FindBy(id = "ui-id-14")
    private WebElement freeJazz;
    @FindBy(id = "ui-id-15")
    private WebElement bigBand;
    @FindBy(id = "ui-id-16")
    private WebElement modern;
    @FindBy(id = "ui-id-17")
    private WebElement pop;

    public void clickOnItem(String item) {
        switch (item.toLowerCase()) {
            case "books" -> books.click();
            case "clothing" -> clothing.click();
            case "electronics" -> electronics.click();
            case "car hifi", "carhifi", "car_hifi" -> {
                moveMouseToElement(electronics);
                waitToBeClickable(carHiFi);
                carHiFi.click();
            }
            case "utilities" -> {
                moveMouseToElement(electronics);
                waitToBeClickable(utilities);
                utilities.click();
            }
            case "movies" -> movies.click();
            case "music" -> music.click();
            case "rock" -> {
                moveMouseToElement(music);
                waitToBeClickable(rock);
                rock.click();
            }
            case "alternative" -> {
                moveMouseToElement(music);
                waitToBeClickable(rock);
                moveMouseToElement(rock);
                waitToBeClickable(alternative);
                alternative.click();
            }
            case "classic" -> {
                moveMouseToElement(music);
                waitToBeClickable(rock);
                moveMouseToElement(rock);
                waitToBeClickable(classic);
                classic.click();
            }
            case "jazz" -> {
                moveMouseToElement(music);
                waitToBeClickable(jazz);
                jazz.click();
            }
            case "freejazz" -> {
                moveMouseToElement(music);
                waitToBeClickable(jazz);
                moveMouseToElement(jazz);
                waitToBeClickable(freeJazz);
                freeJazz.click();
            }
            case "big band", "big_band", "bigband" -> {
                moveMouseToElement(music);
                waitToBeClickable(jazz);
                moveMouseToElement(jazz);
                waitToBeClickable(bigBand);
                bigBand.click();
            }
            case "modern" -> {
                moveMouseToElement(music);
                waitToBeClickable(jazz);
                moveMouseToElement(jazz);
                waitToBeClickable(modern);
                modern.click();
            }
            case "pop" -> {
                moveMouseToElement(music);
                waitToBeClickable(pop);
                pop.click();
            }
            default -> logger.info("Item " + item + " does not exist");
        }
    }
}
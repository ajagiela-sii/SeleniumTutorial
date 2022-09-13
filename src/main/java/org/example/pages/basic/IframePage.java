package org.example.pages.basic;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class IframePage extends PageBase {

    @FindBy(name="iframe1")
    private WebElement iframe1;
    @FindBy(name="iframe2")
    private WebElement iframe2;
    @FindBy(id = "inputFirstName3")
    private WebElement firstName;
    @FindBy(id = "inputSurname3")
    private WebElement lastName;
    @FindBy(id = "inputLogin")
    private WebElement login;
    @FindBy(id = "inputPassword")
    private WebElement password;
    @FindBy(id = "inlineFormCustomSelectPref")
    private WebElement continentOptions;
    @FindBy(name = "gridRadios")
    List<WebElement> yearOfExperienceOptions;

    public IframePage(WebDriver driver) {
        super(driver);
    }

    public void fillShortForm(String firstName, String lastName) {
        driver.switchTo().frame(iframe1);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        driver.switchTo().defaultContent();
    }

    public void fillExtendForm(String login, String password) {
        driver.switchTo().frame(iframe2);
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        Select continents = new Select(continentOptions);
        continents.selectByIndex(getRandomInt(1, continents.getOptions().size()));
        yearOfExperienceOptions.get(getRandomInt(1,yearOfExperienceOptions.size())).click();
        driver.switchTo().defaultContent();
    }
}

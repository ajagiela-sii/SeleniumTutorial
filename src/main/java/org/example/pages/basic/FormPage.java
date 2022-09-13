package org.example.pages.basic;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

public class FormPage extends PageBase {

    private static Logger logger = LoggerFactory.getLogger(FormPage.class);
    @FindBy(id = "inputFirstName3")
    private WebElement firstName;
    @FindBy(id = "inputLastName3")
    private WebElement lastName;
    @FindBy(id = "inputEmail3")
    private WebElement email;
    @FindBy(className = "btn-primary")
    private WebElement signInButton;
    @FindBy(id = "validator-message")
    private WebElement validationMessage;
    @FindBy(name = "gridRadiosSex")
    private List<WebElement> GenderOptions;
    @FindBy(id = "inputAge3")
    private WebElement age;
    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearOfExperienceOptions;
    @FindBy(className = "checkbox-profession")
    private List<WebElement> professionOptions;
    @FindBy(id = "selectContinents")
    private WebElement continentOptions;
    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommandsOptions;
    @FindBy(id = "chooseFile")
    private WebElement fileInput;
    @FindBy(className = "btn-secondary")
    private WebElement downloadButton;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void setName(String name) {
        this.firstName.sendKeys(name);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setRndGender() {
        (getRandomObject(GenderOptions)).click();
    }

    public void setAge(int age) {
        this.age.sendKeys(String.valueOf(age));
    }

    public void setRndExperience() {
        (getRandomObject(yearOfExperienceOptions)).click();
    }

    public void setRndContinent() {
        Select continents = new Select(continentOptions);
        continents.selectByIndex(getRandomInt(1, continents.getOptions().size()));
    }

    public void setRndContinent(String continent) {
        new Select(continentOptions).selectByValue(continent);
    }

    public void setProfession(String profession) {
        switch (profession.toLowerCase()) {
            case "manual tester" -> professionOptions.get(0).click();
            case "automation tester" -> professionOptions.get(1).click();
            case "other" -> professionOptions.get(3).click();
            default -> logger.info(profession + " profession does not exist");
        }
    }

    public void setSeleniumCommand(String command) {
        new Select(seleniumCommandsOptions).selectByValue(command);

    }

    public void addFile(File file) {
        fileInput.sendKeys(file.getAbsolutePath());
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public String getValidationMessage() {
        return validationMessage.getText();
    }

    public void downloadFile() {

        downloadButton.click();
    }
}

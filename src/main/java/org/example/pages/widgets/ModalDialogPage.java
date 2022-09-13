package org.example.pages.widgets;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalDialogPage extends PageBase {
    public ModalDialogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "create-user")
    private WebElement createUserBtn;
    @FindBy(id = "name")
    private WebElement nameInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[.=\"Create an account\"]")
    private WebElement createAccountBtn;
    @FindBy(css = "tbody tr:last-child")
    private WebElement lastCreatedUser;

    public void createNewUser(String name, String email, String password) {
        createUserBtn.click();
        nameInput.clear();
        nameInput.sendKeys(name);
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        createAccountBtn.click();
    }

    public String getLastCreatedUser() {
        return lastCreatedUser.getText();
    }


}

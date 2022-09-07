package org.example.pages.widgets;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutocompletePage extends PageBase {

    @FindBy(id = "search")
    private WebElement searchField;
    @FindBy(className = "ui-menu-item")
    private List<WebElement> autocompleteOptions;

    public AutocompletePage(WebDriver driver) {
        super(driver);
    }

    public String selectRandomAutocompleteOption(String textToInput){
        searchField.sendKeys(textToInput);
        for (WebElement autocompleteOption : autocompleteOptions) {
            System.out.println(autocompleteOption.getText());
        }
        WebElement chosenOption =  (WebElement) getRandomObject(autocompleteOptions);
        chosenOption.click();
        return chosenOption.getText();
    }

    public String getTextInSearchField() {
        return searchField.getText();
    }
}

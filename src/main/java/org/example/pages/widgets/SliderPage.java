package org.example.pages.widgets;

import org.example.base.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends PageBase {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "custom-handle")
    private WebElement sliderHandler;

    public void moveSliderTo(int percent) {
        if (percent >= 0 && percent <= 100) {
            int actualPercentValue = getActualValue();
            if (actualPercentValue > percent) {
                while (Integer.parseInt(sliderHandler.getText()) != percent) {
                    sliderHandler.sendKeys(Keys.ARROW_LEFT);
                }
                actions.release();
            } else if (actualPercentValue < percent) {
                while (getActualValue() != percent) {
                    sliderHandler.sendKeys(Keys.ARROW_RIGHT);
                }
                actions.release();
            }
        }
    }

    public int getActualValue() {
        return Integer.parseInt(sliderHandler.getText());
    }
}

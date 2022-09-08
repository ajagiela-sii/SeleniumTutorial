package org.example.pages.widgets;

import org.apache.commons.lang3.ArrayUtils;
import org.example.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;


public class DatapickerPage extends PageBase {
    @FindBy(id = "datepicker")
    private WebElement datepicker;
    @FindBy(id = "ui-datepicker-div")
    private WebElement datepickerBlock;
    @FindBy(className = "ui-datepicker-title")
    private WebElement actualMonthYear;
    @FindBy(className = "ui-datepicker-next")
    private WebElement nextButton;
    @FindBy(className = "ui-datepicker-prev")
    private WebElement previousButton;
    public DatapickerPage(WebDriver driver) {
        super(driver);
    }

    public void selectData(int month, int day, int year) {
//        if (day.matches("^0.")) {
//            day = day.substring(1);
//        }
        datepicker.click();
        waitToBeVisible(datepickerBlock);
        String actualMonthYearValue = actualMonthYear.getText();

        String actualMonth = getMonthYear(actualMonthYearValue)[0].toLowerCase();
        int actualYear = Integer.parseInt(getMonthYear(actualMonthYearValue)[1]);

        while(!((getMonthYear(actualMonthYearValue)[0]).equalsIgnoreCase(monthToText(month)) && Integer.parseInt(getMonthYear(actualMonthYearValue)[1]) == year)){

            if (actualYear > year) {
                previousButton.click();
            } else if(actualYear < year) {
                nextButton.click();
            } else {
                if(monthToNumber(actualMonth) > month-1){
                    previousButton.click();
                } else if (monthToNumber(actualMonth) < month-1){
                    nextButton.click();
                }
            }
            actualMonthYearValue = actualMonthYear.getText();;
        }

        driver.findElement(By.xpath("//td[@data-month='" + (month-1) + "']/a[text()='" + day + "']")).click();
    }

    public String getSelectedDate(){
        return datepicker.getAttribute("value");
    }

    private String[] getMonthYear(String monthYearValue){
        return monthYearValue.split(" ");
    }

    private int monthToNumber(String month){
          String[] months = new String[]{"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november"};

          return ArrayUtils.indexOf(months, month.toLowerCase());

/*        switch (month.toLowerCase()){
            case "january":
                return 0;
            case "february":
                return 1;
            case "march":
                return 2;
            case "april":
                return 3;
            case "may":
                return 4;
            case "june":
                return 5;
            case "july":
                return 6;
            case "august":
                return 7;
            case "september":
                return 8;
            case "october":
                return 9;
            case "november":
                return 10;
            case "december":
                return 11;
            default:
                return -1;
        }*/
    }
    private String monthToText(int integerMonth) {
        return Month.of(integerMonth).getDisplayName(TextStyle.FULL_STANDALONE, Locale.US);
    }
}

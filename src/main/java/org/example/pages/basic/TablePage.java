package org.example.pages.basic;

import org.example.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TablePage extends PageBase {

    private static Logger logger = LoggerFactory.getLogger(TablePage.class);

    @FindBy(css = "tbody tr")
    private List<WebElement> allPeaks;
    @FindBy(css = "thead th")
    private List<WebElement> tableHeaders;

    public TablePage(WebDriver driver) {
        super(driver);
    }

//Solution without modification
    public HashMap<String, Integer> getHeaderValues() {

        HashMap<String, Integer> columnNameAndNumber = new HashMap<>();
        if (!tableHeaders.isEmpty()) {
            for (int i = 0; i < tableHeaders.size(); i++) {
                columnNameAndNumber.put(tableHeaders.get(i).getText(), i);
            }
        } else {
            logger.info("HEADER is empty");
        }
        return columnNameAndNumber;
    }

    public void printRankPeakMountainRange(String state, int higherThan) {
        HashMap<String, Integer> headers = getHeaderValues();
        allPeaks.stream()
                .filter(row -> row.findElements(By.cssSelector("tr *")).get(headers.get("State")).getText().contains(state))
                .filter(row -> Integer.parseInt(row.findElements(By.cssSelector("tr *")).get(headers.get("Height")).getText()) > higherThan)
                .forEach(row -> System.out.println(row.findElements(By.cssSelector("tr *")).get(headers.get("Rank")).getText()
                                                + " " + row.findElements(By.cssSelector("tr *")).get(headers.get("Peak")).getText()
                                                + " " + row.findElements(By.cssSelector("tr *")).get(headers.get("Mountain range")).getText()));

    }

// Solutions after modification
    public List<RowPage> getAllPeaks() {
        return allPeaks.stream().map(RowPage::new).collect(Collectors.toList());
    }

}

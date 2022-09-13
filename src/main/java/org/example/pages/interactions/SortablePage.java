package org.example.pages.interactions;

import org.example.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortablePage extends PageBase {
    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public List<Integer> getShuffleList() {
        List<Integer> shuffledList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Collections.shuffle(shuffledList);

        return shuffledList;
    }

    public List<Integer> putElementsInOrder(List<Integer> order) {

        for (int i = 1; i <= 7; i++) {
            WebElement actualElementOnIPosition = driver.findElement(By.cssSelector("li.ui-sortable-handle:nth-child(" + i + ")"));
            int iChild = Integer.parseInt(actualElementOnIPosition.getText().substring(5));
            if (iChild != order.get(i - 1)) {
                WebElement expectedElement = driver.findElement(By.xpath("//*[text() = 'Item " + order.get(i - 1) + "']"));
                actions.dragAndDrop(expectedElement, actualElementOnIPosition).build().perform();
            }
        }
        return order;
    }

    public List<Integer> getCurrentOrder() {
        List<Integer> order = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            String text = driver.findElement(By.cssSelector("li.ui-sortable-handle:nth-child(" + i + ")")).getText();
            Integer value = Integer.valueOf(text.substring(5));
            order.add(value);
        }
        return order;
    }
}

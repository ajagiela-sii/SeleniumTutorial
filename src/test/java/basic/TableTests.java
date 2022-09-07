package basic;

import base.TestBase;
import org.example.enums.AllTabs;
import org.example.pages.basic.TablePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TableTests extends TestBase {

    @Test
    void shouldPrintAll() {
        TablePage tablePage = new TablePage(driver);
        tablePage.navigateToPage(AllTabs.TABLE);
        tablePage.printRankPeakMountainRange("Switzerland", 4000);
    }
}

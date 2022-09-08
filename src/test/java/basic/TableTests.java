package basic;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.basic.TablePage;
import org.junit.jupiter.api.Test;

public class TableTests extends TestBase {

    @Test
    void shouldPrintAll() {
        TablePage tablePage = new TablePage(driver);
        tablePage.navigateToPage(URLs.TABLE);
        tablePage.printRankPeakMountainRange("Switzerland", 4000);
    }
}

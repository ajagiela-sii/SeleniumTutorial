package basic;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.basic.RowPage;
import org.example.pages.basic.TablePage;
import org.junit.jupiter.api.Test;

public class TableTests extends TestBase {

    @Test
    void tableTest() {
        TablePage tablePage = new TablePage(driver);
        tablePage.navigateToPage(URLs.TABLE);
        tablePage.printRankPeakMountainRange("Switzerland", 4000);
    }

    @Test
    void tableTestWithPo() {
        TablePage tablePage = new TablePage(driver);
        tablePage.navigateToPage(URLs.TABLE);

        for (RowPage peakData : tablePage.getAllPeaks()) {
            if (peakData.getState().contains("Switzerland") && peakData.getHeight() > 4000) {
                System.out.println(peakData.getRank() + " " + peakData.getPeakName() + " " + peakData.getMountainRange());
            }
        }
    }
}

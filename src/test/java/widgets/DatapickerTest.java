package widgets;

import base.TestBase;
import org.example.enums.AllTabs;
import org.example.pages.widgets.DatapickerPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class DatapickerTest extends TestBase {

    @Test
    public void datePickerTest() {

        DatapickerPage datapickerPage = new DatapickerPage(driver);
        datapickerPage.navigateToPage(AllTabs.DATAPICKER);


        SimpleDateFormat simpleFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        String fullData = simpleFormat.format(new Date());
        String[] today = fullData.split("/");
        int actualMonth = Integer.parseInt(today[0]);
        int actualDay = Integer.parseInt(today[1]);
        int actualYear = Integer.parseInt(today[2]);

        //Today
        datapickerPage.selectData(actualMonth, actualDay, actualYear);
        assertThat(datapickerPage.getSelectedDate()).isEqualTo(fullData);

        //1st day from next month
        datapickerPage.selectData(actualMonth + 1, 1, actualYear);
        assertThat(datapickerPage.getSelectedDate()).isEqualTo("10/01/2022");

        //Last day from January in next year: 31.01.2023
        datapickerPage.selectData(1, 31, actualYear+1);

        //31.01.2023
        datapickerPage.selectData(1, 31, actualYear+1);

        //Random day from previous month
        datapickerPage.selectData(actualMonth-1, 1, actualYear);

        //Random date from last year
        datapickerPage.selectData(2, 1, actualYear-1);

    }
}

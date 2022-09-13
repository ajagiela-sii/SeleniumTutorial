package widgets;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.widgets.DatapickerPage;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class DatapickerTests extends TestBase {

    @Test
    public void datePickerTest() {

        DatapickerPage datapickerPage = new DatapickerPage(driver);
        SimpleDateFormat simpleFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        String fullData = simpleFormat.format(new Date());
        String[] today = fullData.split("/");
        int actualMonth = Integer.parseInt(today[0]);
        int actualDay = Integer.parseInt(today[1]);
        int actualYear = Integer.parseInt(today[2]);

        datapickerPage.navigateToPage(URLs.DATAPICKER);
        //Today
        datapickerPage.selectData(actualMonth, actualDay, actualYear);
        assertThat(datapickerPage.getSelectedDate()).isEqualTo(fullData);

        //1st day from next month
        datapickerPage.selectData(10, 1, 2022);
        assertThat(datapickerPage.getSelectedDate()).isEqualTo("10/01/2022");

        //Last day from January in next year: 31.01.2023
        datapickerPage.selectData(1, 31, 2023);
        assertThat(datapickerPage.getSelectedDate()).isEqualTo("01/31/2023");

        //31.01.2023
        datapickerPage.selectData(1, 31, 2023);
        assertThat(datapickerPage.getSelectedDate()).isEqualTo("01/31/2023");

        //Random day from previous month
        datapickerPage.selectData(8, 8, 2022);
        assertThat(datapickerPage.getSelectedDate()).isEqualTo("08/08/2022");

        //Random date from last year
        datapickerPage.selectData(3, 23, 2021);
        assertThat(datapickerPage.getSelectedDate()).isEqualTo("03/23/2021");

    }
}

package interactions;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.interactions.SelectablePage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectableTests extends TestBase {

    @Test
    void shouldSelectItems() {
        SelectablePage selectablePage = new SelectablePage(driver);

        selectablePage.navigateToPage(URLs.SELECTABLE);
        int[] options = new int[]{1, 3, 4};
        selectablePage.selectItems(options);

        assertThat(selectablePage.getFeedback()).isEqualTo("You've selected: #1 #3 #4.");
    }
}

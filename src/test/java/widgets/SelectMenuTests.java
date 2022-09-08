package widgets;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.widgets.SelectMenuPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectMenuTests extends TestBase {

    @Test
    void shouldFillAllSelectMenu() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        selectMenuPage.navigateToPage(URLs.SELECT_MENU);

        selectMenuPage
                .selectRndSpeed()
                .selectFile("Some unknown file")
                .selectNumber(8)
                .selectRndTitle();

        assertThat(selectMenuPage.getTitleValue()).isNotEqualTo("Please pick one");
    }
}

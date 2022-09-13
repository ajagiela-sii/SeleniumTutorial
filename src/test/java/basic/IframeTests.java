package basic;

import base.TestBase;
import org.example.base.PageBase;
import org.example.enums.URLs;
import org.example.pages.basic.IframePage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IframeTests extends TestBase {

    @Test
    void shouldFillTwoIFrames() {
        IframePage iframePage = new IframePage(driver);
        iframePage.navigateToPage(URLs.IFRAMES);

        iframePage.fillShortForm("Jan", "Nowak");
        iframePage.fillExtendForm("asd", "sdef");
        String menu = iframePage.menuNavigation(PageBase.Menu.BASIC);

        assertThat(menu).isEqualTo("Basic");
    }
}

package others;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.others.HighSitePage;
import org.junit.jupiter.api.Test;

public class HighSiteTests extends TestBase {

    @Test
    void ScrollToButtonAndTakeScreenShot() throws Exception {
        HighSitePage highSitePage = new HighSitePage(driver);
        highSitePage.navigateToPage(URLs.HIGHSITE);

        highSitePage.scrollToButton();
        highSitePage.takeSnapShot(driver, "src\\main\\resources\\screen.png");
    }
}

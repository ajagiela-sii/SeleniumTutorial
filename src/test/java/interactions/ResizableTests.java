package interactions;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.interactions.ResizablePage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResizableTests extends TestBase {

    @Test
    void shouldResizeElement() {
        ResizablePage resizablePage = new ResizablePage(driver);

        resizablePage.navigateToPage(URLs.RESIZABLE);
        int startHeight = resizablePage.getActualHeight();
        int startWidth = resizablePage.getActualWidth();
        resizablePage.resizeRightAndBottom(10, 0);
        resizablePage.resizeRightAndBottom(0, 10);
        resizablePage.resizeRightAndBottom(10, 10);

        assertThat(resizablePage.getActualWidth()).isEqualTo(startWidth + 20);
        assertThat(resizablePage.getActualHeight()).isEqualTo(startHeight + 20);
    }
}

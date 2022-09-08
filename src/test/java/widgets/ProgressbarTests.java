package widgets;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.widgets.ProgressbarPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgressbarTests extends TestBase {
    @Test
    void shouldWaitForComplete() {
        ProgressbarPage progressbarPage = new ProgressbarPage(driver);

        progressbarPage.navigateToPage(URLs.PROGRESSBAR);
        progressbarPage.waitUntilProgressbarComplete();

        assertThat(progressbarPage.getProgressbarLabel()).isEqualTo("Complete!");
    }
}

package widgets;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.widgets.TooltipPage;
import org.junit.jupiter.api.Test;

public class TooltipTests extends TestBase {

    @Test
    void shouldReturnAllTooltipsTexts() {
        TooltipPage tooltipPage = new TooltipPage(driver);
        tooltipPage.navigateToPage(URLs.TOOLTIP);
        tooltipPage.printAllTooltipsText();
    }
}

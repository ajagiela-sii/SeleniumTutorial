package basic;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.basic.TablePage;
import org.example.pages.basic.WindowPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowTests extends TestBase{

    @Test
    void shouldClickAllButtons() {
        WindowPage windowPage = new WindowPage(driver);
        windowPage.navigateToPage(URLs.WINDOWTABS);
        windowPage.setOriginalWindow();
        windowPage.clickButton(WindowPage.WindowButtons.BROWSER_WINDOW);
        windowPage.switchToNewWindow();

        TablePage tablePage = new TablePage(driver);
        tablePage.printRankPeakMountainRange("Switzerland", 4000);
        windowPage.closeWindow();
        windowPage.switchToOriginalWindow();

        windowPage.clickButton(WindowPage.WindowButtons.MESSAGE_WINDOW);
        windowPage.switchToNewWindow();
        windowPage.printBody();
        windowPage.closeWindow();
        windowPage.switchToOriginalWindow();

        windowPage.clickButton(WindowPage.WindowButtons.BROWSER_TAB);
        windowPage.switchToNewWindow();
        tablePage.printRankPeakMountainRange("Switzerland", 4000);
        windowPage.closeWindow();
        windowPage.switchToOriginalWindow();

        assertThat(windowPage.buttonIsVisible(WindowPage.WindowButtons.BROWSER_WINDOW)).isTrue();

    }
}

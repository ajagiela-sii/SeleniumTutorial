package widgets;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.widgets.MenuItemPage;
import org.junit.jupiter.api.Test;

public class MenuItemTests extends TestBase {

    @Test
    void shouldClickModern() {
        MenuItemPage menuItemPage = new MenuItemPage(driver);

        menuItemPage.navigateToPage(URLs.MENU);
        menuItemPage.clickOnItem("Modern");
    }
}

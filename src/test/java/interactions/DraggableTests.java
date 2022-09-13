package interactions;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.interactions.DraggablePage;
import org.junit.jupiter.api.Test;

public class DraggableTests extends TestBase {

    @Test
    void shouldDragSquareAroundPage() {
        DraggablePage draggablePage = new DraggablePage(driver);
        draggablePage.navigateToPage(URLs.DRAGGABLE);
        draggablePage.moveObjectToUpperRight();
        draggablePage.moveObjectToBottomRight();
        draggablePage.moveObjectToCenter();
        draggablePage.moveObjectToBottomLeft();
        draggablePage.moveObjectToUpperLeft();
    }
}

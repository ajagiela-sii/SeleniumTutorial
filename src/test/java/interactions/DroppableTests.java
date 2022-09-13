package interactions;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.interactions.DroppablePage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DroppableTests extends TestBase {

    @Test
    void shouldDropSmallSquareToBigOne() {
        DroppablePage droppablePage = new DroppablePage(driver);

        droppablePage.navigateToPage(URLs.DROPPABLE);
        droppablePage.dropSmallSquareToBigOne();

        assertThat(droppablePage.getBigSquareText()).isEqualTo("Dropped!");
    }
}

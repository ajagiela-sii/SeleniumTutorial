package interactions;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.interactions.SortablePage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortableTests extends TestBase {

    @Test
    void shouldShuffleList() {
        SortablePage sortablePage = new SortablePage(driver);

        sortablePage.navigateToPage(URLs.SORTABLE);
        List<Integer> shuffledOrder = sortablePage.getShuffleList();
        sortablePage.putElementsInOrder(shuffledOrder);
        List<Integer> currentOrder = sortablePage.getCurrentOrder();

        assertThat(shuffledOrder).usingRecursiveComparison().isEqualTo(currentOrder);
    }
}


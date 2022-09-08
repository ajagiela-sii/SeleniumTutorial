package widgets;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.widgets.AutocompletePage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutocompleteTests extends TestBase {

    @Test
    void shouldChoseRandomOption() {
        AutocompletePage autocompletePage = new AutocompletePage(driver);

        autocompletePage.navigateToPage(URLs.AUTOCOMPLETE);
        String chosenOption = autocompletePage.selectRandomAutocompleteOption("a");

        assertThat(autocompletePage.getTextInSearchField()).isEqualTo(chosenOption);
    }
}

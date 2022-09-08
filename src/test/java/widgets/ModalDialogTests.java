package widgets;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.widgets.ModalDialogPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModalDialogTests extends TestBase {

    @Test
    void shouldAddNewUser() {
        ModalDialogPage modalDialogPage = new ModalDialogPage(driver);

        modalDialogPage.navigateToPage(URLs.MODAL_DIALOG);
        modalDialogPage.createNewUser("Jan Kowalski", "jan@email.com", "password123");

        assertThat(modalDialogPage.getLastCreatedUser()).isEqualTo("Jan Kowalski jan@email.com password123");
    }


}

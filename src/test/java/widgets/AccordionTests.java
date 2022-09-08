package widgets;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.widgets.AccordionPage;
import org.junit.jupiter.api.Test;

public class AccordionTests extends TestBase {

    @Test
    void shouldPrintTextFromAllSections() {
        AccordionPage accordionPage = new AccordionPage(driver);

        accordionPage.navigateToPage(URLs.ACCORDION);
        accordionPage.printTextInSection(1);
        accordionPage.printTextInSection(2);
        accordionPage.printTextInSection(3);
        accordionPage.printTextInSection(4);

    }
}

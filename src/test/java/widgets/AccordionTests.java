package widgets;

import base.TestBase;
import org.example.enums.AllTabs;
import org.example.pages.widgets.AccordionPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccordionTests extends TestBase {

    @Test
    void shouldPrintTextFromAllSections() {
        AccordionPage accordionPage = new AccordionPage(driver);
        accordionPage.navigateToPage(AllTabs.ACCORDION);
        StringBuilder textToPrinting = new StringBuilder();
        String text1 = accordionPage.getTextInSection(1);
        String text2 = accordionPage.getTextInSection(2);
        String text3 = accordionPage.getTextInSection(3);
        String text4 = accordionPage.getTextInSection(4);
        System.out.println(textToPrinting);
        assertThat(text1 + "\n" + text2 + "\n" + text3 + "\n" + text4 + "\n").contains("Mauris mauris ante", "Sed non urna", "Nam enim risus", "List item one", "List item two", "List item three", "Cras dictum", "Suspendisse");

    }
}

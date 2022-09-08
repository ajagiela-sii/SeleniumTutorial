package widgets;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.widgets.SliderPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SliderTests extends TestBase {

    @Test
    void shouldMoveSliderToSpecificValue() {
        SliderPage sliderPage = new SliderPage(driver);

        sliderPage.navigateToPage(URLs.SLIDER);
        sliderPage.moveSliderTo(50);
        assertThat(sliderPage.getActualValue()).isEqualTo(50);

        sliderPage.moveSliderTo(80);
        assertThat(sliderPage.getActualValue()).isEqualTo(80);

        sliderPage.moveSliderTo(80);
        assertThat(sliderPage.getActualValue()).isEqualTo(80);

        sliderPage.moveSliderTo(20);
        assertThat(sliderPage.getActualValue()).isEqualTo(20);

        sliderPage.moveSliderTo(0);
        assertThat(sliderPage.getActualValue()).isEqualTo(0);
    }
}

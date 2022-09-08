package basic;

import base.TestBase;
import org.example.enums.URLs;
import org.example.enums.AlertButtons;
import org.example.pages.basic.AlertPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertTests extends TestBase {


    @Test
    void shouldAcceptSimpleAlert() {
        AlertPage alertPage = new AlertPage(driver);

        alertPage.navigateToPage(URLs.ALERTS);
        alertPage.clickButton(AlertButtons.SIMPLE);
        alertPage.acceptAlert();

        assertThat(alertPage.getButtonLabel(AlertButtons.SIMPLE)).isEqualTo("OK button pressed");
    }

    @ParameterizedTest
    @ValueSource(strings={"Lord Vader"})
    void shouldSendTextToPromptAlertAndAccept(String name) {
        AlertPage alertPage = new AlertPage(driver);

        alertPage.navigateToPage(URLs.ALERTS);
        alertPage.clickButton(AlertButtons.PROMPT);
        alertPage.sendTextToAlert(name);
        alertPage.acceptAlert();

        assertThat(alertPage.getButtonLabel(AlertButtons.PROMPT)).isEqualTo("Hello " + name + "! How are you today?");
    }

    @Test
    public void shouldAcceptAndCancelAlertBox() {
        AlertPage alertPage = new AlertPage(driver);

        alertPage.navigateToPage(URLs.ALERTS);
        alertPage.clickButton(AlertButtons.CONFIRM);
        alertPage.acceptAlert();
        assertThat(alertPage.getButtonLabel(AlertButtons.CONFIRM)).isEqualTo("You pressed OK!");
        alertPage.clickButton(AlertButtons.CONFIRM);
        alertPage.cancelAlert();

        assertThat(alertPage.getButtonLabel(AlertButtons.CONFIRM)).isEqualTo("You pressed Cancel!");
    }

    @Test
    public void shouldAcceptDelayedAlert() {
        AlertPage alertPage= new AlertPage(driver);

        alertPage.navigateToPage(URLs.ALERTS);
        alertPage.clickButton(AlertButtons.DELAYED);
        alertPage.waitForAlert();
        alertPage.acceptAlert();

        assertThat(alertPage.getButtonLabel(AlertButtons.DELAYED)).isEqualTo("OK button pressed");
    }
}

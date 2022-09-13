package basic;

import base.TestBase;
import org.example.enums.URLs;
import org.example.pages.basic.FormPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class FormTests extends TestBase {

    @Test
    void shouldFillFormWithSuccess() {
        File file = new File("src/main/resources/file.txt");
        FormPage formPage = new FormPage(driver);

        formPage.navigateToPage(URLs.FORM);
        formPage.setName("Jan");
        formPage.setLastName("Kowalski");
        formPage.setEmail("jankowalski123@email.pl");
        formPage.setRndGender();
        formPage.setAge(38);
        formPage.setRndExperience();
        formPage.setProfession("Automation Tester");
        formPage.setRndContinent();
        formPage.setSeleniumCommand("switch-commands");
        formPage.setSeleniumCommand("wait-commands");
        formPage.addFile(file);
        formPage.clickSignIn();

        assertThat(formPage.getValidationMessage()).isEqualTo("Form send with success");
    }

    @Test
    void downloadFile() throws InterruptedException {
        FormPage formPage = new FormPage(driver);
        formPage.navigateToPage(URLs.FORM);
        formPage.downloadFile();
        Thread.sleep(10000);

    }
}

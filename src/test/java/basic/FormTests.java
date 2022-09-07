package basic;

import base.TestBase;
import org.example.enums.AllTabs;
import org.example.pages.basic.FormPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class FormTests extends TestBase {

    @Test
    void shouldFillFormWithSuccess() {
        File file = new File("src/main/resources/file.txt");
        FormPage formPage = new FormPage(driver);

        formPage.navigateToPage(AllTabs.FORM);
        formPage.setName("Jan");
        formPage.setLastName("Kowalski");
        formPage.setEmail("jankowalski123@email.pl");
        formPage.setGender();
        formPage.setAge(38);
        formPage.setExperience();
        formPage.setProfession("Automation Tester");
        formPage.setContinent();
        formPage.setSeleniumCommand("switch-commands");
        formPage.setSeleniumCommand("wait-commands");
        formPage.addFile(file);
        formPage.clickSignIn();

        assertThat(formPage.getValidationMessage()).isEqualTo("Form send with success");
    }

    @Test
    void downloadFile() {
        FormPage formPage = new FormPage(driver);
        formPage.navigateToPage(AllTabs.FORM);
        formPage.clickDownload();

    }
}

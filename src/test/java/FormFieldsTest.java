import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

import static org.junit.Assert.*;

@DisplayName("Кейсы тестирования формы practice-automation")
public class FormFieldsTest {

    private WebDriver driver;
    private FormFieldsPage formFieldsPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://practice-automation.com/form-fields/");
        formFieldsPage = new FormFieldsPage(driver);
        this.driver = driver;
    }

    @Test
    @DisplayName("Часть 1. Автоматизация. Работа с полями и формами.")
    @Owner("Max Kulygin")
    public void testFormSubmission() throws IOException {
        formFieldsPage.fillName("Max Kulygin")
                .fillPassword("12345678")
                .selectFavDrink("Milk")
                .selectFavDrink("Coffee")
                .selectFavColor("Yellow")
                .selectAutomationFirstElement()
                .fillEmail("akademuk97@gmail.com")
                .fillMessage(
                        "Tools count: " + formFieldsPage.countAutomationTools()
                                + "\nLongest tool name: " + formFieldsPage.findLongestAutomationToolName())
                .makeFormPartialScreenshot()
                .clickSubmitButton();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("Message received!", alertText);
        alert.accept();
    }

    @Test
    @DisplayName("Кейс 1 (позитивный): успешный сабмит с минимальным количеством данных")
    @Owner("Max Kulygin")
    public void testFormSubmissionWithRequiredOnly() {
        formFieldsPage.fillName("Max Kulygin")
                .clickSubmitButton();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("Message received!", alertText);
        alert.accept();
    }

    @Test
    @DisplayName("Кейс 2 (негативный): попытка сабмита с некорректным форматом электронной почты")
    @Owner("Max Kulygin")
    public void testFormSubmissionWithInvalidEmail() {
        formFieldsPage.fillName("Max Kulygin")
                .fillEmail("pochta.mailru")
                .clickSubmitButton();

        assertFalse(isAlertPresent());
    }

    @Test
    @DisplayName("Кейс 3 (негативный): попытка сабмита без указания имени")
    @Owner("Max Kulygin")
    public void testFormSubmissionWithEmptyName() {
        formFieldsPage.fillPassword("12345678")
                .fillEmail("qwe@email.ru")
                .fillMessage("Nemo")
                .clickSubmitButton();

        assertTrue(formFieldsPage.isDisplayedNameWarning());
        assertFalse(isAlertPresent());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
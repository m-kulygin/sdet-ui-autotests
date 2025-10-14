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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@DisplayName("Кейсы тестирования формы practice-automation")
public class FormFieldsTest {

    private WebDriver driver;
    private FormFieldsPage formFieldsPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
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
                .makeFormScreenshot()
                .clickSubmitButton();
        assertTrue(isMessageReceivedAlertPresent());
    }

    @Test
    @DisplayName("Кейс 1 (позитивный): успешный сабмит с минимальным количеством данных")
    @Owner("Max Kulygin")
    public void testFormSubmissionWithRequiredOnly() throws IOException {
        formFieldsPage.fillName("Max Kulygin")
                .makeFormScreenshot()
                .clickSubmitButton();
        assertTrue(isMessageReceivedAlertPresent());
    }

    @Test
    @DisplayName("Кейс 2 (негативный): попытка сабмита с некорректным форматом электронной почты")
    @Owner("Max Kulygin")
    public void testFormSubmissionWithInvalidEmail() throws IOException {
        formFieldsPage.fillName("Max Kulygin")
                .fillEmail("pochta.mailru")
                .makeFormScreenshot()
                .clickSubmitButton();
        assertFalse(isAlertPresent());
    }

    @Test
    @DisplayName("Кейс 3 (негативный): попытка сабмита без указания имени")
    @Owner("Max Kulygin")
    public void testFormSubmissionWithEmptyName() throws IOException {
        formFieldsPage.fillPassword("12345678")
                .fillEmail("qwe@email.ru")
                .fillMessage("Nemo")
                .makeFormScreenshot()
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

    private boolean isMessageReceivedAlertPresent() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText.equals("Message received!");
    }
}
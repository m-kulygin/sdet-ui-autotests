import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
    public void testFormSubmission() {
        formFieldsPage.fillName("Max Kulygin")
                .fillPassword("12345678")
                .selectMilk()
                .selectCoffee()
                .selectYellow()
                .selectAutomationFirstElement()
                .fillEmail("akademuk97@gmail.com")
                .fillMessage(
                        "Tools count: " + formFieldsPage.countAutomationTools()
                        + "\nLongest tool name: " + formFieldsPage.findLongestAutomationToolName())
                .clickSubmitButton();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("Message received!", alertText);
        alert.accept();
    }

    @Test
    public void testFormSubmissionWithRequiredOnly() {
        formFieldsPage.fillName("Max Kulygin")
                .clickSubmitButton();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("Message received!", alertText);
        alert.accept();
    }

    @Test
    public void testFormSubmissionWithInvalidEmail() {
        formFieldsPage.fillName("Max Kulygin")
                .fillEmail("pochta.mailru")
                .clickSubmitButton();

        assertFalse(isAlertPresent());
    }

    @Test
    public void testFormSubmissionWithEmptyName() {
        formFieldsPage.fillPassword("12345678")
                .fillEmail("qwe@email.ru")
                .fillMessage("Nemo")
                .clickSubmitButton();

        assertFalse(isAlertPresent());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private boolean isAlertPresent() {
        try{
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
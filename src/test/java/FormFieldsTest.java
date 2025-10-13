import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class FormFieldsTest {

    private WebDriver driver;
    private FormFieldsPage formFieldsPage;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://practice-automation.com/form-fields/");
        formFieldsPage = new FormFieldsPage(driver);
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

    @After
    public void tearDown() {
        driver.quit();
    }
}
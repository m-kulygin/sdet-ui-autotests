import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class FormFieldsPage {
    private final WebDriver driver;

    @FindBy(id = "name-input")
    private WebElement nameField;

    @FindBy(css = "input[type=password]")
    private WebElement passwordField;

    @FindBy(css = "input[type='checkbox'][value='Milk']")
    private WebElement milkCheckbox;

    @FindBy(css = "input[type='checkbox'][value='Coffee']")
    private WebElement coffeeCheckbox;

    @FindBy(css = "input[type='radio'][value='Yellow']")
    private WebElement yellowCheckbox;

    @FindBy(id = "automation")
    private WebElement automationDropdown;

    @FindBy(css = "input[type='text'][id='email']")
    private WebElement emailField;

    @FindBy(css = "ul li")
    private List<WebElement> automationToolsList;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messageField;

    @FindBy(id = "submit-btn")
    private WebElement submitButton;

    public FormFieldsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Заполнение поля Name значением {name}")
    public FormFieldsPage fillName(String name) {
        nameField.sendKeys(name);
        return this;
    }

    @Step("Заполнение поля Password значением {password}")
    public FormFieldsPage fillPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Отметка чекбокса Milk")
    public FormFieldsPage selectMilk() {
        milkCheckbox.click();
        return this;
    }

    @Step("Отметка чекбокса Coffee")
    public FormFieldsPage selectCoffee() {
        coffeeCheckbox.click();
        return this;
    }

    @Step("Отметка радиокнопки цвета Yellow")
    public FormFieldsPage selectYellow() {
        yellowCheckbox.click();
        return this;
    }

    @Step("Выбор первого элемента в dropdown-списке automation")
    public FormFieldsPage selectAutomationFirstElement() {
        Select select = new Select(automationDropdown);
        select.selectByIndex(1);
        return this;
    }

    @Step("Заполнение поля Email значением {email}")
    public FormFieldsPage fillEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("Подсчёт количества элементов в списке automation tools")
    public int countAutomationTools() {
        return automationToolsList.size();
    }

    @Step("Нахождение самого длинного названия в списке automation tools")
    public String findLongestAutomationToolName() {
        String longestTool = "";
        for (WebElement tool : automationToolsList) {
            String toolText = tool.getText();
            if (toolText.length() > longestTool.length()) {
                longestTool = toolText;
            }
        }
        return longestTool;
    }

    @Step("Заполнение поля Message значением {message}")
    public FormFieldsPage fillMessage(String message) {
        messageField.sendKeys(message);
        return this;
    }

    @Step("Нажатие на кнопку submit")
    public FormFieldsPage clickSubmitButton() {
        new Actions(driver).moveToElement(submitButton).click().perform();
        return this;
    }

    @Step("Создание скриншота итогового вида формы")
    public FormFieldsPage makeSummaryScreenshot() throws IOException {
        Allure.addAttachment("Скриншот",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        return this;
    }
}

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class FormFieldsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "input[type='text'][id='name-input']")
    private WebElement nameField;

    @FindBy(xpath = "//p[@class='red_txt']")
    private WebElement nameRequiredWarning;

    @FindBy(css = "input[type=password]")
    private WebElement passwordField;

    @FindBy(css = "input[type='checkbox'][name='fav_drink']")
    private List<WebElement> favDrinkCheckboxes;

    @FindBy(css = "input[type='radio'][name='fav_color']")
    private List<WebElement> favColorsRadioButtons;

    @FindBy(id = "automation")
    private WebElement automationDropdown;

    @FindBy(css = "input[type='text'][id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//label[text()='Automation tools']/following-sibling::ul/li")
    private List<WebElement> automationToolsList;

    @FindBy(css = "textarea[id='message'")
    private WebElement messageField;

    @FindBy(css = "button[id='submit-btn'")
    private WebElement submitButton;

    public FormFieldsPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Заполнение поля Name значением {name}")
    public FormFieldsPage fillName(String name) {
        getWebElementAfterWait(nameField).sendKeys(name);
        return this;
    }

    @Step("Заполнение поля Password значением {password}")
    public FormFieldsPage fillPassword(String password) {
        getWebElementAfterWait(passwordField).sendKeys(password);
        return this;
    }

    @Step("Отметка чекбокса напитка {drink}")
    public FormFieldsPage selectFavDrink(String drink) {
        for (WebElement checkbox : favDrinkCheckboxes) {
            if (Objects.equals(checkbox.getAttribute("value"), drink)) {
                getWebElementAfterWait(checkbox).click();
            }
        }
        return this;
    }

    @Step("Отметка радиокнопки цвета {color}")
    public FormFieldsPage selectFavColor(String color) {
        for (WebElement checkbox : favColorsRadioButtons) {
            if (Objects.equals(checkbox.getAttribute("value"), color)) {
                getWebElementAfterWait(checkbox).click();
            }
        }
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
        getWebElementAfterWait(emailField).sendKeys(email);
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
            if (toolText.length() > longestTool.length())
                longestTool = toolText;
        }
        return longestTool;
    }

    @Step("Заполнение поля Message значением {message}")
    public FormFieldsPage fillMessage(String message) {
        getWebElementAfterWait(messageField).sendKeys(message);
        return this;
    }

    @Step("Нажатие на кнопку submit")
    public FormFieldsPage clickSubmitButton() {
        new Actions(driver).moveToElement(submitButton).click().perform();
        return this;
    }

    @Step("Скриншот формы перед отправкой")
    public FormFieldsPage makeFormScreenshot() throws IOException {
        Screenshot scr = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(500))
                .takeScreenshot(driver);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(scr.getImage(), "PNG", os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        Allure.addAttachment("Скриншот", is);
        return this;
    }

    @Step("Проверка видимости предупреждения о незаполненном поле имени")
    public boolean isDisplayedNameWarning() {
        return nameRequiredWarning.isDisplayed();
    }

    private WebElement getWebElementAfterWait(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

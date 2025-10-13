package com.maxkulygin.sdet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormFieldsPage {
    private WebDriver driver;

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

    public FormFieldsPage fillName(String name) {
        nameField.sendKeys(name);
        return this;
    }

    public FormFieldsPage fillPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public FormFieldsPage selectMilk() {
        milkCheckbox.click();
        return this;
    }

    public FormFieldsPage selectCoffee() {
        coffeeCheckbox.click();
        return this;
    }

    public FormFieldsPage selectYellow() {
        yellowCheckbox.click();
        return this;
    }

    public FormFieldsPage selectAutomationFirstElement() {
        Select select = new Select(automationDropdown);
        select.selectByIndex(1);
        return this;
    }

    public FormFieldsPage fillEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public int countAutomationTools() {
        return automationToolsList.size();
    }

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

    public FormFieldsPage fillMessage(String message) {
        messageField.sendKeys(message);
        return this;
    }


    public FormFieldsPage clickSubmitButton() {
        new Actions(driver).moveToElement(submitButton).click().perform();
        return this;
    }

}

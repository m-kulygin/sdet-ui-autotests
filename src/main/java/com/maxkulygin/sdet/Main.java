package com.maxkulygin.sdet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.google.com");
            String title = driver.getTitle();
            System.out.println("Page Title is: " + title);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
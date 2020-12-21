package com.valeopartnersautmation.TestCase;

import com.valeopartnersautmation.Constants.CommonVars;
import com.valeopartnersautmation.Reports.ReportClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseCase extends ReportClass {

    public static WebDriver driver;

    @BeforeTest
    public void initialize() {
        System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir") + "chromedriver");
        driver = new ChromeDriver();
        CommonVars constantVars = new CommonVars();
        driver.get(constantVars.url);
        driver.manage().window().maximize();
    }
}
package com.valeopartnersautmation.TestCase;

import com.valeopartnersautmation.Constants.CommonVars;
import com.valeopartnersautmation.Reports.ReportClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

//        headless
//        System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir") + "chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        // options.setExperimentalOption("useAutomationExtension", false);
//        options.addArguments("--headless");
//        options.addArguments("window-size=1200,600");
//        options.addArguments("--disable-extensions"); // disdemoabling extensions
//        options.addArguments("--disable-gpu"); // applicable to windows os only
//        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//        options.addArguments("--no-sandbox");
//        driver = new ChromeDriver(options);
//        CommonVars constantVars = new CommonVars();
//        driver.get(constantVars.url);
//        driver.manage().window().maximize();
    }
}
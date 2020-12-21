package com.valeopartnersautmation.Pages;

import com.aventstack.extentreports.ExtentTest;
import com.valeopartnersautmation.Actions.ActionClass;
import com.valeopartnersautmation.Actions.VerificationClass;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.valeopartnersautmation.Constants.CommonVars.*;

public class ValeoReport {
    WebDriver driver;
    ExtentTest extentTest;

    @FindBy(how = How.XPATH,
            using = "//input[@id=\"edit-name\"]")
    private WebElement username_field;

    @FindBy(how = How.XPATH,
            using = "//input[@id=\"edit-pass\"]")
    private WebElement password_field;

    @FindBy(how = How.XPATH,
            using = "//input[@id=\"edit-submit\"]")
    private WebElement login_button;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"block-valeo-classic-account-menu\"]/div[2]/ul/li[6]")
    private WebElement logout_text;

    public ValeoReport(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.extentTest = test;
        PageFactory.initElements(driver, this);
    }

    public void Login() throws InterruptedException, IOException {
        ActionClass actionClass = new ActionClass(this.driver,extentTest);
        Thread.sleep(2000);
        driver.get(url);
        actionClass.setValueinTextbox(username_field, uname);
        Thread.sleep(3000);
        actionClass.setValueinTextbox(password_field, pass);
        Thread.sleep(3000);
        actionClass.clickOnObject(login_button);
        Thread.sleep(5000);
        VerificationClass verificationClass = new VerificationClass(driver, extentTest);
        verificationClass.verifyTextPresent(logout_text, "Log out");
        actionClass.captureScreen("Login");
    }
}

package com.valeopartnersautmation.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionClass {
    public static WebDriver driver;
    public static ExtentTest test;
    public String screenshotPath;

    public ActionClass(WebDriver driver, ExtentTest test)
    {
        this.driver=driver;
        this.test=test;
    }

    public void clickOnObject(WebElement element)   {
        try {
            if(element.isDisplayed())
            {
                element.click();
                test.log(Status.INFO,"Sucessfully clicked on object");
                System.out.println("Sucessfully clicked on object");
                //element.getAttribute("name")
            }
            else
            {
                System.out.println("Unable to find object");
                test.log(Status.FAIL,"Unable to find object");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }

    public void setValueinTextbox( WebElement element, String value) {
        {
            try {
                if (element.isDisplayed()) {
                    element.clear();
                    element.sendKeys(value);
                    System.out.println("Succesfully entered '" + value + "' in object");
                    test.log(Status.PASS, "Succesfully entered '" + value + "' in object :");
                } else {
                    System.out.println("Unable to find object");
                    test.log(Status.FAIL, "Unable to find object");

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                test.log(Status.FAIL, e.getMessage());
            }
        }
    }

    public void CompareList(ArrayList<Integer> listNames, ArrayList<Integer> listNames1)   {
        try {
            if(listNames.equals(listNames1)==true)
            {
                test.log(Status.INFO,"Result Matched with DB");
                System.out.println("Result Matched with DB");

            }
            else
            {
                System.out.println("Result Doesn't match with DB");
                test.log(Status.FAIL,"Result Doesn't match with DB");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }

    public void CompareListandstring(String s, String s1)
    {
        try {
            if(s.equals(s1)==true)
            {
                test.log(Status.INFO, "View opened for valid record " + s + " And Match with View record for " + s1);
                System.out.println("View opened for valid record " + s + " And Match with View record for " + s1);

            }
            else
            {
                System.out.println("View record for " + s + " is not correct");
                test.log(Status.FAIL, "View record for " + s + " is not correct");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }
    public void CompareStringList(ArrayList<String> listNames, ArrayList<String> listNames1)
    {
        try {
            if(listNames.equals(listNames1)==true)
            {
                test.log(Status.INFO,"Result Matched with DB");
                System.out.println("Result Matched with DB");

            }
            else
            {
                System.out.println("Result Doesn't match with DB");
                test.log(Status.FAIL,"Result Doesn't match with DB");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }
    public void CompareString(String string1, String string2)
    {
        try {
            if(string1.equals(string2)==true)
            {
                test.log(Status.PASS,"Number of displayed result matches with exported excel sheet");
                System.out.println("Number of displayed result matches with exported excel sheet");

            }
            else
            {
                System.out.println("Number of displayed result does not match with exported excel sheet");
                test.log(Status.FAIL,"Number of displayed result does not match with exported excel sheet");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }
    public void setValueinPortalField(WebElement element) {

        try{
            if(element.isDisplayed()){
                element.click();
                element.sendKeys("Elance");
                element.sendKeys(Keys.ENTER);

                element.click();
                element.sendKeys("Freelancer");
                element.sendKeys(Keys.ENTER);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateValueinTextbox( WebElement element, String value)    {
        try {
            if(element.isDisplayed())
            {
                element.click();
                element.clear();
                element.sendKeys(value);
                System.out.println("Succesfully entered '"+value+"' in object");
                test.log(Status.PASS,"Succesfully entered '"+value+"' in object :");
            }
            else
            {
                System.out.println("Unable to find object");
                test.log(Status.FAIL,"Unable to find object");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }

    public void setValueinTextbox_update( WebElement element, String value)  {
        try {
            if(element.isDisplayed())
            {
                element.click();
                element.clear();
                element.sendKeys(value);
                System.out.println("Succesfully entered '"+value+"' in object");
                test.log(Status.PASS,"Succesfully entered '"+value+"' in object :");
            }
            else
            {
                System.out.println("Unable to find object");
                test.log(Status.FAIL,"Unable to find object");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }

    public void entirePageScreenshot(String testcaseName) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
        Date date = new Date();
        String datetextName = dateFormat.format(date);
//        File destinationFile = new File(System.getProperty("user.dir") + "/test-output/screenshot/" +testcaseName + "_"+datetextName + ".png");
        String destinationFile = System.getProperty("user.dir") + "/test-output/screenshot/" +testcaseName + "_"+datetextName + ".png";
        System.out.println("destination file: "+destinationFile);
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        String[] relatvePath = destinationFile.toString().split("/test-output");
        System.out.println("relative path: "+relatvePath);
        screenshotPath = ".." + relatvePath[1];
        System.out.println("screeshotpath: "+screenshotPath);
//        try {
//            ImageIO.write(screenshot.getImage(),"PNG",new File(screenshotPath));
//            ImageIO.write(screenshot.getImage(),"PNG",new File(destinationFile));
//            test.log(Status.INFO, testcaseName, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            ImageIO.write(screenshot.getImage(),"PNG",new File(destinationFile));
            test.log(Status.INFO, testcaseName, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object screenCapture(String testcaseName) throws IOException {
    // report with snapshot
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
        Date date = new Date();
        String datetextName = dateFormat.format(date);
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(System.getProperty("user.dir") + "/test-output/screenshot/" +testcaseName + "_"+datetextName + ".png");
        FileUtils.copyFile(sourceFile,destinationFile);
        String[] relatvePath = destinationFile.toString().split("/test-output");
        screenshotPath = ".." + relatvePath[1];
        test.log(Status.INFO, testcaseName, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        return test;
    }
}


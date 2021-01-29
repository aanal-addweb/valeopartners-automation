package com.valeopartnersautmation.Pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.valeopartnersautmation.Actions.ActionClass;
import com.valeopartnersautmation.Actions.VerificationClass;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

//import static com.valeopartnersautmation.Actions.ActionClass.screenCapture;
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

    @FindBy(how = How.ID,
            using = "node/544096/title/en/full ")
    private WebElement WelcomeText;

    @FindBy(how = How.ID,
            using = "block-addcontent-2-menu")
    private WebElement AddNewRecode;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"block-valeo-classic-rateafasearches\"]/div[2]/ul/li[2]/ul/li[3]/a")
    private WebElement RatesbyFirmDetail;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"block-valeo-classic-page-title\"]/div[2]/h1")
    private WebElement RatesbyFirmDetailPageTitle;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_rate_firm_target_id_verf_chosen\"]/ul/li/input")
    private WebElement FirmField;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_rate_firm_target_id_verf_chosen\"]/div/ul/li/em")
    private WebElement Optionselect;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"views-exposed-form-search-rates-by-firm-detail-search-rates-by-firm-detail\"]/div/div[10]/label")
    private WebElement Position;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_term_node_tid_depth_position_chosen\"]/div/ul/li[3]")
    private WebElement SelectPosition;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_filing_fee_dates_value_min_chosen\"]")
    private WebElement FromYear;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_filing_fee_dates_value_min_chosen\"]/div/ul/li")
    private WebElement FromYearSelect;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_filing_fee_dates_value_min_chosen\"]/div/div/input")
    private WebElement Searchbox;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_filing_fee_dates_value_max_chosen\"]")
    private WebElement Toyear;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_filing_fee_dates_value_max_chosen\"]/div/div/input")
    private WebElement ToyearSearch;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit_field_vp_filing_fee_dates_value_max_chosen\"]/div/ul/li/em")
    private WebElement Toyearselect;

    @FindBy(how = How.XPATH,
            using = " //*[@id=\"edit-submit-search-rates-by-firm-detail\"]")
    private WebElement SearchBtn;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"export-xls-link\"]/a")
    private WebElement ExportExcel;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"xlsModal\"]")
    private WebElement FrameModal;

    @FindBy(how = How.XPATH,
            using = "/html/body/div[6]/div[11]/div/button")
    private WebElement ClickOnAccept;


    public ValeoReport(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.extentTest = test;
        PageFactory.initElements(driver, this);
    }

    public void login() throws InterruptedException, IOException {
        ActionClass actionClass = new ActionClass(this.driver,extentTest);
        Thread.sleep(2000);
        driver.getCurrentUrl();
        actionClass.setValueinTextbox(username_field, uname);
        Thread.sleep(3000);
        actionClass.setValueinTextbox(password_field, pass);
        Thread.sleep(3000);
        actionClass.clickOnObject(login_button);
        Thread.sleep(5000);
        VerificationClass verificationClass = new VerificationClass(driver, extentTest);
        verificationClass.verifyTextPresent(logout_text, "Log out");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.head.appendChild(document.createElement(\"style\")).innerHTML = \"#toolbar-administration {display: none !important; }\"");
        Thread.sleep(2000);
        actionClass.screenCapture("Login_Page_SS");
    }

    public void checkGraph(String graphURL) throws InterruptedException, IOException {
        ActionClass actionClass = new ActionClass(this.driver, extentTest);
        Thread.sleep(2000);
        driver.get(graphURL);
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.head.appendChild(document.createElement(\"style\")).innerHTML = \"#toolbar-administration {display: none !important; }\"");
        String  contains = driver.findElement(By.xpath("//*[@id=\"container1\"]")).getText();
        if (contains.contains("No results found. Need help with a search? Please contact Valeo Help Desk at "))
        {
            extentTest.log(Status.FAIL, "Graph is not displayed for URL: "+graphURL);
            System.out.println("Graph is not displayed");
            actionClass.screenCapture("Graph_Displayed");
            actionClass.entirePageScreenshot("Graph_Displayed_Full_SS");
        } else {
            extentTest.log(Status.PASS, "Graph is displayed for URL: "+graphURL);
            System.out.println("Graph is displayed");
            Thread.sleep(2000);
            actionClass.screenCapture("Graph_Not_Displayed");
            actionClass.entirePageScreenshot("Graph_Not_Displayed_Full_SS");
        }
    }

    public void getReportData(String Firm, String rate_year, String rate_selection, String position, String graphURL) throws InterruptedException, IOException, AWTException {
        //Report
        ActionClass actionClass = new ActionClass(this.driver, extentTest);
        Thread.sleep(2000);
        driver.get("https://dev.reports.valeopartners.com/rates/report");
        Thread.sleep(3000);
        actionClass.setValueinTextbox(this.FirmField,Firm);
        actionClass.clickOnObject(this.Optionselect);
        Thread.sleep(2000);
        actionClass.clickOnObject(this.Position);
        Thread.sleep(2000);
        actionClass.clickOnObject(this.SelectPosition);
        Thread.sleep(2000);
        System.out.println("selectposition");
        JavascriptExecutor jsetaskscore = (JavascriptExecutor) driver;
        jsetaskscore.executeScript("scrollBy(0,350)");
        actionClass.clickOnObject(this.FromYear);
        actionClass.setValueinTextbox(this.Searchbox,rate_year);
        actionClass.clickOnObject(this.FromYearSelect);
        System.out.println("selectposition1");
        Thread.sleep(2000);
        actionClass.setValueinTextbox(this.ToyearSearch,rate_year);
        actionClass.clickOnObject(this.Toyearselect);
        System.out.println("selectposition");
        actionClass.clickOnObject(this.SearchBtn);
        Thread.sleep(3000);
//        Robot robot = new Robot();
//        System.out.println("About to zoom out");
//        for (int i = 0; i < 4; i++) {
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_SUBTRACT);
//            robot.keyRelease(KeyEvent.VK_SUBTRACT);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//        }
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.head.appendChild(document.createElement(\"style\")).innerHTML = \"#toolbar-administration {display: none !important; }\"");
        Thread.sleep(2000);
        actionClass.screenCapture("Report_Page_SS");
        actionClass.entirePageScreenshot("Report_Page_Full_SS");
//        System.out.println("About to zoom in");
//        for (int i = 0; i < 4; i++) {
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_ADD);
//            robot.keyRelease(KeyEvent.VK_ADD);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//        }
        Thread.sleep(5000);

        POJO pojo = new POJO();
        String graduation_year = driver.findElement(By.xpath("//*[@id=\"block-valeo-classic-content\"]/div/div/div/div[4]/table/tbody/tr[1]/td[12]")).getText();
        graduation_year.trim();
        if(graduation_year.isEmpty()){
            String rate_selection1 = driver.findElement(By.xpath("//*[@id=\"block-valeo-classic-content\"]/div/div/div/div[4]/table/tbody/tr[1]/td[2]")).getText();
            System.out.println(rate_selection1);
            pojo.setRate_selection(rate_selection1);
            pojo.setPosition(position);
        }
        else {
            int year= Integer.parseInt(rate_year) - Integer.parseInt(graduation_year) + 1;
            if(year>=25){
                pojo.setPosition(position);
            }
            else {
                pojo.setPosition("Partner");
            }
        }
        String actual_rate1 = driver.findElement(By.xpath("//*[@id=\"block-valeo-classic-content\"]/div/div/div/div[4]/table/tbody/tr[1]/td[16]")).getText();
        System.out.println(actual_rate1);
        pojo.setRate(actual_rate1);
        String report_rate_year = driver.findElement(By.xpath("//*[@id=\"block-valeo-classic-content\"]/div/div/div/div[4]/table/tbody/tr[1]/td[19]")).getText();
        System.out.println(report_rate_year);
        pojo.setReportrateyear(report_rate_year);

//      Graph
        driver.get(graphURL);
        Thread.sleep(3000);
        Boolean isGraph = driver.findElement(By.xpath("//*[@id=\"block-visualchartdisplay\"]/div[2]/div")).isDisplayed();
        if (isGraph = true) {
            extentTest.log(Status.PASS, "Graph is displayed");
            System.out.println("Graph is displayed");
            String rate_selection2 = driver.findElement(By.xpath("//*[@id=\"highcharts-data-table\"]/tbody/tr/td[1]")).getText();
            System.out.println(rate_selection2);

            if(pojo.getRate_selection().contains(rate_selection)  && rate_selection2.contains(rate_selection)){
                System.out.println("Rates selection are compared and are correct");
                extentTest.log(Status.PASS, "Rates selection are compared and are correct");
            }
            else{
                System.out.println("Rates selection are compared and are not correct");
                extentTest.log(Status.FAIL, "Rates selection are compared and are not correct");
            }

            List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"highcharts-data-table\"]/thead/tr/th"));
            int recordSize = list.size();

            //Graph value check comparing with the Listing page
            for (int i = 2; i < recordSize; i++) {
                String head_name = driver.findElement(By.xpath("//*[@id=\"highcharts-data-table\"]/thead/tr/th[" + i + "]")).getText();
                System.out.println("Headname:" + head_name);
                System.out.println("pojo get postion:" + pojo.getPosition());

                if (head_name.equals(pojo.getPosition())) {
                    String actual_rate2 = driver.findElement(By.xpath("//*[@id=\"highcharts-data-table\"]/tbody/tr/td[" + i + "]")).getText();
                    System.out.println(actual_rate2);
                    String removeChars = actual_rate2;
                    String removeCharss = removeChars.replace(",", "");
                    if (pojo.getRate().contains(removeCharss)) {
                        System.out.println("Rates are compared and are correct");
                        extentTest.log(Status.PASS, "Rates are compared and are correct");
                    } else {
                        System.out.println("Rates are compared and are not correct");
                        extentTest.log(Status.FAIL, "Rates are compared and are not correct");
                    }
                    break;
                }
            }
            js.executeScript("document.head.appendChild(document.createElement(\"style\")).innerHTML = \"#toolbar-administration {display: none !important; }\"");
            actionClass.screenCapture("Graph_Page_SS");
            actionClass.entirePageScreenshot("Graph_Page_Full_SS");
        }else {
            extentTest.log(Status.FAIL, "Graph is not displayed");
            System.out.println("Graph not displayed");
            Thread.sleep(2000);
            js.executeScript("document.head.appendChild(document.createElement(\"style\")).innerHTML = \"#toolbar-administration {display: none !important; }\"");
            actionClass.screenCapture("Graph_Page_SS_1");
            actionClass.entirePageScreenshot("Graph_Page_Full_SS_1");
        }
    }

    public File matchExcelData(String Firm, String rate_year, String rate_selection, String position, String graphURL, String dirPath, String sheetName) throws InterruptedException, IOException {
        ActionClass actionClass = new ActionClass(this.driver, extentTest);
        Thread.sleep(2000);
        driver.get("https://dev.reports.valeopartners.com/rates/report");
        Thread.sleep(3000);
        actionClass.setValueinTextbox(this.FirmField,Firm);
        actionClass.clickOnObject(this.Optionselect);
        Thread.sleep(2000);
        actionClass.clickOnObject(this.Position);
        Thread.sleep(2000);
        actionClass.clickOnObject(this.SelectPosition);
        Thread.sleep(2000);
        System.out.println("selectposition");
        JavascriptExecutor jsetaskscore = (JavascriptExecutor) driver;
        jsetaskscore.executeScript("scrollBy(0,350)");
        actionClass.clickOnObject(this.FromYear);
        actionClass.setValueinTextbox(this.Searchbox,rate_year);
        actionClass.clickOnObject(this.FromYearSelect);
        System.out.println("selectposition1");
        Thread.sleep(2000);
        actionClass.setValueinTextbox(this.ToyearSearch,rate_year);
        actionClass.clickOnObject(this.Toyearselect);
        System.out.println("selectposition");
        actionClass.clickOnObject(this.SearchBtn);
        Thread.sleep(3000);
        actionClass.screenCapture("Result_SS");
        //get number of results
        String sentence = driver.findElement(By.xpath("//*[@id=\"block-valeo-classic-content\"]/div/div/div/div[2]")).getText();
        String[] sentence2 = sentence.split(" ");
        String result1= sentence2[5].trim();
        System.out.println(result1);

//      export excel and get number of rows
        actionClass.clickOnObject(ExportExcel);
        Thread.sleep(3000);
        driver.switchTo().activeElement();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div")).click();
        Thread.sleep(3000);
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }
        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        XSSFRow row = null;
        XSSFCell cell = null;
        System.out.println(lastModifiedFile);
        fis = new FileInputStream(lastModifiedFile);
        workbook = new  XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Valeo Reports");
        int rowCount = sheet.getLastRowNum();
        String result2 =String.valueOf(rowCount);
        System.out.println(result2);
        actionClass.CompareString(result1, result2);//Compare Number of displayed result with exported excel sheet
        return lastModifiedFile;
    }
}
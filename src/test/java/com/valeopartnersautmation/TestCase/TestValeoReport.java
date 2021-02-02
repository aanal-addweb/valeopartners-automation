package com.valeopartnersautmation.TestCase;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.valeopartnersautmation.Pages.ValeoReport;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class TestValeoReport extends BaseCase{
    @Test(priority = 1)
    public void Adminlogin() throws IOException, InterruptedException {
        logger = extent.createTest("Check if admin is logged in");
        ValeoReport valeoReport = new ValeoReport(driver, logger);
        valeoReport.login();
    }
    @Test(priority = 2)
    public void graphCheck() throws IOException, InterruptedException {
        logger = extent.createTest("Check if the graph is present on the Graph page");
        ValeoReport valeoReport = new ValeoReport(driver, logger);
//        valeoReport.checkGraph("https://dev.reports.valeopartners.com/visual/test-report-automation");
        valeoReport.checkGraph("https://dev.reports.valeopartners.com/visual/test-report-automation-graph-not-displayed");
    }
    @Test(priority = 3)
    public void reportCompareData() throws IOException, InterruptedException, AWTException {
        logger = extent.createTest("Check if the graph values and report values are same or not");
        ValeoReport valeoReport = new ValeoReport(driver, logger);
        valeoReport.getReportData("Kirkland & Ellis LLP", "2020", "High", "Senior Partner", "https://dev.reports.valeopartners.com/visual/test-report-automation");
    }
    @Test(priority = 4)
    public void matchDataofExcel() throws InterruptedException, IOException {
        logger = extent.createTest("Match the number of result in report with the Excel sheet");
        ValeoReport valeoReport = new ValeoReport(driver, logger);
        valeoReport.matchExcelData("Kirkland & Ellis LLP", "2020", "High", "Senior Partner", "https://dev.reports.valeopartners.com/visual/test-report-automation", System.getProperty("user.dir"), "Valeo Reports");
    }
}
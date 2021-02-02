package com.valeopartnersautmation.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.sql.SQLException;

public class ReportClass {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeSuite
    public void initReport() throws SQLException
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Reports/Valeo_ScriptExecution_Report.html");
        extent = new ExtentReports ();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Valeo");
        extent.setSystemInfo("Environment", "Valeo__Automation__Reports");
        extent.setSystemInfo("User Name", "Aanal");
        htmlReporter.config().setDocumentTitle("Valeo Test_cases");
        htmlReporter.config().setReportName("Valeo Test_Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    @AfterSuite
    public void tearDown() throws IOException {
        extent.flush();
    }
}


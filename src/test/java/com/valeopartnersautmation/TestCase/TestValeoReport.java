package com.valeopartnersautmation.TestCase;

import com.valeopartnersautmation.Pages.ValeoReport;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestValeoReport extends BaseCase{
    @Test(priority = 1)
    public void Adminlogin() throws IOException, InterruptedException {
        logger = extent.createTest("Check if admin is logged in");
        ValeoReport valeoReport = new ValeoReport(driver, logger);
        valeoReport.Login();
    }
}

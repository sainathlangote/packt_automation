package com.packt_automation.utility;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListner extends BaseClass implements ITestListener, ISuiteListener {

    String reportPath;

    ExtentTest log;
    ExtentReports extentReporter;

    @Override
    public void onStart(ISuite suite) {
        System.out.println("This is onStart of ISuite from TestListners");
        LocalDateTime dateTime = LocalDateTime.now();
        String currentDateTime = dateTime.format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss_SSS"));
        reportPath = System.getProperty("user.dir") + "/reports/" + "report_" + currentDateTime;
        System.out.println("ReportPath is " + reportPath);
        File file = new File(reportPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String htmlReport = reportPath + "/AutomationReport.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(htmlReport);
        extentReporter = new ExtentReports();
        extentReporter.attachReporter(sparkReporter);

        extentReporter.setSystemInfo("user", "Rohan More");
        extentReporter.setSystemInfo("os", "windows");
        extentReporter.setSystemInfo("environment", "QA");
        String suiteName = suite.getName();
        System.out.println(suiteName);

    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("This is onFinish of ISuite from TestListners");
        extentReporter.flush();

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("This is onStart of ITestContext from TestListners");

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("This is onFinish of ITestContest from TestListners");


    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("This is onTestStart of ITestResult from TestListners");
        String methodName = result.getMethod().getMethodName();
        log = extentReporter.createTest(methodName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("This is onTestSuccess of ITestResult from TestListners");

        System.out.println("Test pass : " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case fail: " + result.getName());

        try {
            if (driver != null) {
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
                String screenshotName = result.getName() + "_failure.png";
                File destinationFile = new File(reportPath + "/screenshots/" + screenshotName);
                FileUtils.copyFile(sourceFile, destinationFile);
                System.out.println("Screenshot captured and saved at: " + destinationFile.getAbsolutePath());
            } else {
                System.err.println("WebDriver (driver) is null. Unable to capture screenshot.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }

        if (result.getThrowable() != null) {
            log.fail(result.getThrowable().getMessage());
        } else {
            System.err.println("No associated exception or throwable in the test result.");
        }
        String screenShotPath = reportPath + "/" + result.getMethod().getMethodName() + ".jpg";
        log.addScreenCaptureFromPath(screenShotPath, "Failed screenshot");


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("This is onTestSkipped of ITestResult from TestListners");


    }

}


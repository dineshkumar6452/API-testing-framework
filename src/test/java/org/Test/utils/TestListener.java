package org.Test.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestListener implements ITestListener {

    private static List<String> results = new ArrayList<>();

    @Override
    public void onTestSuccess(ITestResult result) {
        results.add("<tr><td>" + result.getMethod().getMethodName() + "</td><td>Pass</td></tr>");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        results.add("<tr><td>" + result.getMethod().getMethodName() + "</td><td>Fail</td></tr>");
    }

    @Override
    public void onFinish(ITestContext context) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test-results.html"))) {
            writer.write("<html><head><title>Test Results</title></head><body>");
            writer.write("<h1>Test Results</h1>");
            writer.write("<table border='1'><tr><th>Test Method</th><th>Status</th></tr>");

            for (String result : results) {
                writer.write(result);
            }

            writer.write("</table></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

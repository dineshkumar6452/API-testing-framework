package org.Test.Capability.AccountSettings;


import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EditYourProfileEmailPage implements Testable {

    List<String> Results = new ArrayList<String>();

    @Test
    public void intialSetupConfig() {
        //List<String> urls = ExcelUtils.FetchtheListfromExcelsheetByColumnName(TestCaseUtils.SHEET_1,"edit_your_profile_email_page");
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("edit_your_profile_email_page");
        String domain = RestUtils.UAT;
        TestCaseUtils.ExecuteTesting(urls, domain,this);
        //generateHtmlReport(Results);
    }
    public void Testing(Response response,String endpoint) {

        //-------16710---------------------------------------------------------
       TestCaseUtils.textAtrributes(response,"profile-current-password-text","Current password", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);

    }


    private void generateHtmlReport(List<String> results) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test-results.html"))) {
            writer.write("<html><head><title>Test Results</title></head><body>");
            writer.write("<h1>Test Results</h1>");
            writer.write("<table border='1'><tr><th>Key</th><th>Expected Value</th><th>Actual Value</th><th>Status</th></tr>");
            for (String result : results) {
                writer.write(result); // Assumes result already contains HTML formatted row
            }
            writer.write("</table></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




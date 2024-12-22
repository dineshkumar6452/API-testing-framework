package org.Test.Capability.Paperless;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class Enrolled implements Testable {

    @Test
    public void intialSetupConfig() {
        //List<String> urls = ExcelUtils.FetchtheListfromExcelsheetByColumnName(TestCaseUtils.SHEET_1,"enrolled");
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("enrolled");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain,this);
    }

    @Override
    public void Testing(Response response, String endpoint) {
        //-------17755---------------------------------------------------------
        TestCaseUtils.ctaAtrributes(response,"enrolled-cta-unenroll","Unenroll in paperless",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.ctaAtrributes(response,"enrolled-cta-terms","Enroll in paperless",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
    }
}

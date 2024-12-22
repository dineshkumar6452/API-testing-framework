package org.Test.Capability.Paperless;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class Unenrolled implements Testable {

    @Test
    public void intialSetupConfig() {
        //List<String> urls = ExcelUtils.get(TestCaseUtils.SHEET_1,"enrolled");
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("unenrolled");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain,this);
    }

    @Override
    public void Testing(Response response, String endpoint) {
        TestCaseUtils.ctaAtrributes(response,"not-enrolled-enroll","Enroll in paperless",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
    }
}

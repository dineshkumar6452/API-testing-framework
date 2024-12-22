package org.Test.Capability.AlertDialog;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class BrandSpecificBiometricDialog implements Testable {

    public static final String TEST_REPORT_HTML = "test-report.html";

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("brand_specific_biometric_dialog");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
        TestCaseUtils.generateReport(TestCaseUtils.testResultsModelList, TEST_REPORT_HTML);
    }
    @Override
    public void Testing(Response response, String endpoint) {
        //-------17755---------------------------------------------------------
        TestCaseUtils.ctaAtrributes(response, "biometric-alert-face-id", "Enable Face ID", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "biometric-alert-touch-id", "Enable Touch ID", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "biometric-alert-enable", "Enable biometric", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
    }
}

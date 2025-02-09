package org.Test.Capability.Payments;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class BillpaySourceAndDateScreen implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("billpay_source_and_date_screen");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }
    public void Testing(Response response, String endpoint) {
        TestCaseUtils.ctaAtrributes(response,"billpay-terms-and-condition-cta","Payment Authorization Terms",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
    }
}

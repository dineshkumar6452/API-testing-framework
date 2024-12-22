package org.Test.Capability.Payments;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class PaymentDueDatePage implements Testable {
    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS( "payment_due_date_page");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }


    @Override
    public void Testing(Response response, String endpoint) {
        TestCaseUtils.ctaAtrributes(response, "payment-due-date-sumbit-cta", "Submit", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "payment-due-date-cancel-cta", "Cancel", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
    }
}
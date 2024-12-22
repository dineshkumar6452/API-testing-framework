package org.Test.Capability.Payments;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;
public class BillpayPaymentActivityPage implements Testable {
    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("billpay_payment_activity_page");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }


    @Override
    public void Testing(Response response, String endpoint) {
        TestCaseUtils.textAtrributes(response, "billpay-scheduled-text", "Scheduled payments", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "billpay-past-tab-text", "Past payments", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
    }
}
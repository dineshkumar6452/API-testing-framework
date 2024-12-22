package org.Test.Capability.Payments;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class BillpayConfirmationPage implements Testable {
    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("billpay_confirmationPage");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain,this);
    }


    @Override
    public void Testing(Response response, String endpoint) {

        TestCaseUtils.ctaAtrributes(response,"billpay-confirmation-enroll-automatic-payment-cta","Enroll in automatic payments", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.ctaAtrributes(response,"billpay-confirmation-done-cta1","Done and leave confirmation page", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);


    }
}

package org.Test.Capability.Payments;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class BillpayAddPaymentSourceDialog implements Testable {
    @Test
    public void intialSetupConfig() {

        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("billpay_add_payment_source_dialog");

        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }


    @Override
    public void Testing(Response response, String endpoint) {
      TestCaseUtils.textAtrributes(response, "billpay-dialog-hint-bank-nickname", "Bank or Account Nickname", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
      TestCaseUtils.textAtrributes(response, "billpay-dialog-hint--routing-number", "Routing Number", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
      TestCaseUtils.textAtrributes(response, "billpay-dialog-hint-account-number", "Account Number", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
      TestCaseUtils.textAtrributes(response, "billpay-dialog-hint-account-number-confirm", "Confirm account number by re-entering it", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);

    }
}

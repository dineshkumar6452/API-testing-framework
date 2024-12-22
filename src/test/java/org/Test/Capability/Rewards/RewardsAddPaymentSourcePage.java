package org.Test.Capability.Rewards;


import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class RewardsAddPaymentSourcePage implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("rewards_add_payment_source_page");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }
    @Override
    public void Testing(Response response, String endpoint) {
        //-------17755---------------------------------------------------------
        TestCaseUtils.textAtrributes(response,"redeem-add-payment-desc","Routing and account numbers. You can find them on bank statement or at the bottom of your check .",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"redeem-hint-bankN-ncikname","Bank or account nickname",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"redeem-hint-account-number","Account Number",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"redeem-hint-routing-number","Routing number",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"redeem-hint-account-number-confirm","Confirm Account Number",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);






    }
}


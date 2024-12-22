package org.Test.Capability.CreditLimitIncrease;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class CreditLimitIncreaseAccountSetting implements Testable {


    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("credit_limit_increase_account_setting");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }
    @Override
    public void Testing(Response response, String endpoint) {
        TestCaseUtils.textAtrributes(response,"credit-limit-increase-edit-field","Total annual income",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
    }
}
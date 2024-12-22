package org.Test.Capability.Rewards;


import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class RedeemYourRewardDollarPage implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("redeem_your_reward_dollars_page");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }
    @Override
    public void Testing(Response response, String endpoint) {

        //TestCaseUtils.textAtrributes(response,"reward-direct-deposit-content","Direct Deposit  redeem your rewards as a direct deposit.",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        //TestCaseUtils.textAtrributes(response,"reward-direct-deposit-content","Choose how to spend your reward {{type}} in the catalog.",TestCaseUtils.PLAIN_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"reward-can-redeem-catalog-option-desc-text","Choose how to spend your reward {{type}} in the catalog.",TestCaseUtils.PLAIN_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"reward-can-redeem-catalog-option-desc-text","Rewards Catalog to redeem your rewards in the catalog.",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
       // TestCaseUtils.textAtrributes(response,"reward-statement-credit-content","Statement Credit  redeem your cash back for a statement credit.   Note: Statement credits don't count toward your minimum due.",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);

    }
}


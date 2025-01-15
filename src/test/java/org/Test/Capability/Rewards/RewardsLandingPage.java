package org.Test.Capability.Rewards;


import io.restassured.response.Response;
import org.Test.utils.*;
import org.testng.annotations.Test;

import java.util.List;

public class RewardsLandingPage implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("rewardLandingPage");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }
    @Override
    public void Testing(Response response, String endpoint) {
        //-------17755---------------------------------------------------------

        TestCaseUtils.textAtrributes(response,"rewards-brand-website-url","null",TestCaseUtils.PLAIN_TEXT,endpoint);

        TestCaseUtils.textAtrributes(response,"use-your-rewards-title","<p>Available rewards</p>\n",TestCaseUtils.HTTP_CONTENT_TYPE,endpoint);
        TestCaseUtils.textAtrributes(response,"rewards-card-description","Start shopping to earn rewards!",TestCaseUtils.PLAIN_TEXT,endpoint);


        TestCaseUtils.textAtrributes(response,"reward-terms-and-conditions-text","Rewards terms and conditions",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"program-details-text","Rewards and Benefits",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"rewards-faq-text","Rewards FAQs",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);

    }
}


package org.Test.Capability.PoliciesAndTerms;
import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;
import java.util.List;

public class BrandSpecificPoliciesAndTermsContent implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("brand_specific_policies_and_terms_content");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }

    @Override
    public void Testing(Response response, String endpoint) {
        //-------17755---------------------------------------------------------
        TestCaseUtils.textAtrributes(response, "policy-and-terms-rewards-heading-1", "Rewards Terms and Conditions", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "as-do-not-sell-or-share-info-text", "Do not sell or share my personal information website", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "policy-and-terms-rewards-heading-1", "Rewards Terms and Conditions", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "policy-and-terms-online-heading-1", "Online Privacy Policy", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "policy-and-terms-eula-heading-1", "End User License Agreement", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "policy-and-terms-financial-heading", "Financial Privacy Policy", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
    }
}

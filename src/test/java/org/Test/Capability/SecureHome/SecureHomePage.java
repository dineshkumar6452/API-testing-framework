package org.Test.Capability.SecureHome;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class SecureHomePage implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("secure_home_page");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain,this);
    }

    @Override
    public void Testing(Response response, String endpoint) {
//        //-------17755---------------------------------------------------------

//      //
//
//        TestCaseUtils.textAtrributes(response,"promotional-plan-expires-soon-days","30",TestCaseUtils.PLAIN_TEXT,endpoint);
//        TestCaseUtils.imageAttributesPath(response,"secure-home-promo-plan-icon-divider","/assets/images/body/sprinkles-graphic.png","_path",endpoint);
//        TestCaseUtils.imageAttributesPath(response,"secure-home-promo-plans-bg-image","/assets/images/body/background_divider_for_promos.png","_path",endpoint);
//        TestCaseUtils.imageAttributesPath(response,"secure-home-promo-plans-bg-image","/assets/images/body/background_divider_for_promos.png","_path",endpoint);

      //  TestCaseUtils.textAtrributes(response,"secure-home-current-reward-header","REWARDS",TestCaseUtils.PLAIN_TEXT,endpoint);

//        TestCaseUtils.ctaAtrributes(response,"auto-pay-source-submit-cta","Submit automatic payment selections",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
//        TestCaseUtils.textAtrributes(response,"auto-pay-source-html-text","<p>I understand and agree to the&nbsp;<a title=\"Agree to the Automatic Payments Agreement\" href=\"/setupAutomaticPayment.html\">Automatic Payments Agreement</a></p>\n",TestCaseUtils.HTTP_CONTENT_TYPE,endpoint);
//        TestCaseUtils.imageAttributesPath(response,"secure-home-promo-plan-icon-divider","/assets/images/body/sprinkles-graphic.png","_path",endpoint);
//        //TestCaseUtils.ctaAtrributes(response,"paperless-nag-secure-home-primary-button-cta","Enroll in paperless",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
//
//        TestCaseUtils.ctaAtrributes(response,"delete-auto-pay-cta-text","Delete automatic payments",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
//        TestCaseUtils.ctaAtrributes(response,"eeca-paperless-accept-terms-continue-cta","Accept new terms and Sign in",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
//

       // TestCaseUtils.textAtrributes(response,"secure-home-current-reward-header","REWARDS",TestCaseUtils.PLAIN_TEXT,endpoint);
        //TestCaseUtils.imageAttributesPath(response,"secure-home-promo-plan-icon-divider","/assets/images/body/sprinkles-graphic.png","_path",endpoint);
       //
       // TestCaseUtils.imageAttributesPath(response,"secure-home-promo-plans-expire-alarm","/assets/images/icon/alert-time-sensitive.png","_path",endpoint);
        //
       // TestCaseUtils.imageAttributesPath(response,"secure-home-promo-plans-expire-alarm","/assets/images/icon/alert-time-sensitive.png","_path",endpoint);
        //TestCaseUtils.imageAttributesPath(response,"secure-home-promo-plans-bg-image","/assets/images/body/background_divider_for_promos.png","_path",endpoint);
        //TestCaseUtils.imageAttributesPath(response,"secure-home-promo-plans-bg-image","/assets/images/body/background_divider_for_promos.png","_path",endpoint);



      //  TestCaseUtils.textAtrributes(response,"promotional-plan-title","Promotional Plans",TestCaseUtils.PLAIN_TEXT,endpoint);
       // TestCaseUtils.textAtrributes(response,"promotional-plan-description","Review details of your current promotional plans.",TestCaseUtils.PLAIN_TEXT,endpoint);

      //  TestCaseUtils.textAtrributes(response,"promotional-plan-expiration-date","Expiration",TestCaseUtils.PLAIN_TEXT,endpoint);
        //TestCaseUtils.textAtrributes(response,"promotional-plan-review-promo-plans-cta","Review promotional plan",TestCaseUtils.PLAIN_TEXT,endpoint);

        TestCaseUtils.imageAttributesPath(response,"secure-home-promo-plans-expire-alarm","/assets/images/icon/alert-time-sensitive.png","_path",endpoint);


    }




}



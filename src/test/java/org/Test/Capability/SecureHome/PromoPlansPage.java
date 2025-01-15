package org.Test.Capability.SecureHome;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class PromoPlansPage implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("promoPlanPage");
        String domain = RestUtils.PROD;
       // TestCaseUtils.writeListToFile(urls);
        TestCaseUtils.ExecuteTesting(urls, domain,this);
    }

    @Override
    public void Testing(Response response, String endpoint) {

        //-------16710---------------------------------------------------------
       // TestCaseUtils.textAtrributesNull(response,"promo-plan-make-payment-cta",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);

        //-------18004---------------------------------------------------------
//        TestCaseUtils.textAtrributes(response,"promotional-plan-original-purchase-amt","Original Purchase",TestCaseUtils.PLAIN_TEXT,endpoint);
//        TestCaseUtils.textAtrributes(response,"promotional-plan-purchase-date","Purchase Date",TestCaseUtils.PLAIN_TEXT,endpoint);
//        TestCaseUtils.textAtrributes(response,"promo-plan-expanded-accessibility-description","Learn more about the {{planDescription}} plan",TestCaseUtils.PLAIN_TEXT,endpoint);
//        TestCaseUtils.textAtrributesHTML(response,"promo-plan-learn-more-desc","Your plan will display as <b>{{planName}}</b> throughout the Bread Financial app. Please refer to the back of your statement in the Additional Information section for details.<br><br>Interest will be charged to your account from the purchase date if the promotional plan balance is not paid in full within the promotional period. Minimum payments are required for each credit plan.<br><br>Minimum payments are NOT guaranteed to pay the promotional purchase balance. You may have to make additional payments to avoid accrued interest charges. A promotional plan transaction fee may apply. Review your Credit Card Agreement for your terms.",TestCaseUtils.HTTP_CONTENT_TYPE,endpoint);
//        TestCaseUtils.textAtrributesHTML(response,"promo-plan-learn-more-low-apr-desc","Your plan will display as <b>{{planName}}</b> throughout the Bread Financial app. Please refer to the back of your statement in the Additional Information section for details.<br><br>Interest is charged from the purchase date at the rate listed in the “APR during plan” section above. Minimum payments are required for each credit plan.<br><br>Minimum payments are NOT guaranteed to pay the promotional purchase balance. You may have to make additional payments to avoid paying interest charges. A promotional plan transaction fee may apply. Review your Credit Card Agreement for your terms.",TestCaseUtils.PLAIN_TEXT,endpoint);
//        TestCaseUtils.textAtrributesHTML(response,"promo-plan-learn-more-wvi-desc","Your plan will display as <b>{{planName}}</b> throughout the Bread Financial app. Please refer to the back of your statement in the Additional Information section for details.<br><br>Interest will be charged to your account from the end of the promotional period on any remaining promotional plan balance. Minimum payments are required for each credit plan.<br><br>Minimum payments are NOT guaranteed to pay the promotional purchase balance. You may have to make additional payments to avoid paying interest charges. A promotional plan transaction fee may apply. Review your Credit Card Agreement for your terms.",TestCaseUtils.PLAIN_TEXT,endpoint);

//        TestCaseUtils.imageAttributesPath(response,"promo-plans-accrued-interest-alert-image","/assets/images/icon/icon_black_alert_general.png","_path",endpoint);
//        TestCaseUtils.textAtrributes(response,"promotional-plan-original-purchase-amt","Original Amount",TestCaseUtils.PLAIN_TEXT,endpoint);

        TestCaseUtils.textAtrributes(response,"promo-plans-expires-soon-dialog-title","Promotional Plan Expiring Soon",TestCaseUtils.PLAIN_TEXT,endpoint);

        TestCaseUtils.textAtrributes(response,"promo-plans-expiration-dialog","<p>You have a promotional plan expiring soon.</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>Promotional plan information is accurate as of your last billing statement balance. Please review your most recent <a href=\"/Statements.html\">statement</a> for detailed information.</p>\n",TestCaseUtils.HTTP_CONTENT_TYPE,endpoint);



    }


}



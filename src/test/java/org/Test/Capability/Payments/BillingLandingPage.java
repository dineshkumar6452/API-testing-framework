package org.Test.Capability.Payments;

import io.restassured.response.Response;
import org.Test.utils.*;
import org.testng.annotations.Test;

import java.util.List;

public class BillingLandingPage implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("BillingLandingPage");
        String domain = RestUtils.DEV;
        TestCaseUtils.ExecuteTesting(urls, domain,this);
    }


    @Override
    public void Testing(Response response, String endpoint) {


        //--------------------CCMW-17671------------------------
        //TestCaseUtils.textAtrributes(response,"save-on-interest-date-picker-accessibility","Date picker opens a dialog","accessibilityText",endpoint);

        //--------------------CCMW-17759------------------------
       // TestCaseUtils.textAtrributes(response,"payment-option-select-payment-list-accessibility","{{selectedItem}} out of {{listLength}}", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
      //  TestCaseUtils.textAtrributes(response,"payment-option-select-payment-group-accessibility","Select Payment Date RadioGroup List of {{value}} Radio buttons.", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
       // TestCaseUtils.textAtrributes(response,"date-picker-close-accessibility","Close date picker", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);

        //--------------------CCMW-17758------------------------
//      //  TestCaseUtils.ctaAtrributes(response,"payment-option-calculate-now","Calculate Now", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
//       // TestCaseUtils.ctaAtrributes(response,"payment-option-calculate-now","Calculate Now", TestCaseUtils.PLAIN_TEXT,endpoint);
//
//
//    //    --------------------CCMW-17940------------------------
//        TestCaseUtils.textAtrributes(response,"bill-pay-save-on-interest-calculate-text","Calculate to continue", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
//        TestCaseUtils.textAtrributes(response,"bill-pay-save-on-interest-text","Pay save on interest",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
//        TestCaseUtils.textAtrributes(response,"bill-pay-save-on-interest-calculate-text","Calculate",TestCaseUtils.PLAIN_TEXT,endpoint);
//
//        //--------------------CCMW-18180------------------------
//
//        TestCaseUtils.ctaAtrributes(response, "payment-amount-option-pay-cta", "Continue", TestCaseUtils.PLAIN_TEXT, endpoint);
//        TestCaseUtils.ctaAtrributes(response, "payment-info-cta", "Payment info", TestCaseUtils.PLAIN_TEXT, endpoint);
//        TestCaseUtils.ctaAtrributes(response, "payment-option-cancel", "Cancel", TestCaseUtils.PLAIN_TEXT, endpoint);
//
//
//
//
//        TestCaseUtils.ctaAtrributes(response,"payment-info-cta","learn more about payment options, review past payments, and manage your payment sources", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
//        TestCaseUtils.ctaAtrributes(response, "payment-amount-option-pay-cta", "Continue to make a payment", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
//        TestCaseUtils.ctaAtrributes(response, "payment-info-cta", "learn more about payment options, review past payments, and manage your payment sources", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
//        TestCaseUtils.ctaAtrributes(response, "payment-option-cancel", "Cancel save on interest calculation", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
//        TestCaseUtils.ctaAtrributes(response, "promotional_plan_details", "null", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
//
//


        /*TestCaseUtils.imageAtrributes(response, "billpay-landing-amount-option-bg-image", "null", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.imageAtrributes(response, "billpay-landing-clear-icon", "Select the x and enter at least $1 and enter an other amount of at least $1", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
       // TestCaseUtils.imageAtrributes(response, "bill-pay-landing-page-radio-error", "null", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.imageAtrributes(response, "bill-pay-landing-page-radio-none", "Unselected", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.imageAtrributes(response, "direct-deposit-radio-selected-icon", "Selected", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        //TestCaseUtils.imageAtrributes(response, "billpay-radio-red-error-image", "null", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.imageAtrributes(response, "arrow-icon-expanded", "Expanded", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.imageAtrributes(response, "arrow-icon-collapsed", "Collapsed", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.imageAtrributes(response, "save-on-interest-info-close-icon", "Close the dialog", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.imageAtrributes(response, "save-on-interest-info-icon", "Open tooltip", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.imageAtrributes(response, "payment-definitions-info-icon", "Open tooltip", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
*/

        // Tested - some are null.
        TestCaseUtils.ctaAtrributes(response, "promotional_plan_details", "Promotional plan details", TestCaseUtils.PLAIN_TEXT, endpoint);




       TestCaseUtils.textAtrributes(response,"save-on-interest-date-picker-accessibility","Date picker opens a dialog","accessibilityText",endpoint);
        TestCaseUtils.ctaAtrributes(response,"payment-option-calculate-now","Calculate Now", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
       TestCaseUtils.ctaAtrributes(response,"payment-option-calculate-now","Calculate Now", TestCaseUtils.PLAIN_TEXT,endpoint);


       // TestCaseUtils.textAtrributes(response,"payment-option-select-payment-list-accessibility","{{selectedItem}} out of {{listLength}}", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
       // TestCaseUtils.textAtrributes(response,"payment-option-select-payment-group-accessibility","Select Payment Date RadioGroup List of {{value}} Radio buttons.", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"date-picker-close-accessibility","Close date picker", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);



       //TestCaseUtils.ctaAtrributes(response,"payment-info-cta","learn more about payment options, review past payments, and manage your payment sources", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
       // TestCaseUtils.ctaAtrributes(response,"payment-info-cta","Payment info", TestCaseUtils.PLAIN_TEXT,endpoint);
    }
}

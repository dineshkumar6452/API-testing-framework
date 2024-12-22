package org.Test.Capability.AccountSettings;


import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class EditYourProfilePhoneNumbersPage implements Testable {


    @Test
    public void intialSetupConfig() {
       // List<String> urls = ExcelUtils.FetchtheListfromExcelsheetByColumnName(TestCaseUtils.SHEET_1,"edit_your_profile_phone_numbers_page");
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("edit_your_profile_phone_numbers_page");
        String domain = RestUtils.UAT;
        TestCaseUtils.ExecuteTesting(urls, domain,this);
    }


    @Override
    public void Testing(Response response, String endpoint) {
        //-------16710---------------------------------------------------------
        TestCaseUtils.textAtrributes(response,"edit-your-phone-num-mobile-text","Mobile phone number", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
       // TestCaseUtils.textAtrributes(response,"edit-your-phone-num-home-text","Home phone number", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        //TestCaseUtils.textAtrributes(response,"edit-your-phone-num-work-text","Work phone number", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        //TestCaseUtils.textAtrributes(response,"edit-your-phone-num-other-text","Other phone number", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);

    }
}





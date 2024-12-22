package org.Test.Capability.AccountSettings;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class EditYourProfileNamePage implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("edit_your_profile_name_page");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }
    @Override
    public void Testing(Response response, String endpoint) {
        //-------17755---------------------------------------------------------
        TestCaseUtils.textAtrributes(response,"profile-first-name","First name",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"profile-middle-initial-text","Middle initial",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"profile-last-name-text","Last name",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"profile-name-change-reason-text","Reason for name change",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"profile-name-select-suffix","Suffix",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
    }
}


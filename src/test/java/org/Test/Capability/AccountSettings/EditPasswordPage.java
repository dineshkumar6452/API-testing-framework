package org.Test.Capability.AccountSettings;
import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class EditPasswordPage implements Testable {


    @Test
    public void intialSetupConfig() {
        //List<String> urls = ExcelUtils.FetchtheListfromExcelsheetByColumnName(TestCaseUtils.SHEET_1,"edit_password_page");
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("edit_password_page");
        String domain = RestUtils.UAT;
        TestCaseUtils.ExecuteTesting(urls, domain,this);
    }


    public void Testing(Response response, String endpoint) {
        //-------17953---------------------------------------------------------
        TestCaseUtils.textAtrributes(response,"edit-password-new-password","New password", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"edit-password-verify-new-password","New password to verify", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
    }
}







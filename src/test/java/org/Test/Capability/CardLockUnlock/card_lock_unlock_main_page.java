package org.Test.Capability.CardLockUnlock;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class card_lock_unlock_main_page implements Testable {



    @Test
    public void intialSetupConfig() {
       //List<String> urls = ExcelUtils.FetchtheListfromExcelsheetByColumnName(TestCaseUtils.SHEET_1,"card_lock_unlock_main_page");
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("card_lock_unlock_main_page");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain,this);
    }


    @Override
    public void Testing(Response response, String endpoint) {
        //--------------------CCMW-18003------------------------
        //TestCaseUtils.textAtrributes(response,"lock-unlock-decline-transaction-history","Declined transaction history", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        //TestCaseUtils.textAtrributes(response,"lock-unlock-recurring-off-texte","Decline recurring charges while locked", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
       // TestCaseUtils.textAtrributes(response,"lock-unlock-recurring-on-text","Allow recurring charges while locked", TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"lock-unlock-decline-transaction-history","<p><a title=\"Declined transaction history\" href=\"/SmcCompose.html\">Declined transaction history</a></p>", TestCaseUtils.HTTP_CONTENT_TYPE,endpoint);
    }
}

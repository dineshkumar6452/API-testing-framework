package org.Test.Capability.TransactionAndStatement;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;


public class TransactionAndStatementMainPage implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("transaction_and_statement_main_page");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }
    @Override
    public void Testing(Response response, String endpoint) {
        //-------17755---------------------------------------------------------
        TestCaseUtils.textAtrributes(response,"transaction-page-toggle-text","Transactions",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"statement-page-toggle-text","Statements",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);

    }
}




package org.Test.Capability.TransactionAndStatement;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;
import java.util.List;


public class TransactionFilterPage  implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("transaction_and_statement");
        String domain = RestUtils.DEV;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }
    @Override
    public void Testing(Response response, String endpoint) {

        //------- TEXT ----------------
        TestCaseUtils.textAtrributes(response,"transaction-search-option-date-text","Filter by date",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"transaction-search-option-amount-text","Filter by amount",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"transaction-search-option-transaction-type-text","Filter by transaction type",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"year-to-date-text","Transactions year to date",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"transaction-search-option-date-text","Filter by date",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);

        // ---------CTA ----------------
        TestCaseUtils.ctaAtrributes(response,"transaction-show-cta","Show",TestCaseUtils.PLAIN_TEXT,endpoint);

        // ---------IMAGES------------------------
        TestCaseUtils.imageAttributesPath(response, "ytd-background-image", "/assets/images/content-images/ytd_gradient_image.png", "_path", endpoint);
    }
}

package org.Test.Capability.AccountSettings;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class helpFaqs implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("helpFaqs");
        String domain = RestUtils.UAT;
        TestCaseUtils.ExecuteTesting(urls, domain,this);
    }


    public void Testing(Response response, String endpoint) {
        //TestCaseUtils.validateFAQContentTitle(response,"APR & Fees","Why do I have only one promotional plan for multiple transactions?",endpoint);
        TestCaseUtils.validateFAQContentTitle(response,"APR & Fees","Why was I charged a promotional plan fee?",endpoint);
    }
}

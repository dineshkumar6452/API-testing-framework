package org.Test.Capability.SecureMessageCenter;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class SecureMessageCenterCompose implements Testable {


    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("secure_message_center_compose");
        String domain = RestUtils.PROD;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }
    @Override
    public void Testing(Response response, String endpoint) {
        //-------17755---------------------------------------------------------
        TestCaseUtils.imageAtrributes(response,"smc-compose-icon-question-mark","Learn more about acceptable file formats",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"smc-compose-select-subject","Subject for your secure message",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"smc-compose-send-message","Send message",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"smc-compose-select-file","Choose a file to attach",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);
        TestCaseUtils.ctaAtrributes(response,"smc-delete-attachment-dialog-cta","Remove attachment",TestCaseUtils.ACCESSIBILITY_TEXT,endpoint);

    }
}
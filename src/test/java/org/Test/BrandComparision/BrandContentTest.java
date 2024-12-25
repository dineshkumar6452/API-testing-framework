package org.Test.BrandComparision;

import io.restassured.response.Response;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;


public class BrandContentTest implements Testable {

    @Test
    public void intialSetupConfig() {
        TestCaseUtils.compareURLResponses( "saloncentric",RestUtils.UAT,"legendarypine",RestUtils.UAT, this);
    }
    @Override
    public void Testing(Response response, String endpoint) {}
}

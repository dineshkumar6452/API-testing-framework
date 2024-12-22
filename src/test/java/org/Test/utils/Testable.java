package org.Test.utils;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public interface Testable {
    void Testing(Response response, String endpoint);

    @Test
    void intialSetupConfig();
}


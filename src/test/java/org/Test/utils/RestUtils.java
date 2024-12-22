package org.Test.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class RestUtils {

    public static final String DEV = "dev";

    public static final String UAT = "uat";



    public static final String PROD = "";

    public static Response getResponse(String endpoint) {
        Response response = RestAssured
                .given()
                .when()
                .get(endpoint);
        return response;
    }

    public static Response getResponseWithDispatcherCacheCleared(String endpoint) {
        int randomValue = new Random().nextInt(10000);
        Response response = null;
        if (StringUtils.isNotBlank(endpoint)) {
            response = RestAssured.get(endpoint + "?" + randomValue);
        }
        return response;
    }


    public static String getEndpoint(String endpoint, String domain) {
        if ("dev".equalsIgnoreCase(domain)) {
            endpoint = endpoint.replace("breadmobileapp.breadfinancial.com", "dev-breadmobileapp.breadfinancial.com");
        } else if ("uat".equalsIgnoreCase(domain)) {
            endpoint = endpoint.replace("breadmobileapp.breadfinancial.com", "uat-breadmobileapp.breadfinancial.com");
        } else if ("prod".equalsIgnoreCase(domain)) {
            // Do nothing for prod; the endpoint remains the same
        }
        return endpoint;
    }
}

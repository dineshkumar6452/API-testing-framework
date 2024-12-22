package org.Test.Capability.ExperimentClass;

import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class APITesting {


    public static final String PLAIN_TEXT = "plainText";
    public static final String HTML = "htmlText.html";
    public static final String SEARCH_TEXT_KEY_IN_RESPONSE = "data.screenByPath.item.text.find { it.id == '";


    @Test
    void testAPI() {
        List<String> urls = ExcelUtils.FetchtheListfromExcelsheetByColumnName("Sheet1","URLS");
        urls.forEach(url ->{ Testing(url);});
    }


    void Testing(String endpoint) {
        // System.out.println("Testing  " + endpoint);
        Response response = RestUtils.getResponse(endpoint);
        //TestCaseUtils.SearchFAQwithTopicID(response,"promoPlans");
        //System.out.println("Test passed for endpoint: " + endpoint);
        TestCaseUtils.checkHelpFAQTopicIdNotInResponse(response, "hard", endpoint);
        TestCaseUtils.checkFaqApiQuestionPresentinTopicId(response, endpoint, "accountFaqs", "I need help reading my statement and account materials.", "<p>We’re happy to help you read your statement and other account materials. Please call Customer Care at {{clientCsPhone}}, TDD/TTY: {{bankPhoneTddTty}}.</p>\n");
    }




    private static void textAtrributes(Response response, String key, String ExpectedResponse,String Type) {
        Assert.assertEquals(response.jsonPath().getString(SEARCH_TEXT_KEY_IN_RESPONSE + key + "' }." + Type) , ExpectedResponse);
    }

    private static void imagesAttributes(Response response) {
        Assert.assertTrue(response.jsonPath().getList("data.screenByPath.item.images.imageId").contains("save-on-interest-info-icon"), "Image ID not found in response");
        Assert.assertEquals(response.jsonPath().getString("data.screenByPath.item.images.find { it.imageId == 'save-on-interest-info-icon' }.accessibilityText"), "Open tooltip");
        Assert.assertTrue(response.jsonPath().getList("data.screenByPath.item.images.imageId").contains("payment-definitions-info-icon"), "Image ID not found in response");
        Assert.assertEquals(response.jsonPath().getString("data.screenByPath.item.images.find { it.imageId == 'payment-definitions-info-icon' }.accessibilityText"), "Open tooltip");
    }

}
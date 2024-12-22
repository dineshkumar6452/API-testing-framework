package org.Test.Capability.ExperimentClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class APITest {


    public static final String PLAIN_TEXT = "plainText";
    public static final String HTML = "htmlText.html";

    @Test
    void testAPI() {

//        HashMap<String, String> apisList = new HashMap<>();
//        apisList.put("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/dailyadvantagesig/rewards/bread_cashback_benefits/bread_cashback_benefits;release=r3", "https://breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/dailyadvantagesig/rewards/bread_cashback_benefits/bread_cashback_benefits;release=r3");
//        apisList.put("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/advantage/accountSetting/card_alerts_update/card_alerts_update;release=r3?a=w", "https://qa-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/advantage/accountSetting/card_alerts_update/card_alerts_update;release=r3");
//
//        JsonArray jsonArray = new JsonArray();
//        apisList.forEach((link1, link2) -> {
//            String body1 = RestAssured.get(link1).getBody().asString();
//            ;
//            String body2 = RestAssured.get(link2).getBody().asString();
//            ;
//            Boolean check = StringUtils.equals(body1, body2);
//            JsonObject obj1 = new JsonObject();
//
//            obj1.addProperty("Orginal", link1);
//            obj1.addProperty("Changed", link2);
//            obj1.addProperty("Status", check);
//
//            jsonArray.add(obj1);
//        });
//        System.out.print(jsonArray);


  //      Testing("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/boscovs/payments/billpay_landing_page/billpay_landing_page;release=r3");

        List<String> urls = new ArrayList<>();
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/boscovs/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/academy/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/advantage/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/bhphoto/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/breadcashback/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/breadrewards/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/caesarsrewardsvisa/payments/billpay_landing_page/billpay_landing_page;release=r3");


        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/caesarsrewardsvisa-card/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/caesarsrewardsvisa-signature/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/dailyadvantagesig/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/greenbaymastercard/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/lanebryant/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/packersmastercard/payments/billpay_landing_page/billpay_landing_page;release=r3");

        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/packersworldmastercard/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/sephoracard/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/sephora/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/sephoravisacard/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/sephoravisasignature/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/torrid/payments/billpay_landing_page/billpay_landing_page;release=r3");

        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/traveladvantagesig/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/buckle/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/carters/payments/billpay_landing_page/billpay_landing_page;release=r3");
        urls.add("https://uat-breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/jjill/payments/billpay_landing_page/billpay_landing_page;release=r3");


        urls.forEach(url ->{
            Testing(url);
        });





    }


    private static void Testing(String endpoint) {

        System.out.println("Testing  " + endpoint);

        // Send a GET request to the endpoint
        Response response = RestAssured
                .given()
                .when()
                .get(endpoint);

        // Validate the response
        Assert.assertEquals(response.getStatusCode(), 200);
       // imagesAttributes(response);


       // textAtrributes(response, "payment-definitions-text", "Payment Definitions",PLAIN_TEXT);
       // textAtrributes(response, "payment-definitions-dialog-header", "Payment Definitions",PLAIN_TEXT);
        //textAtrributes(response, "payment-definitions-dialog-desc", "<p><strong>Minimum Balance</strong><br>Pay this amount by your due date to avoid late fees and keep your account in good standing. If you have a promo plan, you may need to pay more than the minimum payment.</p>\\n<p><strong>Statement Balance</strong><br>Your statement balance is timestamped and won’t change until your next billing cycle closes. It includes expenses and payments made to your account during your last billing cycle, including promo plan balances.</p>\\n<p><strong>Current Balance</strong><br>The current balance reflects the current total of all charges and payments to your account and is updated every time a transaction is posted to your account.</p>\\n<p><strong>Save on Interest</strong><br>This is a calculated amount designed to help you avoid future interest on purchases.</p>",HTML);
      //  textAtrributes(response,"bill-pay-save-on-interest-text","Save on Interest",PLAIN_TEXT);

        //CCMW-17671
        textAtrributes(response,"payment-option-select-payment-group-accessibility","Select Payment Date Radio Group of {{value}} Items","accessibilityText");
        textAtrributes(response,"save-on-interest-date-picker-accessibility","Date picker opens a dialog","accessibilityText");
        textAtrributes(response,"date-picker-close-accessibility","Close date picker dialog","accessibilityText");

        //


        System.out.println("Test passed for endpoint: " + endpoint);
    }

    private static void textAtrributes(Response response, String key, String ExpectedResponse,String Type) {
        String q = response.jsonPath().getString("data.screenByPath.item.text.find { it.id == '" + key + "' }." + Type);
        //Assert.assertEquals(q , ExpectedResponse);
        if (q.equals(ExpectedResponse)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed. Expected: " + ExpectedResponse + ", but got: " + q);
            // Optionally, you can throw an exception or handle the failure as needed
        }
    }

    private static void imagesAttributes(Response response) {
        Assert.assertTrue(response.jsonPath().getList("data.screenByPath.item.images.imageId").contains("save-on-interest-info-icon"), "Image ID not found in response");
        Assert.assertEquals(response.jsonPath().getString("data.screenByPath.item.images.find { it.imageId == 'save-on-interest-info-icon' }.accessibilityText"), "Open tooltip");
        Assert.assertTrue(response.jsonPath().getList("data.screenByPath.item.images.imageId").contains("payment-definitions-info-icon"), "Image ID not found in response");
        Assert.assertEquals(response.jsonPath().getString("data.screenByPath.item.images.find { it.imageId == 'payment-definitions-info-icon' }.accessibilityText"), "Open tooltip");
    }

}
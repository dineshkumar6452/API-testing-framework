package org.Test.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import org.TestResultsModel;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TestCaseUtils {

    public static final String ACCESSIBILITY_TEXT = "accessibilityText";
    public static final String PLAIN_TEXT = "plainText";
    public static final String SHEET_1 = "Sheet1";
    public static final String HTTP_CONTENT_TYPE = "html";
    public static final String FILE_NOT_FOUND = "File not found: ";
    public static final String ERROR_WRITING_HTML_FILE = "Error writing HTML file: ";
    public static final String HTML_REPORT_GENERATED_AT = "HTML report generated at: ";
    public static final String URLCOMPARISON_RESULTS_HTML = "URLComparisonResults.html";
    public static final String ERROR_PROCESSING_URLS = "Error processing URLs: ";
    public static final String FULL_STACK_TRACE = "Full Stack Trace: ";
    public static final String IDENTICAL = "Identical";
    public static final String NOT_IDENTICAL = "Not Identical";
    public static final String CONTENT_DAM = "/content/dam/[^/]+/[^/]+/[^/]+/[^/]+";
    public static final String NULL = "null";
    public static final String PATH = "_path";
    public static final String IMAGE_URL = "imageUrl";
    public static final String IMAGE_ID = "imageId";
    public static final String IMAGES = "images";
    public static final String ITEM = "item";
    public static final String SCREEN_BY_PATH = "screenByPath";
    public static final String DATA = "data";
    public static final String TEXT = "text";
    public static final String CTA = "cta";
    public static final String DROPDOWN = "dropdown";
    public static final String CATALOG = "catalog";
    public static final String CARD_PERKS = "cardPerks";
    public static final String MORE_DETAILS = "more_details";
    public static final String IN_PROGRESS = "In progress...";
    public static final String FAQ_TEST_FAILED_EXPECTED_CONTENT_TITLE = "FAQ Test failed. Expected contentTitle: ";
    public static final String BUT_GOT = ", but got: ";
    public static final String URL = ", URL: ";
    public static final String DOMAIN = ", Domain: ";
    public static final String BRAND = ", Brand: ";
    public static final String FAQ_TEST_PASSED_CONTENT_TITLE = "FAQ Test passed. contentTitle: ";
    public static final String ERROR_WRITING_TO_FILE = "Error writing to file: ";
    public static final String FILE_WRITTEN_SUCCESSFULLY = "File written successfully.";
    public static final String ERROR_PROCESSING_URL = "Error processing URL: ";
    public static final String DEV_BREADMOBILEAPP_BREADFINANCIAL_COM = "dev-breadmobileapp.breadfinancial.com";
    public static final String UAT_BREADMOBILEAPP_BREADFINANCIAL_COM = "uat-breadmobileapp.breadfinancial.com";
    public static final String UAT = "UAT";
    public static final String PROD = "PROD";
    public static final String DEV = "DEV";
    public static final String BRAND_NOT_FOUND = "Brand not found";
    public static final String BRAND_SEGMENT_NOT_FOUND_IN_URL = "Brand segment not found in URL";
    public static final String PATH_NOT_FOUND_IN_URL = "Path not found in URL";
    public static final String INVALID_URL = "Invalid URL";
    public static final String TEST_FAILED_KEY = "Test failed. Key: ";
    public static final String EXPECTED = ", Expected: ";
    public static final String TEST_PASSED_KEY = "Test passed. Key: ";
    public static final String CONTENT_DAM_BREADMOBILE_US_EN = "/content/dam/breadmobile/us/en/";
    public static final String TEST_REPORT_HTML = "test-report.html";
    public static final String TEST_PASSED = "Test Passed.";

    public static List<TestResultsModel>  testResultsModelList = new ArrayList<>();

    private static TestResultsModel testResultsModel = new TestResultsModel();
    static void SearchFAQwithTopicID(Response response, String topicID) {
        Assert.assertFalse(response.jsonPath().getList("data.faqscreenByPath.item.topicsContent.topicId").contains(topicID), "Topic ID not found in response");
    }

    public static void checkHelpFAQTopicIdNotInResponse(Response response, String topicID, String endpoint) {
        // Extract the list of topic IDs from the response
        List<String> topicIds = response.jsonPath().getList("data.faqscreenByPath.item.topicsContent.topicId");
        // Check if the list contains the specified topicID
        if (topicIds.contains(topicID)) {
            // If the topic ID is found, throw an exception
            System.out.println("URL " + endpoint + " Topic ID " + topicID + " found in response");
        } else {
            // If the topic ID is not found, print a success message (or do nothing)
            //System.out.println("Topic ID " + topicID + " not found in response");
        }
    }

    public static void checkFaqApiQuestionPresentinTopicId(Response response, String endpoint, String topicID, String questionTitle, String expectedAnswer) {

        // String topicID = "accountFaqs"; // Replace with the actual topicID
        //  String questionTitle = "What’s the latest I can make a payment online without getting charged a late fee?"; // Replace with the actual question


        String contentBody = response.jsonPath().getString(
                "data.faqscreenByPath.item.topicsContent.find { it -> it.topicId == '" + topicID + "' }" +
                        ".questionList.find { it -> it.contentTitle == '" + questionTitle + "' }.contentBody.html"
        );
        if (contentBody != null && StringUtils.equalsIgnoreCase(contentBody, expectedAnswer)) {
            // System.out.println("Topic ID " + topicID + " and question title " + questionTitle + " found in response");
        } else {
            System.out.println("Topic ID " + topicID + " and question title " + questionTitle + " not found in response");
        }


    }

    public static void textAtrributes(Response response, String key, String ExpectedResponse, String Type, String endpoint) {
        String Value = null;
        TestResultsModel result = new TestResultsModel();
        result.setKey(key);
        result.setApiEndpoint(endpoint);
        result.setBrand(fetchBrandName(endpoint));
        result.setDomain(fetchDomainName(endpoint));
        result.setExpected(ExpectedResponse);
        result.setTestName("Text");

        if (Type.equalsIgnoreCase(HTTP_CONTENT_TYPE)) {
            Value = response.jsonPath().getString("data.screenByPath.item.text.find { it.id == '" + key + "' }.htmlText.html");
        } else if (Type.equalsIgnoreCase(ACCESSIBILITY_TEXT) || Type.equalsIgnoreCase(PLAIN_TEXT)) {
            Value = response.jsonPath().getString("data.screenByPath.item.text.find { it.id == '" + key + "' }." + Type);
        } else if (Type.equalsIgnoreCase("FAQ")) {
            // Validate FAQ contentTitle
            Value = response.jsonPath().getString("data.screenByPath.item.faq.find { it.contentTitle == '" + ExpectedResponse + "' }.contentTitle");
            if (Value != null && Value.equals(ExpectedResponse)) {
                System.out.println(FAQ_TEST_PASSED_CONTENT_TITLE + ExpectedResponse + BRAND + fetchBrandName(endpoint) + DOMAIN + fetchDomainName(endpoint));
                result.setStatus(TEST_PASSED);
                result.setActual(Value);
                testResultsModelList.add(result);

            } else {
                System.out.println(FAQ_TEST_FAILED_EXPECTED_CONTENT_TITLE + ExpectedResponse + BUT_GOT + ExpectedResponse + URL + endpoint);
                result.setStatus("Test Failed.");
                result.setActual(Value);
                testResultsModelList.add(result);
            }
            return;
        } else {
            return;
        }

        if (ExpectedResponse.equals(NULL) && Value == null) {
            System.out.println(TEST_PASSED_KEY + key + ", Brand : " + fetchBrandName(endpoint) + DOMAIN + fetchDomainName(endpoint));
            result.setStatus(TEST_PASSED);
            result.setActual("NULL");
            testResultsModelList.add(result);
            return;
        }

        //Assert.assertEquals(q , ExpectedResponse);
        if (Value != null && Value.equals(ExpectedResponse)) {
            System.out.println(TEST_PASSED_KEY + key + ", Brand : " + fetchBrandName(endpoint) + DOMAIN + fetchDomainName(endpoint) + ", TYPE: " + Type);
            result.setStatus(TEST_PASSED);
            result.setActual(Value);
            //  System.out.println(endpoint);
        } else {
            System.out.println(TEST_FAILED_KEY + key + " Expected: " + ExpectedResponse + BUT_GOT + Value + URL + endpoint + ", TYPE: " + Type);
            result.setStatus("Test Failed.");
            result.setActual(Value);
            // System.out.println(endpoint);
            // Optionally, you can throw an exception or handle the failure as needed
        }
        testResultsModelList.add(result);
    }

    public static void textAtrributesHTML(Response response, String key, String ExpectedResponse, String Type, String endpoint) {
        String Value = response.jsonPath().getString("data.screenByPath.item.text.find { it.id == '" + key + "' }.htmlText.html");
        //Assert.assertEquals(q , ExpectedResponse);
        if (Value != null && Value.equals(ExpectedResponse)) {
            System.out.println(TEST_PASSED_KEY + key + ", Brand : " + fetchBrandName(endpoint) + DOMAIN + fetchDomainName(endpoint));
            // System.out.println(endpoint);
        } else {
            System.out.println(TEST_FAILED_KEY + key + " Expected: " + ExpectedResponse + BUT_GOT + Value + URL + endpoint);
            // Optionally, you can throw an exception or handle the failure as needed
        }
    }

    public static void textAtrributesNull(Response response, String key, String Type, String endpoint) {
        String Value = response.jsonPath().getString("data.screenByPath.item.text.find { it.id == '" + key + "' }." + Type);
        //Assert.assertEquals(q , ExpectedResponse);
        if (Value == null) {
            System.out.println(TEST_PASSED_KEY + key + ", Brand : " + fetchBrandName(endpoint) + DOMAIN + fetchDomainName(endpoint));
        } else {
            System.out.println(TEST_FAILED_KEY + key + " Expected: " + NULL + BUT_GOT + Value + URL + endpoint);
            // Optionally, you can throw an exception or handle the failure as needed
        }
    }

    public static void ctaAtrributes(Response response, String key, String ExpectedResponse, String Type, String endpoint) {
        String Value = response.jsonPath().getString("data.screenByPath.item.cta.find { it.id == '" + key + "' }." + Type);
        // Create a TestResultsModel instance for this test case
        TestResultsModel result = new TestResultsModel();
        result.setKey(key);
        result.setApiEndpoint(endpoint);
        result.setBrand(fetchBrandName(endpoint));
        result.setDomain(fetchDomainName(endpoint));
        result.setExpected(ExpectedResponse);
        result.setTestName(" CTA ");
        //Assert.assertEquals(q , ExpectedResponse);
        if (ExpectedResponse.equals(NULL) && Value == null) {
            System.out.println(TEST_PASSED_KEY + key + ", Brand : " + fetchBrandName(endpoint) + DOMAIN + fetchDomainName(endpoint));
            result.setStatus(TEST_PASSED);
            result.setActual("NULL");
            testResultsModelList.add(result);
            return;
        }
        if (Value != null && Value.equals(ExpectedResponse)) {
            System.out.println(TEST_PASSED_KEY + key + ", Brand : " + fetchBrandName(endpoint) + DOMAIN + fetchDomainName(endpoint));
            result.setStatus(TEST_PASSED);
            result.setActual(Value);
        } else {
            System.out.println(TEST_FAILED_KEY + key + " Expected: " + ExpectedResponse + BUT_GOT + Value + URL + endpoint);
            result.setStatus("Test Failed.");
            result.setActual(Value);
            // Optionally, you can throw an exception or handle the failure as needed
        }
        testResultsModelList.add(result);
    }

    public static void imageAtrributes(Response response, String key, String ExpectedResponse, String Type, String endpoint) {
        String Value = response.jsonPath().getString("data.screenByPath.item.images.find { it.imageId == '" + key + "' }." + Type);
        //Assert.assertEquals(q , ExpectedResponse);
        //if (Value != null && Value.equals(ExpectedResponse)) {
        if (ExpectedResponse.equals(NULL) && Value == null) {
            System.out.println(TEST_PASSED_KEY + key + ", Brand : " + fetchBrandName(endpoint) + DOMAIN + fetchDomainName(endpoint));
            return;
        }
        if (Value.equals(ExpectedResponse)) {
            System.out.println(TEST_PASSED_KEY + key + ", Brand : " + fetchBrandName(endpoint) + DOMAIN + fetchDomainName(endpoint));
            // System.out.println(endpoint);
        } else {
            System.out.println(TEST_FAILED_KEY + key + " Expected: " + ExpectedResponse + BUT_GOT + Value + URL + endpoint);

        }
    }

    public static void imageAttributesPath(Response response, String key, String expectedResponse, String type, String endpoint) {
        String value = null;
        String brandName = fetchBrandName(endpoint);
        String domainName = fetchDomainName(endpoint);
        value = response.jsonPath().getString("data.screenByPath.item.image.find { it.id == '" + key + "' }." + type);
        if (PATH.equals(type)) {
            value = response.jsonPath().getString("data.screenByPath.item.images.find { it.imageId == '" + key + "' }.imageUrl." + type);
            brandName = fetchBrandName(endpoint);
            expectedResponse = CONTENT_DAM_BREADMOBILE_US_EN + brandName + expectedResponse;
        }

        // Create a TestResultsModel object to store test details
        TestResultsModel result = new TestResultsModel();
        result.setTestName("Image");
        result.setKey(key);
        result.setBrand(brandName);
        result.setDomain(domainName);
        result.setExpected(expectedResponse);
        result.setActual(value);
        result.setApiEndpoint(endpoint);

        if (value != null && value.equals(expectedResponse)) {
            System.out.println(TEST_PASSED_KEY + key + BRAND + fetchBrandName(endpoint) + DOMAIN + fetchDomainName(endpoint));
            result.setStatus(TEST_PASSED);
            // System.out.println(endpoint);
        } else {
            System.out.println(TEST_FAILED_KEY + key + EXPECTED + expectedResponse + BUT_GOT + value + URL + endpoint);
            result.setStatus("Test Failed.");
            // Optionally, throw an exception for test failure
            // throw new AssertionError("Test failed. Key: " + key + ", Expected: " + expectedResponse + ", but got: " + value);
        }
        testResultsModelList.add(result);
    }

    public static String fetchBrandName(String url) {
        if (url == null || url.isEmpty()) {
            return INVALID_URL;
        }

        String pathKey = ";path=";
        int pathStart = url.indexOf(pathKey);
        if (pathStart == -1) {
            return PATH_NOT_FOUND_IN_URL;
        }

        // Extract the path from the URL
        String path = url.substring(pathStart + pathKey.length());

        // Find the brand name segment (assuming it comes after "/us/en/")
        String targetSegment = "/us/en/";
        int brandStart = path.indexOf(targetSegment);
        if (brandStart == -1) {
            return BRAND_SEGMENT_NOT_FOUND_IN_URL;
        }

        // Extract the brand name following "/us/en/"
        String brandSegment = path.substring(brandStart + targetSegment.length());
        String[] segments = brandSegment.split("/");

        if (segments.length > 0) {
            return segments[0]; // Brand name is the first segment after "/us/en/"
        }
        return BRAND_NOT_FOUND;
    }

    public static String fetchDomainName(String endpoint) {
        if (endpoint.contains(DEV_BREADMOBILEAPP_BREADFINANCIAL_COM)) {
            return DEV;
        } else if (endpoint.contains(UAT_BREADMOBILEAPP_BREADFINANCIAL_COM)) {
            return UAT;
        } else {
            return PROD;
        }
    }

    public static void ExecuteTesting(List<String> urls, String domain, Testable testableInstance) {
        List<CompletableFuture<Void>> futures = urls.stream()
                .map(url -> processUrlAsync(url, domain, testableInstance))
                .collect(Collectors.toList());
        // Wait for all tasks to complete
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        TestCaseUtils.generateReport(TestCaseUtils.testResultsModelList, TestCaseUtils.TEST_REPORT_HTML);
    }

    public static CompletableFuture<Void> processUrlAsync(String url, String domain, Testable testableInstance) {
        return CompletableFuture.runAsync(() -> {
            try {
                if (StringUtils.isNotEmpty(url)) {
                    String endpoint = RestUtils.getEndpoint(url, domain);
                    Response response = RestUtils.getResponseWithDispatcherCacheCleared(endpoint);
                    testableInstance.Testing(response, endpoint);
                }
            } catch (Exception e) {
                System.out.println(ERROR_PROCESSING_URL + url + " - " + e.getMessage());
            }


        });
    }

    public static void writeListToFile(List<String> list) {
        String filePath = "output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : list) {
                writer.write(line);
                writer.newLine();  // Write each string on a new line
            }
            System.out.println(FILE_WRITTEN_SUCCESSFULLY);
        } catch (IOException e) {
            System.err.println(ERROR_WRITING_TO_FILE + e.getMessage());
        }
    }

    public static void validateFAQContentTitle(Response response, String questionTitle, String expectedContentTitle, String endpoint) {
        // Fetch the contentTitle from the JSON response
        String contentTitle = response.jsonPath().getString(
                "data.faqscreenByPath.item.topicsContent.find { it.topicId == 'aprFeesFaqs' }.questionList.find { it.contentTitle == 'Why was I charged a promotional plan fee?'}.contentTitle"
        );

        String brand = fetchBrandName(endpoint);
        String domain = fetchDomainName(endpoint);

        // Create a TestResultsModel object to store the result
        TestResultsModel testResult = new TestResultsModel();
        testResult.setTestName("FAQ Content Title Validation");
        testResult.setKey(questionTitle); // Set the question title as the key
        testResult.setExpected(expectedContentTitle); // Set expected content title
        testResult.setActual(contentTitle); // Set the actual fetched content title
        testResult.setBrand(brand); // Set the brand
        testResult.setDomain(domain); // Set the domain
        testResult.setApiEndpoint(endpoint); // Set the API endpoint



        if (contentTitle != null && contentTitle.equals(expectedContentTitle)) {
            System.out.println(FAQ_TEST_PASSED_CONTENT_TITLE + expectedContentTitle + BRAND + brand + DOMAIN + domain);
            testResult.setStatus(TEST_PASSED);
        } else {
            System.out.println(FAQ_TEST_FAILED_EXPECTED_CONTENT_TITLE + expectedContentTitle + BUT_GOT + contentTitle + URL + endpoint);
            testResult.setStatus("Test Failed.");
        }
        testResultsModelList.add(testResult);
    }





    private static boolean compareResponses(Response response1, Response response2) {
        if (response1 == null || response2 == null) {
            return false;
        }
        boolean value = (response1.getBody().asString().equalsIgnoreCase(response2.getBody().asString()));
        if (!value) {
            System.out.println(IN_PROGRESS);
            boolean images = false;
            HashMap<String, String> imagesReference = getImageReferences(response1);
            HashMap<String, String> imagesReference2 = getImageReferences(response2);
            // Safely check for equality
            if (imagesReference != null && imagesReference2 != null) {
                images = imagesReference.equals(imagesReference2);
            }
            boolean text = StringUtils.equals(validateItemData(response1, TEXT), validateItemData(response2, TEXT));
            boolean cta = StringUtils.equals(validateItemData(response1, CTA), validateItemData(response2, CTA));
            boolean dropdown = StringUtils.equals(validateItemData(response1, DROPDOWN), validateItemData(response2, DROPDOWN));
            boolean catalog = StringUtils.equals(validateItemData(response1, CATALOG), validateItemData(response2, CATALOG));
            boolean cardPerks = StringUtils.equals(validateItemData(response1, CARD_PERKS), validateItemData(response2, CARD_PERKS));
            boolean moreDetails = StringUtils.equals(validateItemData(response1, MORE_DETAILS), validateItemData(response2, MORE_DETAILS));
            value = images && text && cta && dropdown && catalog && cardPerks && moreDetails;
            return value;
        }
        return value;
    }

    private static String validateItemData(Response response1, String propertyName) {

        String response = response1.getBody().asString();
        String propertyValues = StringUtils.EMPTY;
        JsonObject json1 = JsonParser.parseString(response).getAsJsonObject();

        if (json1 != null) {
            JsonObject dataObject = json1.has(DATA) && !json1.get(DATA).isJsonNull()
                    ? json1.getAsJsonObject(DATA)
                    : null;

            if (dataObject != null) {
                JsonObject screenByPathObject = dataObject.has(SCREEN_BY_PATH) && !dataObject.get(SCREEN_BY_PATH).isJsonNull()
                        ? dataObject.getAsJsonObject(SCREEN_BY_PATH)
                        : null;

                if (screenByPathObject != null) {
                    JsonObject itemObject = screenByPathObject.has(ITEM) && !screenByPathObject.get(ITEM).isJsonNull()
                            ? screenByPathObject.getAsJsonObject(ITEM)
                            : null;

                    if (itemObject != null) {
                        propertyValues = itemObject.has(propertyName) && !itemObject.get(propertyName).isJsonNull()
                                ? itemObject.get(propertyName).getAsJsonArray().toString()
                                : null;
                    }
                }
            }
        }

        return propertyValues;
    }

    private static HashMap<String, String> getImageReferences(Response response1) {
        String response = response1.getBody().asString();
        JsonObject json1 = JsonParser.parseString(response).getAsJsonObject();
        JsonArray imagesArray = null;
        if (json1 != null) {
            JsonObject dataObject = json1.has(DATA) && !json1.get(DATA).isJsonNull()
                    ? json1.getAsJsonObject(DATA)
                    : null;

            if (dataObject != null) {
                JsonObject screenByPathObject = dataObject.has(SCREEN_BY_PATH) && !dataObject.get(SCREEN_BY_PATH).isJsonNull()
                        ? dataObject.getAsJsonObject(SCREEN_BY_PATH)
                        : null;

                if (screenByPathObject != null) {
                    JsonObject itemObject = screenByPathObject.has(ITEM) && !screenByPathObject.get(ITEM).isJsonNull()
                            ? screenByPathObject.getAsJsonObject(ITEM)
                            : null;

                    if (itemObject != null) {
                        imagesArray = itemObject.has(IMAGES) && !itemObject.get(IMAGES).isJsonNull()
                                ? itemObject.getAsJsonArray(IMAGES)
                                : null;
                    }
                }
            }
        }

        if (imagesArray == null) {
            return null;
        }


        Stream<JsonElement> stream = StreamSupport.stream(imagesArray.spliterator(), false);
        HashMap<String, String> imagesReference = new HashMap<>();

        stream.map(JsonElement::getAsJsonObject)
                .forEach(imageObject -> {

                    String imageId = imageObject.has(IMAGE_ID) && !imageObject.get(IMAGE_ID).isJsonNull()
                            ? imageObject.get(IMAGE_ID).getAsString()
                            : "unknown";


                    JsonObject imageUrl = imageObject.has(IMAGE_URL) && !imageObject.get(IMAGE_URL).isJsonNull()
                            ? imageObject.getAsJsonObject(IMAGE_URL)
                            : null;

                    if (imageUrl != null && imageUrl.has(PATH) && !imageUrl.get(PATH).isJsonNull()) {
                        String path = imageUrl.get(PATH).getAsString();
                        imagesReference.put(imageId, path.replaceFirst(CONTENT_DAM, ""));
                    } else {
                        imagesReference.put(imageId, NULL); // Handle cases where "_path" is missing or null
                    }
                });

        return imagesReference;
    }


    public static void compareURLResponses(String BrandName1,  String domain1, String BrandName2, String domain2, Testable testableInstance) {

        List<String> urlList1 = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLSOn(BrandName1);
        List<String> urlList2 = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLSOn(BrandName2);

        if (urlList1.size() != urlList2.size()) {
            throw new IllegalArgumentException("The two URL lists must have the same number of URLs.");
        }

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        List<String[]> comparisonResults = new ArrayList<>();

        for (int i = 0; i < urlList1.size(); i++) {
            String url1 = urlList1.get(i);
            String url2 = urlList2.get(i);


            futures.add(CompletableFuture.runAsync(() -> {
                try {
                    String endpoint1 = RestUtils.getEndpoint(url1, domain1);
                    String endpoint2 = RestUtils.getEndpoint(url2, domain2);

                    Response response1 = RestUtils.getResponseWithDispatcherCacheCleared(endpoint1);
                    Response response2 = RestUtils.getResponseWithDispatcherCacheCleared(endpoint2);

                    boolean identical = compareResponses(response1, response2);
                    String status = identical ? IDENTICAL : NOT_IDENTICAL;

                    // Add to results
                    synchronized (comparisonResults) {
                        comparisonResults.add(new String[]{endpoint1, endpoint2, status});
                    }

                    // Testing logic (if needed)
                    testableInstance.Testing(response1, endpoint1);
                    testableInstance.Testing(response2, endpoint2);

                } catch (Exception e) {
                    System.out.println(ERROR_PROCESSING_URLS + e.getMessage() + url1 + url2);

                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    e.printStackTrace(pw);
                    String fullStackTrace = sw.toString();
                    System.out.println(FULL_STACK_TRACE + fullStackTrace);
                }
            }));
        }

        // Wait for all tasks to complete
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        // Generate HTML report
        generateHtmlReport(comparisonResults);
    }

    private static void generateHtmlReport(List<String[]> results) {
        StringBuilder htmlBuilder = new StringBuilder();
        int totalApis = results.size();
        int passedApis = 0;
        int failedApis = 0;

        for (String[] result : results) {
            if (result != null && result.length == 3) {
                String status = result[2];
                if ("Identical".equalsIgnoreCase(status)) {
                    passedApis++;
                } else if ("Not Identical".equalsIgnoreCase(status)) {
                    failedApis++;
                }
            }
        }

        htmlBuilder.append("<!DOCTYPE html><html><head><title>URL Comparison Results</title>")
                .append("<style>")
                .append("table {width: 60%; margin: auto; border-collapse: collapse;} ")
                .append("th, td {border: 1px solid #ccc; padding: 8px; text-align: left; word-wrap: break-word;} ")
                .append("th {background-color: #f4f4f4;} ")
                .append("th:first-child, td:first-child, th:nth-child(2), td:nth-child(2),th:nth-child(3), td:nth-child(3) {min-width: 50px; max-width: 400px;} ")
                .append("tr.not-identical {background-color: #f8d7da; color: #721c24;} ") // Red for "Not Identical"
                .append("</style>")
                .append("</head><body>")
                .append("<h1 style='text-align: left; margin-left: 20%;'>URL Comparison Results</h1>")
                .append("<p style='text-align: left; margin-left: 20%; font-style: italic;'>")
                .append(java.time.LocalDateTime.now()
                        .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .append("</p>")
                .append("<div style='margin: 20px 20%; font-size: 16px;'>")
                .append("<p>Total APIs Tested: ").append(totalApis)
                .append(", Passed: ").append(passedApis)
                .append(", Failed: ").append(failedApis).append("</p>")
                .append("</div>")
                .append("<table><thead><tr><th>#</th><th>URL 1</th><th>URL 2</th><th>Status</th></tr></thead><tbody>");

        int rowNumber = 1; // Initialize the row number counter

        for (String[] result : results) {
            if (result != null && result.length == 3) {
                String status = result[2] != null ? result[2] : "Unknown Status";
                String rowClass = status.equalsIgnoreCase("Not Identical") ? "not-identical" : "";

                htmlBuilder.append("<tr class='").append(rowClass).append("'>")
                        .append("<td>").append(rowNumber).append("</td>") // Add the series number
                        .append("<td><a href=\"").append(result[0] != null ? result[0] : "").append("\" target=\"_blank\">")
                        .append(result[0] != null ? result[0] : "").append("</a></td>")
                        .append("<td><a href=\"").append(result[1] != null ? result[1] : "").append("\" target=\"_blank\">")
                        .append(result[1] != null ? result[1] : "").append("</a></td>")
                        .append("<td>").append(status).append("</td>")
                        .append("</tr>");
                rowNumber++; // Increment the row number
            }
        }
        htmlBuilder.append("</tbody></table></body></html>");

        // Save HTML to target folder
        File targetFolder = new File("target");
        if (!targetFolder.exists()) {
            targetFolder.mkdir();
        }
        File htmlFile = new File(targetFolder, URLCOMPARISON_RESULTS_HTML);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFile))) {
            writer.write(htmlBuilder.toString());
            System.out.println(HTML_REPORT_GENERATED_AT + htmlFile.getAbsolutePath());
            openHtmlFile(htmlFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println(ERROR_WRITING_HTML_FILE + e.getMessage());
        }
    }

    private static void openHtmlFile(String htmlFilePath) {
        File htmlFile = new File(htmlFilePath);
        if (htmlFile.exists()) {
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(FILE_NOT_FOUND + htmlFilePath);
        }
    }

    public static void generateReport(List<TestResultsModel> testResults, String outputFilePath) {
        try (FileWriter writer = new FileWriter(outputFilePath)) {

            // Count total, passed, and failed test cases
            int totalTests = testResults.size();
            int passedTests = (int) testResults.stream().filter(r -> TEST_PASSED.equalsIgnoreCase(r.getStatus())).count();
            int failedTests = totalTests - passedTests;

            writer.write("<html>");
            writer.write("<head>");
            writer.write("<title>Test Results Report</title>");
            writer.write("<style>");
            writer.write("table { width: 80%; margin: auto; border-collapse: collapse; }");
            writer.write("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
            writer.write("th { background-color: #d3d3d3; font-weight: bold; }"); // Header styling
            writer.write("tr.failed { background-color: #f8d7da; }"); // Failed test row styling
            writer.write("td:nth-child(7), td:nth-child(8) { max-width: 200px; overflow: hidden; text-overflow: ellipsis; word-wrap: break-word; white-space: normal; }"); // Limit width of Expected and Actual columns
            writer.write("</style>");
            writer.write("</head>");
            writer.write("<body>");
            writer.write("<h1 style='text-align: center;'>Test Results Report</h1>");
            // Summary Section
            writer.write("<div style='width: 80%; margin: auto; text-align: center; margin-bottom: 20px;'>");
            writer.write("<p><strong>Total Test Cases:</strong> " + totalTests + " | <strong>Passed:</strong> " + passedTests + "  | <strong>Failed:</strong> " + failedTests +"</p> ");
            writer.write("</div>");
            writer.write("<table>");
            writer.write("<tr>");
            writer.write("<th>#</th>"); // Series number
            writer.write("<th>Test Name</th>");
            writer.write("<th>Status</th>");
            writer.write("<th>Key</th>");
            writer.write("<th>Brand</th>");
            writer.write("<th>Domain</th>");
            writer.write("<th>Expected</th>");
            writer.write("<th>Actual</th>");
            writer.write("<th>API Endpoint</th>");
            writer.write("</tr>");

            int count = 1;
            for (TestResultsModel result : testResults) {
                String rowClass = "Test Failed.".equalsIgnoreCase(result.getStatus()) ? "class='failed'" : "";
                writer.write("<tr " + rowClass + ">");
                writer.write("<td>" + count++ + "</td>"); // Series number
                writer.write("<td>" + escapeHtml(result.getTestName()) + "</td>");
                writer.write("<td>" + escapeHtml(result.getStatus()) + "</td>");
                writer.write("<td>" + escapeHtml(result.getKey()) + "</td>");
                writer.write("<td>" + escapeHtml(result.getBrand()) + "</td>");
                writer.write("<td>" + escapeHtml(result.getDomain()) + "</td>");
                writer.write("<td>" + escapeHtml(result.getExpected()) + "</td>");
                writer.write("<td>" + escapeHtml(result.getActual()) + "</td>");
                writer.write("<td><a href='" + result.getApiEndpoint() + "' target='_blank'>Link</a></td>");
                writer.write("</tr>");
            }

            writer.write("</table>");
            writer.write("</body>");
            writer.write("</html>");

            System.out.println("HTML report generated successfully at: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        openHtmlFile(outputFilePath);
    }

    private static String escapeHtml(String text) {
        if (text == null) return "";
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
    }
}
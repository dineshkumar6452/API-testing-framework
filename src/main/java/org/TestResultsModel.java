package org;

public class TestResultsModel {
    private String testName;
    private String status;
    private String key;
    private String Brand;
    private String Domain;
    private String expected;
    private String actual;
    private String apiEndpoint;



    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public void setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    @Override
    public String toString() {
        return "TestResultsModel{" +
                "testName='" + testName + '\'' +
                ", status='" + status + '\'' +
                ", key='" + key + '\'' +
                ", Brand='" + Brand + '\'' +
                ", Domain='" + Domain + '\'' +
                ", expected='" + expected + '\'' +
                ", actual='" + actual + '\'' +
                ", apiEndpoint='" + apiEndpoint + '\'' +
                '}';
    }
}

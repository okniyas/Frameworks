package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ResponseSteps {

    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());

    }

    @And("check user id is not empty")
    public void checkUserIdIsNotEmpty() {
        String userId = RestAssuredUtils.getResponseFieldValue("id");
        Assert.assertTrue(!userId.isEmpty());
    }

    @And("store the user id into the {string}")
    public void storeTheUserIdIntoThe(String key) {
        ConfigReader.setConfigValue(key, RestAssuredUtils.getResponseFieldValue("id"));
    }
}

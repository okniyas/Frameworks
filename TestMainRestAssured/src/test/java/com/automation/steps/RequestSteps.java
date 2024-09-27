package com.automation.steps;

import com.automation.pojo.RegisterPojo;
import com.automation.pojo.UserPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestSteps {

    @Given("user wants to call the {string} endpoint")
    public void user_wants_to_call_the_endpoint(String endPoint) {
        if (endPoint.contains("@id")) {
            endPoint = endPoint.replace("@id", ConfigReader.getConfigValue("user.id"));
        }
        RestAssuredUtils.setEndPoint(endPoint);

    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        RestAssuredUtils.setHeader(key, value);

    }

    @Given("set request body from the file {string}")
    public void set_request_body_from_the_file(String fileName) {
        RestAssuredUtils.setBody(fileName);

    }

    @When("user performs post call")
    public void user_performs_post_call() {
        RestAssuredUtils.post();

    }

    @When("user performs get call")
    public void userPerformsGetCall() {
        RestAssuredUtils.get();
    }

    @When("user performs put call")
    public void userPerformsPutCall() {
        RestAssuredUtils.put();
    }

    @When("user performs delete call")
    public void userPerformsDeleteCall() {
        RestAssuredUtils.delete();
    }

    @And("set request body from the file {string} using pojo")
    public void setRequestBodyFromTheFileUsingPojo(String fileName) throws JsonProcessingException {
        String jsonFolderPath = ConfigReader.getConfigValue("json.folder.path");
        String jsonBody = RestAssuredUtils.getFileData(jsonFolderPath + fileName);

        ObjectMapper objectMapper = new ObjectMapper();
        UserPojo userPojo = objectMapper.readValue(jsonBody, UserPojo.class);
        RestAssuredUtils.setBodyUsingPojo(userPojo);

    }

    @And("set request body from the file {string} with username {string} and password {string}")
    public void setRequestBodyFromTheFileWithUsernameAndPassword(String fileName, String email, String password) throws JsonProcessingException {

        String jsonFolderPath = ConfigReader.getConfigValue("json.folder.path");
        String jsonBody = RestAssuredUtils.getFileData(jsonFolderPath + fileName);

        ObjectMapper objectMapper = new ObjectMapper();
        RegisterPojo registerPojo = objectMapper.readValue(jsonBody, RegisterPojo.class);

        registerPojo.setEmail(email);
        registerPojo.setPassword(password);
        RestAssuredUtils.setBodyUsingPojo(registerPojo);
    }
}

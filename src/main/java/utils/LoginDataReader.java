package utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import models.LoginDataModel;

import java.io.File;
import java.io.IOException;

public class LoginDataReader {
    public static LoginDataModel getLoginData(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File("src/test/resources/test_data/login_data.json"), LoginDataModel.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to locate the JSON login data", e);
        }
    }


}

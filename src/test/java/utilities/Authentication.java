package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepdefinitions.EndToEndStepDefs.email;


public class Authentication {

    public static String generateToken(){
        Map<String,String> credential = new HashMap<>();
if(email==null) {
    credential.put("email", ConfigReader.getProperty("contact_list_username"));
    credential.put("password", ConfigReader.getProperty("contact_list_password"));
} else {
    credential.put("email", email);
    credential.put("password", "Tester.14");
}
        Response response =given().
                                  body(credential).
                                  contentType(ContentType.JSON).
                                  post("https://thinking-tester-contact-list.herokuapp.com/users/login");
        return response.jsonPath().getString("token");
    }


}

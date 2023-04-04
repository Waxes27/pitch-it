package com.pitchIT.PitchUserService;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RegistrationTest {
    JSONObject jsonObject = new JSONObject();
    {
        jsonObject.put("businessName","Samsung");
        jsonObject.put("representativeFirstName", "John");
        jsonObject.put("representativeLastName","Doe");
        jsonObject.put("businessRole","CEO");
        jsonObject.put("email","a@gmail.com");
        jsonObject.put("password" ,"a");
    }


    @Test
    public void businessRegistrationShouldContainRoleAndLogin() throws UnirestException {


        HttpResponse<JsonNode> jsonResponse
                = Unirest.post("http://localhost:8081/register/business")
                .header("accept", "application/json")
                .header("content-type","application/json")
                .body(jsonObject)
                .asJson();

        System.out.println(jsonResponse.getBody());

        JSONObject jsonObjectResponse = jsonResponse.getBody().getObject();

        assertNotNull(jsonResponse.getBody());
        assertEquals("BUSINESS",jsonObjectResponse.get("businessRole"));
        assertEquals(200, jsonResponse.getStatus());

        jsonResponse
                = Unirest.post("http://localhost:8081/login")
                .header("accept", "application/json")
                .queryString("username","a@gmail.com")
                .queryString("password","a")
                .asJson();
        assertNotNull(jsonResponse.getBody());
        System.out.println(jsonObjectResponse);
        assertEquals(true,jsonObjectResponse.get("accountNonLocked"));
        assertEquals(200, jsonResponse.getStatus());
    }

    JSONObject investorJsonObject = new JSONObject();
    {
        jsonObject.put("firstName", "John");
        jsonObject.put("lastName","Doe");
        jsonObject.put("email","a@gmail.com");
        jsonObject.put("password" ,"a");
    }

    @Test
    public void investorRegistrationShouldContainRoleAndLogin() throws UnirestException {


        HttpResponse<JsonNode> jsonResponse
                = Unirest.post("http://localhost:8081/register/investor")
                .header("accept", "application/json")
                .header("content-type","application/json")
                .body(investorJsonObject)
                .asJson();

        System.out.println(jsonResponse.getBody());

        JSONObject jsonObjectResponse = jsonResponse.getBody().getObject();

        assertNotNull(jsonResponse.getBody());
//        assertEquals("INVESTOR",jsonObjectResponse.get("investorRole"));
        assertEquals(200, jsonResponse.getStatus());

        jsonResponse
                = Unirest.post("http://localhost:8081/login")
                .header("accept", "application/json")
                .queryString("username","a@gmail.com")
                .queryString("password","a")
                .asJson();
        assertNotNull(jsonResponse.getBody());
        System.out.println(jsonObjectResponse);
        assertEquals(true,jsonObjectResponse.get("accountNonLocked"));
        assertEquals(200, jsonResponse.getStatus());
    }


}

package testcoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class codingTest11 
{
    @Test
    public void Getapi()
    {
        // Step 1: Send the GET request
        Response response = RestAssured.get("https://api.coindesk.com/v1/bpi/currentprice.json");

        // Verify the response status code is 200
        Assert.assertEquals(response.statusCode(), 200, "Status code is not 200");

        // Print the response body for reference
        System.out.println("Response: " + response.getBody().asString());

        // Step 2: Verify the response contains 3 BPIs (USD, GBP, EUR)
        String usd = response.jsonPath().getString("bpi.USD.code");
        String gbp = response.jsonPath().getString("bpi.GBP.code");
        String eur = response.jsonPath().getString("bpi.EUR.code");

        Assert.assertEquals(usd, "USD", "USD BPI not found");
        Assert.assertEquals(gbp, "GBP", "GBP BPI not found");
        Assert.assertEquals(eur, "EUR", "EUR BPI not found");

        // Step 3: Verify the GBP ‘description’ equals ‘British Pound Sterling’
        String gbpDescription = response.jsonPath().getString("bpi.GBP.description");
        Assert.assertEquals(gbpDescription, "British Pound Sterling", "GBP description does not match");

        System.out.println("Test Passed");
    }
}

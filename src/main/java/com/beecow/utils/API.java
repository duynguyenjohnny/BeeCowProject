package com.beecow.utils;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

import com.jayway.restassured.response.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {

    //private final String USER_AGENT="Mozilla/5.0";
//    public String GetResponse() throws ClientProtocolException, IOException
//    {
//        StringBuffer result=new StringBuffer();
//        HttpClient client=new DefaultHttpClient();
//        String url="http://192.168.1.107:9080/api/account";
//        HttpGet request=new HttpGet(url);
//        //request.addHeader("User-Agent",USER_AGENT);
//        request.addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTQ4NTU2ODYwMn0.hVf1fAYIriyurnT2DCq8eCmhZlnUFJoK7RnZ5WIphA-tmRIxWFrsOX6M-G1gy2o5OzgDHsdXcjTa_9TJQV17bQ");
//        HttpResponse response=client.execute(request);
//        int responseCode=response.getStatusLine().getStatusCode();
//        System.out.println("Response Code: " + responseCode);
//        try{
//            if(responseCode==200||responseCode==201)
//
//            {
//                System.out.println("Get Response is Successfull");
//                BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//                String line="";
//                while((line=reader.readLine())!=null)
//                {
//                    result.append(line);
//                    System.out.println(result.toString());
//                }
//            }
//            return result.toString();
//
//        }
//        catch(Exception ex)
//        {
//            result.append("Get Response Failed");
//            return result.toString();
//        }
//
//    }
//private final String USER_AGENT="Mozilla/5.0";
//    // HTTP GET request
//    private void sendGet() throws Exception {
//
//        String url = "http://api.mediastep.ca:80/feedservices/api/feeds/trigger";
//
//        URL obj = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//        // optional default is GET
//        con.setRequestMethod("GET");
//
//        //add request header
//        con.setRequestProperty("User-Agent", USER_AGENT);
//        con.addRequestProperty("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTQ4OTgwNjE4Nn0.QlVYiwCyAAzjZhAjxYUhEDRNLR3L8YaCneyeAl64IPD7_-GxksT3g2tovvU6YTbWS9EbiXjRRXtHZN7GU5c4wg");
//        con.addRequestProperty("Content-Type","application/json");
//
//        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);
//
//        try{
//            if(responseCode==200||responseCode==201)
//
//            {
//                System.out.println("Get Successful");
//                //BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//               // String line="";
//               // while((line=reader.readLine())!=null)
//               // {
//               //     result.append(line);
//                //    System.out.println(result.toString());
//               // }
//            }
//            //return result.toString();
//
//        }
//        catch(Exception ex)
//        {
//            //result.append("Get Response Failed");
//            //return result.toString();
//            System.out.println("Get failed");
//        }
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        //print result
//        System.out.println(response.toString());
//
//    }
//
//    // HTTP POST request
//    // url example http://api.mediastep.ca:80/feedservices/api/feeds/trigger
//    //
//    private void sendPost(String url,String urlParameters) throws Exception {
//
//        //String url = "http://api.mediastep.ca:80/feedservices/api/feeds/trigger";
//        URL obj = new URL(url);
//        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//
//        //add reuqest header
//        con.setRequestMethod("POST");
//        con.setRequestProperty("User-Agent", USER_AGENT);
//        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//        con.addRequestProperty("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTQ4OTgwNjE4Nn0.QlVYiwCyAAzjZhAjxYUhEDRNLR3L8YaCneyeAl64IPD7_-GxksT3g2tovvU6YTbWS9EbiXjRRXtHZN7GU5c4wg");
//        con.addRequestProperty("Content-Type","application/json");
//
//       //String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
//
//        // Send post request
//        con.setDoOutput(true);
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.writeBytes(urlParameters);
//        wr.flush();
//        wr.close();
//
//        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'POST' request to URL : " + url);
//        System.out.println("Post parameters : " + urlParameters);
//        System.out.println("Response Code : " + responseCode);
//
//        try{
//            if(responseCode==200||responseCode==201)
//
//            {
//                System.out.println("Post Successful");
//                //BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//                // String line="";
//                // while((line=reader.readLine())!=null)
//                // {
//                //     result.append(line);
//                //    System.out.println(result.toString());
//                // }
//            }
//            //return result.toString();
//
//        }
//        catch(Exception ex)
//        {
//            //result.append("Get Response Failed");
//            //return result.toString();
//            System.out.println("Post failed");
//        }
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        //print result
//        System.out.println(response.toString());
//
//    }

    public void getRequest() throws JSONException {

        given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTQ4OTgwNjE4Nn0.QlVYiwCyAAzjZhAjxYUhEDRNLR3L8YaCneyeAl64IPD7_-GxksT3g2tovvU6YTbWS9EbiXjRRXtHZN7GU5c4wg");
        //make get request to fetch capital of norway
        //Response resp = get("http://restcountries.eu/rest/v1/name/norway");
        Response resp = when().get("http://api.mediastep.ca:80/feedservices/api/feeds?sort=createdDate%2Cdesc");
        try{
            if(resp.statusCode()==200||resp.statusCode()==201)

            {
                System.out.println("Get Successful");

            }
        }
        catch(Exception ex)
        {
            System.out.println("Get failed");
        }
        //Fetching response in JSON
        //JSONArray jsonResponse = new JSONArray(resp.asString());

        //Fetching value of capital parameter
        //String capital = jsonResponse.getJSONObject(0).getString("capital");

        //Asserting that capital of Norway is Oslo
        //Assert.assertEquals(capital, "Oslo");
    }

    public void poststatuspuretext() throws JSONException,InterruptedException {

        //Initializing Rest API's URL
        String APIUrl = "http://api.mediastep.ca:80/statusservices/api/status";

        //Initializing payload or API body
//        String APIBody = "{API Body}"; //e.g.- "{\"key1\":\"value1\",\"key2\":\"value2\"}"
        String APIBody = "{\"title\": \"string\",\"content\": \"test automation post API\",\"author\": {\"userId\": 0,\"displayName\": \"DuyAutomationPureText\",\"avatarUrl\": \"http://i.imgur.com/jU8nytI.png\"},\"mentionedUser\": [{\"userId\": 1111,\"displayName\": \"Long Nguyen5\",\"avatarUrl\": \"http://i.imgur.com/jU8nytI.png\",\"mentioned\": true}],\"mediaFiles\": [],\"linkPreview\": null}"; //e.g.- "{\"key1\":\"value1\",\"key2\":\"value2\"}"

        // Building request using requestSpecBuilder
        RequestSpecBuilder builder = new RequestSpecBuilder();

        //Setting API's body
        builder.setBody(APIBody);

        //Setting content type as application/json or application/xml
        builder.setContentType("application/json; charset=UTF-8");
        builder.addHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTQ4OTgwNjE4Nn0.QlVYiwCyAAzjZhAjxYUhEDRNLR3L8YaCneyeAl64IPD7_-GxksT3g2tovvU6YTbWS9EbiXjRRXtHZN7GU5c4wg");

        RequestSpecification requestSpec = builder.build();

        //Making post request with authentication, leave blank in case there are no credentials- basic("","")
//        Response response = given().authentication().preemptive().basic({username}, {password})
//                .spec(requestSpec).when().post(APIUrl);
        Response response = given()
                .spec(requestSpec).when().post(APIUrl);
        try{
            if(response.statusCode()==200||response.statusCode()==201)

            {
                System.out.println("Post pure text status Successful");
                JSONObject JSONResponseBody = new JSONObject(response.body().asString());
            }
        }
        catch(Exception ex)
        {
            System.out.println("Post pure text status failed");
        }

        //Fetching the desired value of a parameter
        //String result = JSONResponseBody.getString({key});

        //Asserting that result of Norway is Oslo
        //Assert.assertEquals(result, "{expectedValue}");

    }

    public void postnewfeeds() throws JSONException,InterruptedException {

        //Initializing Rest API's URL
        String APIUrl = "http://api.mediastep.ca:80/feedservices/api/feeds/trigger";

        // Building request using requestSpecBuilder
        RequestSpecBuilder builder = new RequestSpecBuilder();

        //Setting content type as application/json or application/xml
        builder.setContentType("application/json; charset=UTF-8");
        builder.addHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTQ4OTgwNjE4Nn0.QlVYiwCyAAzjZhAjxYUhEDRNLR3L8YaCneyeAl64IPD7_-GxksT3g2tovvU6YTbWS9EbiXjRRXtHZN7GU5c4wg");

        RequestSpecification requestSpec = builder.build();

        Response response = given()
                .spec(requestSpec).when().post(APIUrl);
        try{
            if(response.statusCode()==200||response.statusCode()==201)

            {
                System.out.println("Post new feeds Successful");
                JSONObject JSONResponseBody = new JSONObject(response.body().asString());
            }
        }
        catch(Exception ex)
        {
            System.out.println("Post new feeds failed");
        }

    }

//    public void deleteStatusFeed() throws JSONException,InterruptedException {
//
//        //Initializing Rest API's URL
//        String APIUrl = "http://api.mediastep.ca:80/statusservices/api/status/1101";
//
//        // Building request using requestSpecBuilder
//        RequestSpecBuilder builder = new RequestSpecBuilder();
//
//        //Setting content type as application/json or application/xml
//        builder.setContentType("application/json; charset=UTF-8");
//        builder.addHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTQ4OTgwNjE4Nn0.QlVYiwCyAAzjZhAjxYUhEDRNLR3L8YaCneyeAl64IPD7_-GxksT3g2tovvU6YTbWS9EbiXjRRXtHZN7GU5c4wg");
//
//        RequestSpecification requestSpec = builder.build();
//
//        Response response = given()
//                .spec(requestSpec).when().delete(APIUrl);
//        try{
//            if(response.statusCode()==200||response.statusCode()==201)
//
//            {
//                System.out.println("Delete new feeds Successful");
//                JSONObject JSONResponseBody = new JSONObject(response.body().asString());
//            }
//        }
//        catch(Exception ex)
//        {
//            System.out.println("Delete new feeds failed");
//        }
//
//    }
}

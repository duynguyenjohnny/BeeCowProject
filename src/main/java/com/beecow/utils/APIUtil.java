package com.beecow.utils;


import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.beecow.utils.Helper.addLog;

public class APIUtil {

    public static JSONObject sendPost(String url, String csrfToken, String cookie, Object requestBody) {
        try {
            // Create request connection
            URL obj = null;
            try {
                obj = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection con = null;
            try {
                con = (HttpURLConnection) obj.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:28.0) Gecko/20100101 Firefox/28.0");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            if (requestBody instanceof String) {
                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            } else {
                con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            }
            con.setRequestProperty("X-CSRF-Token", csrfToken);
            con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            con.setRequestProperty("Cookie", cookie);
            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(requestBody.toString());
            wr.flush();
            wr.close();
            addLog("\nSending 'POST' request to URL : " + url);
            addLog("Post parameters : " + requestBody);
            // Get response code
            int responseCode = con.getResponseCode();
            addLog("Response Code : " + responseCode);
            // Get response body
            BufferedReader in;
            if (responseCode != 200) {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            addLog(response.toString());
            // Return Json object
            JSONParser parser = new JSONParser();
            Object jsonObject = null;
            try {
                jsonObject = parser.parse(response.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(jsonObject instanceof Long){
                jsonObject = parser.parse("{\"id\": " + jsonObject.toString() + "}");
            }
            if(jsonObject instanceof Boolean){
                return null;
            }
            return (JSONObject) jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject sendGet(String url, String csrfToken, String cookie) {
        try {
            // Create request connection
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // Add request header
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:28.0) Gecko/20100101 Firefox/28.0");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            con.setRequestProperty("X-CSRF-Token", csrfToken);
            con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            con.setRequestProperty("Cookie", cookie);
            // Send get request
            addLog("\nSending 'GET' request to URL : " + url);
            // Get response code
            int responseCode = con.getResponseCode();
            addLog("Response Code : " + responseCode);
            // Get response body
            BufferedReader in;
            if (responseCode != 200) {
                in = new BufferedReader(new InputStreamReader(
                        con.getErrorStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            addLog(response.toString());
            // Return Json object
            JSONParser parser = new JSONParser();
            Object jsonObject = parser.parse(response.toString());
            if(jsonObject instanceof Long){
                jsonObject = parser.parse("{\"id\": " + jsonObject.toString() + "}");
            }
            if(jsonObject instanceof Boolean){
                return null;
            }
            return (JSONObject) jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject parseDataToJsonObject(String data){
        Object obj;
        JSONParser parser = new JSONParser();
        try {
            if (data.indexOf(".json") != -1) {
                obj = parser.parse(new FileReader(System
                        .getProperty("user.dir") + "\\json\\" + data));
            } else {
                obj = parser.parse(data);
            }
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String replaceStringValue(String string, String key, String value){
        int begin_index = string.indexOf(key);
        int end_index = string.indexOf("&", begin_index);
        if(value.contains("@")){
            value = value.replace("@", "%40");
        }
        return string.replace(string.substring(begin_index + key.length() + 1, end_index), value);

    }

    public static JSONObject sendHTTPRequest(String method, String url, String csrfToken, String cookie, String requestBody) {
        try {
            // Create request connection
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // add reuqest header
            con.setRequestMethod(method);
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:28.0) Gecko/20100101 Firefox/28.0");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            con.setRequestProperty("X-CSRF-Token", csrfToken);
            con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            con.setRequestProperty("Cookie", cookie);
            // Send HTTP request
            addLog("\nSending '" + method + "' request to URL : " + url);
            if (!method.equals("GET") && !method.equals("DELETE")) {
                con.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(
                        con.getOutputStream());
                wr.writeBytes(requestBody);
                wr.flush();
                wr.close();
                addLog("Post parameters : " + requestBody);
            }
            // Get response code
            int responseCode = con.getResponseCode();
            addLog("Response Code : " + responseCode);
            // Get response body
            BufferedReader in;
            if (responseCode != 200) {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            addLog(response.toString());
            // Return Json object
            JSONParser parser = new JSONParser();
            Object jsonObject = parser.parse(response.toString());
            if(jsonObject instanceof Long){
                jsonObject = parser.parse("{\"id\": " + jsonObject.toString() + "}");
            }
            if(jsonObject instanceof Boolean){
                return null;
            }
            return (JSONObject) jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

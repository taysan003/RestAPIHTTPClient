package com.rest.client;


import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.HashMap;

public class HTTPClient {

    //1. GET Call

    public void getCall(String url) throws IOException, JSONException {
       CloseableHttpClient httpClient =  HttpClients.createDefault(); //closeable HHTP connection
        HttpGet getCall = new HttpGet(url); // REST get Call
        CloseableHttpResponse response = httpClient.execute(getCall);

        //A. Extracting the Response code
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Status code is :" + statusCode);
        // B. Getting Response JSON
        String responseString = EntityUtils.toString(response.getEntity(), "UTF-8"); //converting restopose to string
        JSONObject responseJSON = new JSONObject(responseString); //converting string to json
        System.out.println("API Response JSON : " + responseJSON);
        // C. Getting response Headers
        Header[] responseHeadres = response.getAllHeaders(); // getting headers from response and putting in cillection
        HashMap<String, String> headerAll = new HashMap<String, String>(); // putting headers in collection

        for (Header header: responseHeadres) {
            headerAll.put(header.getName(), header.getValue());
        }

        System.out.println("All Headers are : " + headerAll);

    }
}

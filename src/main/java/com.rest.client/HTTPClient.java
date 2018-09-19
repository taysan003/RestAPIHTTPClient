package com.rest.client;


import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HTTPClient {

    //1. GET Call

    public void getCall(String url) throws IOException {
       CloseableHttpClient httpClient =  HttpClients.createDefault(); //closeable HHTP connection
        HttpGet getCall = new HttpGet(url); // REST get Call
        CloseableHttpResponse response = httpClient.execute(getCall);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Status code is :" + statusCode);
    }
}

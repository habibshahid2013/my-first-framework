package com.framework.java11GetHeaderTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Java11GetHeaderTest {

    private static final String BASE_URL = "https://api.github.com/";


    @Test
    void getReturns200() throws IOException, InterruptedException {

        //Arrange
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .GET()
                .setHeader("User-Agent", "Java 11 http ")
                .build();

        //ACT
       HttpResponse<Void> response =  httpClient.send(get, HttpResponse.BodyHandlers.discarding());
        int actualCode = response.statusCode();

        //Assert
        Assert.assertEquals(actualCode, 200);

    }

    @Test
    void contentTypeIsJson() throws IOException, InterruptedException{

            //Arrange
            HttpClient httpClient = HttpClient.newBuilder().build();

            HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                    .GET()
                    .setHeader("User-Agent", "Java 11 http ")
                    .build();

            //ACT
            HttpResponse<Void> response =  httpClient.send(get, HttpResponse.BodyHandlers.discarding());
            String contentType = response.headers().firstValue("content-type").get();

            Assert.assertEquals(contentType, "application/json; charset= utf-8");

    }

    @Test
    void xRateLimitIsPresent() throws IOException, InterruptedException {
        //Arrange

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();

        //ACT
        HttpResponse<Void> response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
        String xRateLimit = response.headers().firstValue("X-Ratelimit-Limit").get();
        Assert.assertEquals(Integer.parseInt(xRateLimit), 60);
    }
}

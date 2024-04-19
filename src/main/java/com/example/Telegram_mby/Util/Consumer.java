package com.example.Telegram_mby.Util;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


public final class Consumer {
    private static final RestTemplate restTemplate = new RestTemplate();

    private static final String urlGet = "https://reqres.in/api/users/2";
    private static final String urlPost = "https://reqres.in/api/users";
    public static String getRest() {
        return restTemplate.getForObject(urlGet, String.class);
    }

    public static String postRest() {
        Map<String, String> json = new HashMap<>();
        json.put("name", "testName");
        json.put("job", "testJob");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(json);
        return restTemplate.postForObject(urlPost, request ,String.class);
    }

}

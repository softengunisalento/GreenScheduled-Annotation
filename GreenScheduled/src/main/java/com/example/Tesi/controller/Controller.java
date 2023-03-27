package com.example.Tesi.controller;

import com.example.Tesi.error.ErrorHandler;
import java.io.BufferedReader;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Controller {
    public String carbonIntensityLive(String carbonIntensityZone,String key, String value, String v3) throws Exception{
        HttpRequest request = null;
        HttpClient client = HttpClient.newHttpClient();
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI("https://api-access.electricitymaps.com/" + v3 + "/carbon-intensity/latest?zone=" + carbonIntensityZone))
                    .header(key, value)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Integer code = response.statusCode();
                if(code==401){
                    throw new ErrorHandler.ZoneNotFound(null);
                } else if (code==403) {
                    throw new ErrorHandler.Unathorized(null);
                } else if(code==404){
                    throw new ErrorHandler.AccessDenied(null);
                }
            String carbonIntensityLive = response.body();
            String newCarbonIntensityLive = carbonIntensityLive.replace(',', '\n');
            BufferedReader br = new BufferedReader(new StringReader(newCarbonIntensityLive));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 1) {
                    System.out.println(line);
                    return line;
                }
                i++;
            }
            return line;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

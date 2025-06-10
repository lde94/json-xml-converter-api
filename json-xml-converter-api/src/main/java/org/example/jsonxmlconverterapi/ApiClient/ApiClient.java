package org.example.jsonxmlconverterapi.ApiClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    public String fetchData(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.err.println(response.statusCode() + " " + response.body());
                return null;
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error: fetching data from " + url + ": " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

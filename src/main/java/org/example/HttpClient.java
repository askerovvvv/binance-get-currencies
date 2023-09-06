package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient implements HttpClientService {

    @Override
    public String getCurrentData(String uri) {
        HttpResponse<String> response = null;
        java.net.http.HttpClient client = java.net.http.HttpClient.newBuilder()
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Не удалось получить ответ");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Не удалось получить ответ прервано");
            e.printStackTrace();
        }


        return response.body();
    }
}

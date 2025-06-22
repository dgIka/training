package javarush.servlets;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServletTestClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();

        String uri = "http://localhost:8080/colorText?text=HelloSomebody&color=blue";

        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).GET().build();
        try {
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: \n" + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}

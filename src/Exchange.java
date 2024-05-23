import com.google.gson.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Exchange {

    public ExchangeApi retornaValor(String moeda1, String moeda2)  {
        var endereco =  "https://v6.exchangerate-api.com/v6/7724a05ae672a9a639a8059e/pair/" + moeda1 +"/" + moeda2;
        try {
            URL url = new URL(endereco);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeApi.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui encontrar essa moeda.");
        }
    }
}

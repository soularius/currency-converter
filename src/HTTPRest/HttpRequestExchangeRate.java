package HTTPRest;

import Exchange.Conversion;
import HTTPRest.Template.RExchangeRate;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestExchangeRate extends ExchangeRate {

    public HttpRequestExchangeRate(String money)
    {
        super(money);
    }

    public String requestExchangeRate()
    {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(this.getUrl())
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

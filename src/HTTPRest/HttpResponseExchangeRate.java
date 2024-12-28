package HTTPRest;

import Exchange.Conversion;
import HTTPRest.Template.RExchangeRate;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpResponseExchangeRate
{
    public Conversion responseExchangeRate(String json)
    {
        try {
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .setPrettyPrinting()
                    .create();
            RExchangeRate rExchangeRate = gson.fromJson(json, RExchangeRate.class);
            return new Conversion(rExchangeRate);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

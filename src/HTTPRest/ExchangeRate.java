package HTTPRest;

import java.net.URI;

public class ExchangeRate
{
    private static URI url;
    private static String domain = "https://v6.exchangerate-api.com";
    private static String version = "v6";
    private static String token = "c5613408bdc441c81f47c7cd";
    private String money;

    public ExchangeRate(String money)
    {
        this.money = money;
        String strUrl = String.format("%s/%s/%s/latest/%s", domain, version, token, this.money);
        url = URI.create(strUrl);
    }

    public URI getUrl()
    {
        return url;
    }

    public void setMoney(String money)
    {
        this.money = money;
    }
}

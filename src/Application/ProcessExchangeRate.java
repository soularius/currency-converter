package Application;

import Exchange.Conversion;
import Exchange.Money;
import HTTPRest.HttpRequestExchangeRate;
import HTTPRest.HttpResponseExchangeRate;

public class ProcessExchangeRate {
    private Money to;
    private Money from;
    private double valueExchange;

    public ProcessExchangeRate() {}

    public ProcessExchangeRate(Money to, Money from, double valueExchange) {
        this.to = to;
        this.from = from;
        this.valueExchange = valueExchange;
    }

    public Conversion consultExchangeRate()
    {
        HttpRequestExchangeRate httpRequestExchangeRate = new HttpRequestExchangeRate("USD");
        HttpResponseExchangeRate httpResponseExchangeRate = new HttpResponseExchangeRate();
        String json = httpRequestExchangeRate.requestExchangeRate();
        return httpResponseExchangeRate.responseExchangeRate(json);
    }

    public Money getTo() {
        return to;
    }

    public Money getFrom() {
        return from;
    }

    public double getValueExchange() {
        return valueExchange;
    }

    @Override
    public String toString() {
        return  "to=" + to +
                ", from=" + from +
                ", valueExchange=" + valueExchange;
    }
}

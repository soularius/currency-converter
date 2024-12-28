package HTTPRest.Template;

import java.util.Map;

public record RExchangeRate(
        String result,
        String timeLastUpdateUtc,
        String baseCode,
        Map<String, Double> conversionRates
) {}

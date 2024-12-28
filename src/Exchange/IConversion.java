package Exchange;

import java.util.List;

public interface IConversion {

    public List<Money> filterByKeys(List<String> keys);
    public Money filterByKey(String key);
}

package Exchange;

import HTTPRest.Template.RExchangeRate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Conversion implements IConversion
{
    private List<Money> moneyList;
    private String baseCode;
    private String result;
    private String lastTimeUpdate;

    public Conversion(List<Money> moneyList, String baseCode, String result, String lastTimeUpdate)
    {
        this.moneyList = moneyList;
        this.baseCode = baseCode;
        this.result = result;
        this.lastTimeUpdate = lastTimeUpdate;
    }

    public Conversion(RExchangeRate rExchangeRate)
    {
        this.baseCode = rExchangeRate.baseCode();
        this.result = rExchangeRate.result();
        this.lastTimeUpdate = rExchangeRate.timeLastUpdateUtc();
        this.moneyList = rExchangeRate.conversionRates()
                .entrySet()
                .stream()
                .map(entry -> new Money(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<Money> addMoneyToList(Money money)
    {
        this.moneyList.add(money);
        return moneyList;
    }

    public double calculeChange(Money from, Money to, double value)
    {
        double calcule = 0;
        if (from.getValue() == 0 || to.getValue() == 0) {
            System.out.println("No se puede realizar la conversión. Las tasas deben ser mayores que cero.");
            return 0;
        }
        double exchangeRate = to.getValue() / from.getValue();
        calcule = value * exchangeRate;
        return calcule;
    }

    public List<Money> getMoneyList()
    {
        return moneyList;
    }

    public String getBaseCode()
    {
        return baseCode;
    }

    public String getResult()
    {
        return result;
    }

    public String getLastTimeUpdate()
    {
        return lastTimeUpdate;
    }

    @Override
    public List<Money> filterByKeys(List<String> keys) {
        List<Money> filteredMoneyList = this.moneyList.stream()
                .filter(money -> keys.contains(money.getName()))
                .toList();
        return filteredMoneyList;
    }

    @Override
    public Money filterByKey(String key) {
        return this.moneyList.stream()
                .filter(money -> money.getName().equals(key))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return  "moneyList=" + moneyList +
                ", baseCode='" + baseCode + '\'' +
                ", result='" + result + '\'' +
                ", lastTimeUpdate='" + lastTimeUpdate + '\'';
    }
}

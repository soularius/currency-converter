package Application;

import Exchange.Money;

import java.util.ArrayList;
import java.util.List;

public class FilterMoney {

    private List<Money> moneys;

    public FilterMoney() {}

    public FilterMoney(List<Money> moneys)
    {
        this.moneys = moneys;
    }

    public List<Money> getMoneys() {
        return moneys;
    }

    public void initKeysDefault()
    {
        this.moneys = new ArrayList<Money>();
        this.moneys.add(new Money("USD", "Dolar Estado Unidense"));
        this.moneys.add(new Money("CLP", "Peso Chileno"));
        this.moneys.add(new Money("COP", "Peso Colombiano"));
    }

    public List<String> getNames(List<Money> moneys)
    {
        if(moneys.isEmpty()) return null;
        List<String> names = moneys.stream()
                .map(Money::getName)
                .toList();
        return names;
    }

    public List<String> getDescription(List<Money> moneys)
    {
        if(moneys.isEmpty()) return null;
        List<String> descriptions = moneys.stream()
                .map(Money::getDescription)
                .toList();
        return descriptions;
    }

    public Money findByName(String name) {
        if (moneys == null || moneys.isEmpty()) {
            return null;
        }

        return moneys.stream()
                .filter(money -> money.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}

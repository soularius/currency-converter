package Application;

import Exchange.Conversion;
import Exchange.Money;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSystem extends MenuItem{
    ArrayList<MenuItem> menuSystem = new ArrayList<MenuItem>();
    private Scanner scanner = new Scanner(System.in);
    private List<Money> listItemsMoneys = new ArrayList<Money>();
    private FilterMoney moneyDefault = new FilterMoney();
    private Money moneyTo = new Money();
    private Money moneyFrom = new Money();

    public ArrayList<MenuItem> initMenuSystem()
    {
        this.moneyDefault.initKeysDefault();
        this.listItemsMoneys = this.moneyDefault.getMoneys();

        int index = 1;
        for (Money from : this.listItemsMoneys) {
            for (Money to : this.listItemsMoneys) {
                if (!from.getName().equals(to.getName())) {
                    MenuItem item = new MenuItem(index, from.getDescription() + " => " + to.getDescription(), to.getName(), from.getName());
                    this.addItem(item);
                    index++;
                }
            }
        }
        this.addItem(new MenuItem(index, "Salir", "", ""));
        return this.menuSystem;
    }

    public ArrayList<MenuItem> addItem(MenuItem menuItem)
    {
        this.menuSystem.add(menuItem);
        return this.menuSystem;
    }

    public void showMenu()
    {
        System.out.println("*************************************************");
        System.out.println("      Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println("*************************************************");

        for (MenuItem item : menuSystem) {
            System.out.println(item.getNumberItem() + ") " + item.getNameItem());
        }

        System.out.println("*************************************************");
        System.out.print("Elija una opción válida: ");
    }

    public int readOption()
    {
        int option = -1;
        while (option < 1 || option > menuSystem.size()) {
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option < 1 || option > menuSystem.size()) {
                    System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número.");
            }
        }
        return option;
    }

    public void getMoneyOption(int selectedOption)
    {
        MenuItem selectedItem = menuSystem.get(selectedOption - 1);

        if (selectedItem.getNameItem().equals("Salir")) {
            System.out.println("Saliendo del sistema...");
            return;
        }
        this.moneyTo = moneyDefault.findByName(selectedItem.getTo());
        this.moneyFrom = moneyDefault.findByName(selectedItem.getFrom());
        System.out.println("De: " + moneyFrom.getDescription() + " A: " + moneyTo.getDescription());
    }

    protected double valueExchangeRate()
    {
        double value = 0;
        while (true) {
            try {
                System.out.print("Ingrese el valor a convertir: ");
                value = Double.parseDouble(scanner.nextLine());

                if (value <= 0) {
                    System.out.println("El valor debe ser mayor que cero. Intente nuevamente.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número válido.");
            }
        }
        return value;
    }

    public void processMenuOption()
    {
        ProcessExchangeRate processExchangeRate;
        Conversion conversion;
        Money moneyToObj;
        Money moneyFromObj;
        double valueExchange = 0;
        this.initMenuSystem();
        while (true) {
            this.showMenu();
            int selectedOption = this.readOption();
            if(selectedOption == 7) { break; }
            this.getMoneyOption(selectedOption);
            valueExchange = this.valueExchangeRate();
            processExchangeRate = new ProcessExchangeRate(moneyTo, moneyFrom, valueExchange);
            conversion = processExchangeRate.consultExchangeRate();
            moneyToObj = conversion.filterByKey(moneyTo.getName());
            moneyFromObj = conversion.filterByKey(moneyFrom.getName());
            double calculate = conversion.calculeChange(moneyFromObj, moneyToObj, valueExchange);
            this.seeCalcule(moneyFrom, moneyTo, valueExchange, calculate);
        }
    }

    public void seeCalcule(Money moneyFrom, Money moneyTo, double value, double calcule)
    {
        DecimalFormat df = new DecimalFormat("#.00");
        String format = df.format(calcule);
        System.out.println("El valor " + value + " [" + moneyFrom.getName() + "] Corresponde al valor final de =>>> " + format + " [" + moneyTo.getName() + "]" );
    }

    public ArrayList<MenuItem> getMenuSystem()
    {
        return menuSystem;
    }

    public void setMenuSystem(ArrayList<MenuItem> menuSystem)
    {
        this.menuSystem = menuSystem;
    }

    public List<Money> getListItemsMoneys()
    {
        return listItemsMoneys;
    }

    public void setListItemsMoneys(List<Money> listItemsMoneys)
    {
        this.listItemsMoneys = listItemsMoneys;
    }

    public Money getMoneyTo()
    {
        return moneyTo;
    }

    public void setMoneyTo(Money moneyTo)
    {
        this.moneyTo = moneyTo;
    }

    public Money getMoneyFrom()
    {
        return moneyFrom;
    }

    public void setMoneyFrom(Money moneyFrom)
    {
        this.moneyFrom = moneyFrom;
    }
}

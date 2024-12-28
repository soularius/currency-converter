package Exchange;

public class Money
{
    private String name;
    private double value;
    private String description;

    public Money() {}

    public Money(String name, double value)
    {
        this.name = name;
        this.value = value;
    }

    public Money(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                "description='" + description + '\'' +
                ", value=" + value;
    }
}

package Application;

public class MenuItem {
    private int numberItem;
    private String nameItem;
    private String to;
    private String from;

    public MenuItem() {
    }

    public MenuItem(int numberItem, String nameItem, String to, String from) {
        this.numberItem = numberItem;
        this.nameItem = nameItem;
        this.to = to;
        this.from = from;
    }

    public int getNumberItem() {
        return numberItem;
    }

    public void setNumberItem(int numberItem) {
        this.numberItem = numberItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return  "numberItem=" + numberItem + '\'' +
                ", nameItem='" + nameItem + '\'' +
                ", to='" + to + '\'' +
                ", from='" + from;
    }
}

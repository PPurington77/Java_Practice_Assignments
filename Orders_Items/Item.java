public class Item {
    private String name;
    private double price;

    //constructor
    public Item() {}

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //Getters and Setters
    public String getItemName() {
        return this.name;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public double getItemPrice() {
        return this.price;
    }

    public void setItemPrice(double price) {
        this.price = price;
    }
}
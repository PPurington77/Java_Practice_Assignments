import java.util.ArrayList;
public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    //constructor
    public Order() {
        this.name = "Guest";
        this.ready = false;
    }

    //constructor
    public Order(String name) {
        this.name = name;
        this.ready = false;
    }

    //Getter and Setters
    public String getOrderName() {
        return name;
    }

    public void setOrderName(String name) {
        this.name = name;
    }

    public boolean isReady() {
        return ready;
    }

    public void orderIsReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    //methods
    //create a method called addItem that takes an Item object as an argument and adds the item to the order's items array
    public void addItem(Item item) {
        this.items.add(item);
    }

    //getStatusMessage that returns a String message. if ready return Your order is ready else Thank you for waiting your order will be ready soon.
    public String getStatusMessage() {
        if( this.ready == true) {
            return "Your order is ready";
        }
        else {
            return "Thank you for waiting, your order will be ready soon";
        }
    }

    //getOrderTotal sums together each of the items prices and returns the total amount
    public double getOrderTotal() {
        double total = 0.0;
        for( Item i : this.items) {
            total += i.getItemPrice();
        }
        return total;
    }

    //display prints out the order information
    public void display() {
        System.out.printf("Customer Name: %s", this.name);
        for( Item i : this.items ) {
            System.out.println("\n" + i.getItemName() + " $" + i.getItemPrice());
        }
        System.out.printf("Total: $" + this.getOrderTotal() + "\n");
    } 
}
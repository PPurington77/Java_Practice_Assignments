import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {

        Item item1 = new Item("cappucino", 4.5);
        Item item2 = new Item("Mocha", 3.75);
        Item item3 = new Item("Latte", 2.50);
        Item item4 = new Item("Drip Coffee", 1.75);

        //orders w/o names
        Order order1 = new Order();
        Order order2 = new Order();

        //orders w/ names
        Order order3 = new Order("Patrick");
        Order order4 = new Order("Debby");
        Order order5 = new Order("Hannah");

        //add 2 items to each order
        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item3);
        order2.addItem(item4);
        order3.addItem(item1);
        order3.addItem(item4);
        order4.addItem(item2);
        order4.addItem(item3);
        order5.addItem(item4);
        order5.addItem(item4);

        //some orders are ready
        order5.orderIsReady(true);
        order1.orderIsReady(true);
        order3.orderIsReady(true);

        System.out.println(order5.getStatusMessage());
        System.out.println(order1.getStatusMessage());
        System.out.println(order3.getStatusMessage());

        // //order totals
        System.out.println(order5.getOrderTotal());
        System.out.println(order1.getOrderTotal());
        System.out.println(order3.getOrderTotal());

        //order display
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

    }
}
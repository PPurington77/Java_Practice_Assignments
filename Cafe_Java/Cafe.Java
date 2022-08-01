public class Cafe {
    public static void main(String[] args) {
        String generalGreeting = "Welcome to Cafe Java ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        double mochaPrice = 3.5;
        double dripCoffee = 2.25;
        double latte = 3.1;
        double cappuccino = 4.4;

        String customer1 = "Cinhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        System.out.println(generalGreeting + customer1);
        System.out.println(customer1 + pendingMessage);
        System.out.println(generalGreeting + customer4);
        System.out.println(customer4 + pendingMessage);
        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappuccino);
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }

        System.out.println(customer2 + displayTotalMessage + (latte + latte));
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }

        System.out.println(customer3 + displayTotalMessage + (latte - dripCoffee));
    }
}
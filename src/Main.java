import order.Order;

public class Main {
    public static void main(String[] args) {
        Order.createOrder();
        Order.printPrimeClient();
        Order.AllRestaurantsWhichHaveTotalAmountOfOrdersGreaterThanTheGivenNumber();
        Order.ordersAcrossAllRestaurantsWhichWereDoneAtGivenDay();

    }
}
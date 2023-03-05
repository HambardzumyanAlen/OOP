package models;
import order.Order;

public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private boolean isPrime;

    private Order[] inactiveOrders = new Order[10];
    private Order[] activeOrders = new Order[10];


    private int ordersCount = 0;

    private int level = 0;




    private Order[] order = new Order[10];

    public Order[] getOrder() {
        return order;
    }

    public void setOrder(Order[] order) {
        this.order = order;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Order[] getInactiveOrders() {
        return inactiveOrders;
    }

    public void setInactiveOrders(Order[] inactiveOrders) {
        this.inactiveOrders = inactiveOrders;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }

    public Order[] getActiveOrders() {
        return activeOrders;
    }

    public void setActiveOrders(Order[] activeOrders) {
        this.activeOrders = activeOrders;
    }

    public void ClientsInActiveOrders(Order order) {
        if (!order.isActive) {
            inactiveOrders[ordersCount++] = order;
        }
    }

    public void ClientsActiveOrders(Order order) {
        if (order.isActive) {
            inactiveOrders[ordersCount++] = order;
        }
    }

    public Client(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

    }

    public static final Client[] CLIENTS = saveClients();

    private static Client[] saveClients() {
        Client[] allClients = new Client[10];
        return allClients;
    }


    public Client(String firstName, String lastName, String phoneNumber, int level, boolean isPrime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.level = level;
        this.isPrime = isPrime;
    }


    @Override
    public String toString() {
        return "Client{" +
                " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", level=" + level +
                ", isPrime=" + isPrime +
                '}';
    }
}
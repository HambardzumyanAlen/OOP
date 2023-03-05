package order;

import enums.Paid;
import enums.Meal;
import models.Client;
import models.Restaurant;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

import static models.Restaurant.RESTAURANTS;
import static models.Restaurant.resolveRestaurant;

public class Order {
    private int id;
    private Client client;
    private String date;
    public boolean isActive = true;
    private int amount;
    private Meal type;

    private Restaurant restaurant;
    private Paid paidType;


    public Order() {
    }

    public Order(int id, Client client, String date, boolean isActive, int amount, Meal type, Paid paidType) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.isActive = isActive;
        this.amount = amount;
        this.type = type;
        this.paidType = paidType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isActive(Boolean isActive) {
        return this.isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Meal getType() {
        return type;
    }

    public void setType(Meal type) {
        this.type = type;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Paid getPaidType() {
        return paidType;
    }

    public void setPaidType(Paid paidType) {
        this.paidType = paidType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Client resolveClient(String text) {
        String[] details = text.split(",");

        return new Client(details[0], details[1], details[2], Integer.parseInt(details[3]), Boolean.parseBoolean(details[4]));
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", date=" + date +
                ", isActive=" + isActive +
                ", amount=" + amount +
                ", type=" + type +
                ", paidType=" + paidType +
                '}';


    }


    public static void createOrder() {
        System.out.println("Put the number of orders ");
        Scanner scanner = new Scanner(System.in);
        int ordersCount = scanner.nextInt();
        if (ordersCount < 1) {
            ordersCount = 1;
        }
        int count = 0;
        do {
            Order order = new Order();
            System.out.println("Type the your fullDate (firstName,lastName,phoneNumber,level,isPrime)");
            String fullData = scanner.next();
            System.out.println("Type the Restaurant id (Asian || European || African || American)");
            int restaurant = scanner.nextInt();
            System.out.println("Enter the date (--/--/--)");
            String date = scanner.next();
            System.out.println("Enter the isActive (t||f)");
            Boolean isActive = Boolean.valueOf(scanner.next());
            System.out.println("Type the order (BREAKFAST || LUNCH || DINNER)");
            String type = scanner.next();

            order.setId(count + 1);
            order.setClient(order.resolveClient(fullData));
            order.setDate(date);
            order.isActive(isActive);
            Restaurant currentRestaurant = resolveRestaurant(restaurant);
            order.setRestaurant(currentRestaurant);
            order.setType(Meal.valueOf(type));

            System.out.println("--------Amount--------");
            if (order.getType() == Meal.BREAKFAST) {
                order.setAmount(5000);
            } else if (order.getType() == Meal.LUNCH) {
                order.setAmount(7000);
            } else if (order.getType() == Meal.DINNER) {
                order.setAmount(10000);
            }
            System.out.println(order.getType() + " costs AMD " + order.getAmount());

            System.out.println("paid Type (CASH || ONLINE)");
            String paidType = scanner.next();

            order.setPaidType(Paid.valueOf(paidType));
            currentRestaurant.addRestaurant(order);
            count++;
        }
        while (count < ordersCount);
        for (Restaurant restaurant : RESTAURANTS) {
            System.out.println("The restaurant: " + restaurant.getName() +
                    " has  " + restaurant.getOrdersCount() + " orders:");
            if (restaurant.getOrdersCount() == 0) {
                System.out.println("----------- Nothing ----------");
                System.out.println();
            }
            for (Order order : restaurant.getOrders()) {
                if (order == null) {
                    break;
                }
                System.out.println(order);
                System.out.println("---------------------------------------");
            }
        }
    }

    public static void printPrimeClient() {
        System.out.println("---------------Prime clients--------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name");
        String firstName = scanner.next();
        System.out.println("Enter level");
        int level = scanner.nextInt();
        for (Restaurant restaurant : RESTAURANTS) {
            for (Order order : restaurant.getOrders()) {
                if (restaurant.getOrdersCount() == 0) {
                    break;
                }
                if (order == null) {
                    break;
                }
                if (order.getClient().isPrime() && (Objects.equals(order.getClient().getFirstName(), firstName) && (order.getClient().getLevel() == level))) {
                    System.out.println(restaurant.getName() + " restaurant client " + order.getClient());
                }else {
                    System.out.println(restaurant.getName() + " is not client with that name not Peter");
                }
            }
        }

    }

    public static void printCount() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the count(count>1)");
        int count1 = scanner1.nextInt();
        for (Restaurant restaurant : Restaurant.RESTAURANTS) {
            for (Order order : restaurant.getOrders()) {
                if (restaurant.getOrdersCount() == 0) {
                    break;
                }
                if (order == null) {
                    break;

                }
                if (count1 > restaurant.getOrdersCount()) {
                    System.out.println("Restaurant " + restaurant.getName() + " has " + restaurant.getOrdersCount());
                    System.out.println(restaurant.toString());
                } else {
                    System.out.println("there isn't such restaurant");
                }
            }
        }
    }


    public static void ordersAcrossAllRestaurantsWhichWereDoneAtGivenDay() {
        System.out.println("Write today's date  (****-**-**)");
        Scanner scannerDate = new Scanner(System.in);
        String date = scannerDate.nextLine();
        LocalDate d = LocalDate.parse(date);

        for (Restaurant restaurant2 : Restaurant.RESTAURANTS) {
            for (Order order : restaurant2.getOrders()) {
                if (order == null) {
                    break;
                }

                System.out.println("-------------------------");
                System.out.println(order.toString());

                System.out.println();


            }
        }
    }
}

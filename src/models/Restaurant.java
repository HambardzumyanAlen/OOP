package models;

import order.Order;

public class Restaurant {
    private int id;

    private String name;
    private int star;

    private Order[] orders = new Order[10];

    private int ordersCount = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }


    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }

    public Restaurant(int id, String name, int star) {
        this.id = id;
        this.name = name;
        this.star = star;
    }

    public void addRestaurant(Order order) {
        orders[ordersCount++] = order;
    }

    @Override
    public String toString() {
        return "Restaurant{" +"id=" + id + ", name='" + name + '\'' + "," +
                " star=" + star + '}';
    }
    public static final Restaurant[] RESTAURANTS = saveRestaurant();

    private static Restaurant[] saveRestaurant() {
        Restaurant[] allRestaurant = new Restaurant[4];
        Restaurant Asian = new Restaurant(1, "Asian", 3);
        Restaurant European = new Restaurant(2, "European", 2);
        Restaurant African = new Restaurant(3, "African", 4);
        Restaurant American = new Restaurant(4, "American", 5);

        allRestaurant[0] = Asian;
        allRestaurant[1] = European;
        allRestaurant[2] = African;
        allRestaurant[3] = American;
        return allRestaurant;
    }

    public static Restaurant resolveRestaurant(int id) {
        switch (id) {
            case 1:
                return RESTAURANTS[0];
            case 2:
                return RESTAURANTS[1];
            default:
            case 3:
                return RESTAURANTS[2];
            case 4:
                return RESTAURANTS[3];
        }
    }
}

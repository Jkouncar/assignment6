import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BevShop implements BevShopInterface {
    private List<Order> orders;

    public BevShop() {
        orders = new ArrayList<>();
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        if (orders.isEmpty()) {
            return true;
        }
        
        Order currentOrder = orders.get(orders.size() - 1);
        return currentOrder.findNumOfBeveType(Type.ALCOHOL) < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        if (!orders.isEmpty()) {
            Order currentOrder = orders.get(orders.size() - 1);
            return currentOrder.findNumOfBeveType(Type.ALCOHOL);
        }
        return 0;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        Order newOrder = new Order(time, day, customer);
        orders.add(newOrder);
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        if (!orders.isEmpty()) {
            Order currentOrder = orders.get(orders.size() - 1);
            currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
        }
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (!orders.isEmpty()) {
            Order currentOrder = orders.get(orders.size() - 1);
            currentOrder.addNewBeverage(bevName, size);
        }
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (!orders.isEmpty()) {
            Order currentOrder = orders.get(orders.size() - 1);
            currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
        }
    }
    
    
    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0.0;
    }

    @Override
    public double totalMonthlySale() {
        double totalSale = 0.0;
        for (Order order : orders) {
            totalSale += order.calcOrderTotal();
        }
        return totalSale;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        if (!orders.isEmpty()) {
            return orders.get(orders.size() - 1);
        }
        return null;
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    @Override
    public void sortOrders() {
        orders.sort(null); // Orders are comparable, so they will be sorted by order number
    }
}

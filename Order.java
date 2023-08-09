import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNumber;
    private int orderTime;
    private Day day;
    private Customer customer;
    private List<Beverage> beverageList;

    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    // Constructor
    public Order(int orderTime, Day day, Customer customer) {
        this.orderNumber = generateRandomNumber();
        this.orderTime = orderTime;
        this.day = day;
        this.customer = new Customer(customer); // Deep copy of the customer
        this.beverageList = new ArrayList<>();
    }

    // Generate a random number within the range of 10000 and 90000
    private int generateRandomNumber() {
        return new Random().nextInt(80001) + 10000;
    }

    // Method to add a new beverage to the order
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Coffee coffee = new Coffee(bevName, Type.COFFEE, size, extraShot, extraSyrup);
        beverageList.add(coffee);
    }

    public void addNewBeverage(String bevName, Size size) {
        Alcohol alcohol = new Alcohol(bevName, Type.ALCOHOL, size, day == Day.SATURDAY || day == Day.SUNDAY);
        beverageList.add(alcohol);
    }

    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Smoothie smoothie = new Smoothie(bevName, Type.SMOOTHIE, size, addProtein, numOfFruits);
        beverageList.add(smoothie);
    }

    // Implement other methods from the OrderInterface

    @Override
    public boolean isWeekend() {
        return day == Day.SATURDAY || day == Day.SUNDAY;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverageList.size()) {
            return beverageList.get(itemNo);
        }
        return null;
    }

    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage beverage : beverageList) {
            total += beverage.calcPrice();
        }
        return total;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : beverageList) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.orderNumber, o.orderNumber);
    }

    // Other getters and setters

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Beverage beverage : beverageList) {
            sb.append(beverage.toString()).append("\n");
        }
        return "Order Number: " + orderNumber + "\nTime: " + orderTime + "\nDay: " + day +
                "\nCustomer Name: " + customer.getName() + "\nAge: " + customer.getAge() + "\nOrder:\n" + sb.toString();
    }

	public String getItemsOrdered() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTotalItems() {
		// TODO Auto-generated method stub
		return 0;
	}
}

import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();

        System.out.println("The current order in process can have at most " +
                           bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " +
                           bevShop.getMinAgeForAlcohol());

        while (true) {
            System.out.println("Start please a new order:");
            System.out.println("Your Total Order for now is " + bevShop.totalOrderPrice(0));

            // Get customer name
            System.out.print("Would you please enter your name: ");
            String name = scanner.nextLine();

            // Get customer age
            System.out.print("Would you please enter your age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Start a new order
            bevShop.startNewOrder(12, Day.MONDAY, name, age);

            if (age >= bevShop.getMinAgeForAlcohol()) {
                System.out.println("Your age is above 20 and you are eligible to order alcohol");

                while (bevShop.getNumOfAlcoholDrink() < 3 && bevShop.isEligibleForMore()) {
                    System.out.println("Would you please add an alcohol drink");
                    System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getItemsOrdered());
                    System.out.println("The Total price on the Order is " + bevShop.totalOrderPrice(0));
                    bevShop.processAlcoholOrder("Alcohol", Size.SMALL);
                }

                if (bevShop.isEligibleForMore()) {
                    System.out.println("Would you please add a COFFEE to your order:");
                    bevShop.processCoffeeOrder("Coffee", Size.SMALL, false, false);
                    System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getItemsOrdered());
                    System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(0));
                }
            } else {
                System.out.println("Your Age is not appropriate for alcohol drink!!");
            }

            System.out.println("#------------------------------------#");

            // Rest of your code for the second order

            // Consume the newline character
            scanner.nextLine();
        }

        
    }
}

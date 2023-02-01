import java.util.Scanner;

public class RestaurantRatingSystemConsoleUI {
    public static void main(String[] args)  {
        mainMenu();
    }
    static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        RestaurantRatingSystem restaurantRating= new RestaurantRatingSystem();
        // Main loop
        while (true) {
            System.out.println("\n1. Add Restaurant");
            System.out.println("2. rate restaurant");
            System.out.println("3. view restaurants");
            System.out.println("4. Save and quit");
            System.out.print("Enter a choice: ");

            int choice = scanner.nextInt();
            if (choice == 1) {
                addRestaurantMenu(scanner,restaurantRating);
            } else if (choice == 2) {
                reviewRestaurantMenu(scanner,restaurantRating);
            } else if (choice == 3) {
                printRestaurantMenu(scanner,restaurantRating);
            } else if (choice == 4) {
                saveAndExitRestaurantMenu(restaurantRating);
                break;
            }
            else  {
                System.out.println("\nInvalid input try again");
            }
        }
    }
     static void addRestaurantMenu(Scanner scanner, RestaurantRatingSystem restaurantRating){
         System.out.print("\nEnter Restaurant name: ");
         scanner.nextLine();
         String name= scanner.nextLine();
         restaurantRating.addRestaurant(name);
     }
    static void reviewRestaurantMenu(Scanner scanner, RestaurantRatingSystem restaurantRating){
        System.out.println("\nRestaurant name   | Rating");
        for (Restaurant outlet : restaurantRating.getRestaurants()) {
            System.out.println(outlet);
        }
        System.out.print("\nEnter Restaurant name: ");
        scanner.nextLine();
        String name= scanner.nextLine();
        System.out.print("Enter rating (1-5): ");
        int rating = scanner.nextInt();
        restaurantRating.addRating(name,rating);
    }
    static void printRestaurantMenu(Scanner scanner, RestaurantRatingSystem restaurantRating){
        System.out.println("\nRestaurant name   | Rating");
        for (Restaurant outlet : restaurantRating.getRestaurants()) {
            System.out.println(outlet);
        }
        System.out.println("press enter key to continue");
        scanner.nextLine();
        scanner.nextLine();
    }
    static void saveAndExitRestaurantMenu( RestaurantRatingSystem restaurantRating){
        restaurantRating.saveRestaurants(restaurantRating.getRestaurants());
    }
}

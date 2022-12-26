import java.util.Scanner;

public class RestaurantRatingSystemConsoleUI {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        RestaurantRatingSystem restaurantRating= new RestaurantRatingSystem();
        // Main loop
        while (true) {
            System.out.println("1. Add food outlet");
            System.out.println("2. View ratings");
            System.out.println("3. Save and quit");
            System.out.print("Enter a choice: ");

            int choice = scanner.nextInt();
            if (choice == 1) {

                System.out.print("Enter Restaurant name: ");
                scanner.nextLine();
                String name= scanner.nextLine();
                System.out.print("Enter rating (1-5): ");
                int rating = scanner.nextInt();
                Restaurant outlet = new Restaurant(name,rating);
                restaurantRating.addRestaurant(outlet);
            } else if (choice == 2) {
                System.out.println("Restaurant name   | Rating");
                for (Restaurant outlet : restaurantRating.getRestaurants()) {
                    System.out.println(outlet);
                }
            } else if (choice == 3) {
                restaurantRating.saveOutlets(restaurantRating.getRestaurants());
                break;
            }
        }
    }
}

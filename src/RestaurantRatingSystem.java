import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRatingSystem {
    private static final String SAVE_FILE_NAME = "ratings.sav";
    private List<Restaurant> restaurants;

    public RestaurantRatingSystem() {
        restaurants = loadOutlets();

        // If the list could not be loaded, create a new one
        if (restaurants == null) {
            restaurants = new ArrayList<>();
        }
    }


    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
    }

      List<Restaurant> loadOutlets() {
        List<Restaurant> outlets = null;
        try (FileInputStream fis = new FileInputStream(SAVE_FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            outlets = (List<Restaurant>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Could not load outlets
        }
        return outlets;
    }

      void saveOutlets(List<Restaurant> outlets) {
        try (FileOutputStream fos = new FileOutputStream(SAVE_FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(outlets);
        } catch (IOException e) {
            System.out.println("Error saving outlets: " + e.getMessage());
        }
    }
}


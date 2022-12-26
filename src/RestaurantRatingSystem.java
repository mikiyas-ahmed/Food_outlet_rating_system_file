import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRatingSystem {
    private static final String SAVE_FILE_NAME = "ratings.sav";
    private List<Restaurant> restaurants;

    public RestaurantRatingSystem() {
        restaurants = loadRestaurants();

        // If the list could not be loaded, create a new one
        if (restaurants == null) {
            restaurants = new ArrayList<>();
        }
    }
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addRestaurant(String name) {
        Restaurant restaurant= new Restaurant(name);
        this.restaurants.add(restaurant);
    }
    public void addRating(String name,Integer rating) {
        Restaurant restaurant= getRestaurantByName(name);
        restaurant.addRating(rating);
    }
    public Restaurant getRestaurantByName(String name) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(name)) {
                return restaurant;
            }
        }
        return null;
    }

      List<Restaurant> loadRestaurants() {
        List<Restaurant> restaurants = null;
        try (FileInputStream fis = new FileInputStream(SAVE_FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            restaurants = (List<Restaurant>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Could not load restaurants
        }
        return restaurants;
    }

      void saveRestaurants(List<Restaurant> restaurants) {
        try (FileOutputStream fos = new FileOutputStream(SAVE_FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(restaurants);
        } catch (IOException e) {
            System.out.println("Error saving restaurants: " + e.getMessage());
        }
    }
}


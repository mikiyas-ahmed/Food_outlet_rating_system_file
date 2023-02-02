import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    @Test
    void getName() {
        Restaurant restaurant=new Restaurant("Habeshawi");
        String actual=restaurant.getName();
        String expected= "Habeshawi";
        Assert.assertEquals(actual,expected);
    }

    @Test
    void getRatings() {
        Restaurant restaurant=new Restaurant("Habeshawi");
        restaurant.addRating(5);
        restaurant.addRating(4);
        List<Integer> actual= restaurant.getRatings();
        List<Integer> expected= new ArrayList<>(){};
        expected.add(5);
        expected.add(4);

        Assert.assertEquals(actual,expected);
    }

    @Test
    void getAverageRating() {
        Restaurant restaurant=new Restaurant("Habeshawi");
        restaurant.addRating(5);
        restaurant.addRating(4);
        double actual=restaurant.getAverageRating();
        double expected= 4.5;
        Assertions.assertEquals(actual,expected);
    }
}
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Restaurant implements Serializable {
    private String name;
    private ArrayList<Integer> ratings;

    public Restaurant(String name) {
        this.name = name;
        this.ratings = new ArrayList<>();
    }

    @Override
    public String toString() {
        return  name + "   |   " + getAverageRating() ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void addRating(Integer rating) {
        ratings.add(rating);
    }

    public double getAverageRating() {
        if (ratings.size() == 0) {
            return 0;
        }
        double sum = 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }
}

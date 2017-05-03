
public class RegularMovie extends Movie {

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getCost(int daysRented) {
        if (daysRented > 2)
            return (daysRented - 2) * 1.5 + 2;
        return 2;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}

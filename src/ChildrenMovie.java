
public class ChildrenMovie extends Movie {

    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public double getCost(int daysRented) {
        if (daysRented > 3)
            return (daysRented - 3) * 1.5 + 1.5;
        return 1.5;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}

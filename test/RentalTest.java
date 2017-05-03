import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RentalTest {

    private Rental r1;
    private Movie m1;

    @Before
    public void setup() {
        m1 = new Movie("movie1", 1);
        r1 = new Rental(m1, 5);
    }

    @Test
    public void testSettingDaysRented() throws Exception {
        assertEquals(5, r1.getDaysRented());
    }

    @Test
    public void testSettingMovie() throws Exception {
        assertEquals(m1, r1.getMovie());
    }

    @Test
    public void testCost() throws Exception {
        double cost = new Rental(new Movie("movie", Movie.REGULAR), 2).getCost();
        assertEquals(2.0, cost, 0);

        cost = new Rental(new Movie("movie", Movie.NEW_RELEASE), 2).getCost();
        assertEquals(6.0, cost, 0);

        cost = new Rental(new Movie("movie", Movie.CHILDRENS), 2).getCost();
        assertEquals(1.5, cost, 0);

        cost = new Rental(new Movie("movie", Movie.REGULAR), 10).getCost();
        assertEquals(14.0, cost, 0);

        cost = new Rental(new Movie("movie", Movie.NEW_RELEASE), 10).getCost();
        assertEquals(30.0, cost, 0);

        cost = new Rental(new Movie("movie", Movie.CHILDRENS), 10).getCost();
        assertEquals(12.0, cost, 0);
    }

}

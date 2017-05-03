
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        // add header lines
        String resultStatement = "Rental Record for " + this.getName() + "\n";
        resultStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        for (Rental rental : rentals) {
            // show figures for this rental
            resultStatement += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t"
                    + String.valueOf(rental.getCost()) + "\n";
        }

        // add footer lines
        resultStatement += "Amount owed is " + String.valueOf(getTotalCost()) + "\n";
        resultStatement += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return resultStatement;
    }

    private double getTotalCost() {
        return rentals.stream().mapToDouble(rental -> ((Rental) rental).getCost()).sum();
    }

    private int getTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(rental -> ((Rental) rental).getFrequentRenterPoints()).sum();
    }

}

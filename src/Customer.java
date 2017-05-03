
import java.util.Enumeration;
import java.util.Vector;

class Customer {

    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        Enumeration enum_rentals = rentals.elements();
        String resultStatement = "Rental Record for " + this.getName() + "\n";
        resultStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        int frequentRenterPoints = 0;
        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            frequentRenterPoints += rental.getFrequentRenterPoints();
            // show figures for this rental
            resultStatement += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t"
                    + String.valueOf(rental.getCost()) + "\n";
            totalAmount += rental.getCost();
        }
        // add footer lines
        resultStatement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        resultStatement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return resultStatement;
    }

}

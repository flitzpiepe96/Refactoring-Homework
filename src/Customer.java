
import java.util.Enumeration;
import java.util.Vector;

class Customer {

    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    };

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    };

    public String getName() {
        return name;
    };

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        String resultStatement = "Rental Record for " + this.getName() + "\n";
        resultStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double amountForRental = 0;
            Rental rental = (Rental) enum_rentals.nextElement();
            // determine amounts for each line
            amountForRental = amountFor(rental);
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;
            // show figures for this rental
            resultStatement += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t"
                    + String.valueOf(amountForRental) + "\n";
            totalAmount += amountForRental;
        }
        // add footer lines
        resultStatement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        resultStatement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return resultStatement;
    }

    private double amountFor(Rental rental) {
        double result = 0;
        switch (rental.getMovie().getPriceCode()) {
        case Movie.REGULAR:
            result += 2;
            if (rental.getDaysRented() > 2)
                result += (rental.getDaysRented() - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE:
            result += rental.getDaysRented() * 3;
            break;
        case Movie.CHILDRENS:
            result += 1.5;
            if (rental.getDaysRented() > 3)
                result += (rental.getDaysRented() - 3) * 1.5;
            break;
        }
        return result;
    }

}

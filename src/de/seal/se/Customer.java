package de.seal.se;

import java.lang.*;
import java.util.*;

class Customer {
	private String name;
	private Vector rentals = new Vector();

	public Customer(String myCustomer) {
		name = myCustomer;
	};

	public void addRental(Rental newRental) {
		rentals.addElement(newRental);
	};

	public String getName() {
		return name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration enum_rentals = rentals.elements();
		String result = "Rental Record for " + this.getName() + "\n";
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount"
				+ "\n";

		while (enum_rentals.hasMoreElements()) {
			Rental rentalFromList = (Rental) enum_rentals.nextElement();
			// determine amounts for each line
			totalAmount += rentalFromList.calculateBasePrice();
			// add frequent renter points
			frequentRenterPoints += rentalFromList.getRentalPoints();
			// show figures for this rental
			result += "\t" + rentalFromList.getMovie().getTitle() + "\t" + "\t"
					+ rentalFromList.getDaysRented() + "\t"
					+ String.valueOf(rentalFromList.calculateBasePrice()) + "\n";
		}
		// add footer lines
		return createFooter(totalAmount, frequentRenterPoints, result);
	}

	private String createFooter(double totalAmount, int frequentRenterPoints,
			String result) {
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

}

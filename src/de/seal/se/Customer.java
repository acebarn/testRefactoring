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
			double thisAmount = calculateBasePrice(rentalFromList);
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((rentalFromList.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& rentalFromList.getDaysRented() > 1)
				frequentRenterPoints++;
			// show figures for this rental
			result += "\t" + rentalFromList.getMovie().getTitle() + "\t" + "\t"
					+ rentalFromList.getDaysRented() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
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

	private double calculateBasePrice(Rental someRental) {
		double result = 0;
		switch (someRental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (someRental.getDaysRented() > 2)
				result += (someRental.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += someRental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (someRental.getDaysRented() > 3)
				result += (someRental.getDaysRented() - 3) * 1.5;
			break;
		}
		return result;
	}

}

package de.seal.se;

public class RegularPrice extends Price {

	int getPriceCode() {
		return Movie.REGULAR;
	}

	@Override
	double calculateBasePrice(Rental rental) {
		double result = 2;
		if (rental.getDaysRented() > 2)
			result += (rental.getDaysRented() - 2) * 1.5;
		return result;
	}

}

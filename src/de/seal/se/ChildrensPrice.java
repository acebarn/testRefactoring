package de.seal.se;

public class ChildrensPrice extends Price {

	int getPriceCode() {
		return Movie.CHILDRENS;
	}

	@Override
	double calculateBasePrice(Rental rental) {
		double result = 1.5;
		if (rental.getDaysRented() > 3)
			result += (rental.getDaysRented() - 3) * 1.5;
		return result;
	}

}

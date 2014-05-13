package de.seal.se;

public class NewReleasePrice extends Price {

	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	@Override
	double calculateBasePrice(Rental rental) {
		return rental.getDaysRented() * 3;
	}

}

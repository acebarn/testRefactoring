package de.seal.se;

abstract class Price {
	abstract int getPriceCode();

	abstract double calculateBasePrice(Rental rental);

	public double getRentalPoints(Movie movie) {
		if (movie.getPriceCode() == Movie.NEW_RELEASE) {
			return 2;
		}
		return 1;
	} 
}

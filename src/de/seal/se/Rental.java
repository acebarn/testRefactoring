package de.seal.se;

class Rental {
	Movie movie;
	private int daysRented;

	public Rental(Movie newmovie, int newdaysRented) {
		movie = newmovie;
		daysRented = newdaysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}
	
	public double calculateBasePrice()
	{
		return movie.price.calculateBasePrice(this);
	}
}
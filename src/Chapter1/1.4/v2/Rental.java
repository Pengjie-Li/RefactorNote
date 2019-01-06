class Rental{
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie,int daysRented){
		this.movie=movie;
		this.daysRented=daysRented;
	}
	public int getDaysRented(){
		return daysRented;
	}
	public void setDaysRented(int arg){
		daysRented=arg;
	}

	public Movie getMovie(){
		return movie;
	}
	public void setMovie(Movie arg){
		movie=arg;
	}
	
	public double getCharge(){
		return movie.getCharge(daysRented);

	}
	public int getFrequentRenterPoints(){
		return movie.getFrequentRenterPoints(daysRented);


	}




}

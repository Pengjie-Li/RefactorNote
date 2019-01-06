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
		double result=0;
		switch(getMovie().getPriceCode()){
			case Movie.REGULAR:
				result+=2;
				if(getDaysRented()>2)
					result += (getDaysRented()-2)*1.5;
				break;
			case Movie.CHILDREN:
				result += 1.5;
				if(getDaysRented()>3)
					result += (getDaysRented()-3)*1.5;
				break;
			case Movie.NEW_RELEASE:
				result += getDaysRented()*3;
				break;

		}
		return result;

	}
	public int getFrequentRenterPoints(){
		int result=0;
		//add frequent renter points
		result++;
		// add bonus for a 2 day's new release rental
		if((getMovie().getPriceCode()== Movie.NEW_RELEASE)&& getDaysRented()>1)
			result++;
		return result;


	}




}

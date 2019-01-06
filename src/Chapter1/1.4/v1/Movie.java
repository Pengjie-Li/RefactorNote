public class Movie{
	public static final int CHILDREN =3;
	public static final int REGULAR =2;
	public static final int NEW_RELEASE =4;

	private String title;
	private int priceCode;

	public Movie(String titile,int priceCode){
		this.title=title;
		this.priceCode=priceCode;
	}

	public int getPriceCode(){
		return priceCode;
	}
	public void setPriceCode(int arg){
		priceCode=arg;
	}

	public String getTitle(){
		return title;
	}
	public void setTitle(String arg){
		title=arg;
	}

	public double getCharge(int daysRented ){
		double result=0;
		switch(getPriceCode()){
			case Movie.REGULAR:
				result+=2;
				if(daysRented>2)
					result += (daysRented-2)*1.5;
				break;
			case Movie.CHILDREN:
				result += 1.5;
				if(daysRented>3)
					result += (daysRented-3)*1.5;
				break;
			case Movie.NEW_RELEASE:
				result += daysRented*3;
				break;

		}
		return result;

	}

	public int getFrequentRenterPoints(int daysRented){
		int result=0;
		//add frequent renter points
		result++;
		// add bonus for a 2 day's new release rental
		if((getPriceCode()== Movie.NEW_RELEASE)&& daysRented>1)
			result++;
		return result;


	}



}

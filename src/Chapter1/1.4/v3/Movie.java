public class Movie{
	public static final int CHILDREN =3;
	public static final int REGULAR =2;
	public static final int NEW_RELEASE =4;

	private String title;
	private Price price;

	public Movie(String titile,int priceCode){
		this.title=title;
		setPriceCode(priceCode);
	}

	public int getPriceCode(){
		return price.getPriceCode();
	}
	public void setPriceCode(int arg){
		switch(arg){
			case REGULAR:
				price = new RegularPrice();
				break;
			case CHILDREN:
				price = new ChildrenPrice();
				break;
			case NEW_RELEASE:
				price = new NewReleasePrice();
				break;
			default:
				throw new IllegalArgumentException("Incorrect Price Code");


		}
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
abstract class Price{
	abstract int getPriceCode();

}
class ChildrenPrice extends Price{
	int getPriceCode(){
		return Movie.CHILDREN;
	}
}

class RegularPrice extends Price{
	int getPriceCode(){
		return Movie.REGULAR;
	}
}
class NewReleasePrice extends Price{
	int getPriceCode(){
		return Movie.NEW_RELEASE;
	}
}



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
		return price.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented){
		return price.getFrequentRenterPoints(daysRented);
	}



}
abstract class Price{
	abstract int getPriceCode();
	abstract double getCharge(int daysRented );
	public int getFrequentRenterPoints(int daysRented){
		return 1;
	
	}
}

class ChildrenPrice extends Price{
	int getPriceCode(){
		return Movie.CHILDREN;
	}
	public double getCharge(int daysRented ){
		double result=0;
		result += 1.5;
		if(daysRented>3)
			result += (daysRented-3)*1.5;


		return result;

	}


}

class RegularPrice extends Price{
	int getPriceCode(){
		return Movie.REGULAR;
	}

	public double getCharge(int daysRented ){
		double result=0;
		result+=2;
		if(daysRented>2)
			result += (daysRented-2)*1.5;

		return result;

	}

}
class NewReleasePrice extends Price{
	int getPriceCode(){
		return Movie.NEW_RELEASE;
	}
	public double getCharge(int daysRented ){
		double result=0;
		result += daysRented*3;
		return result;

	}
	public int getFrequentRenterPoints(int daysRented){
		return (daysRented>1)? 2:1;
	}
}



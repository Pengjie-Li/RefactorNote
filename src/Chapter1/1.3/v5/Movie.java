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

}

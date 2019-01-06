import java.util.*;
class Customer{
	private String name;
	private Vector rentals=new Vector();

	public Customer(String name){
		this.name=name;
	}
	public void addRental(Rental arg){
		rentals.addElement(arg);
	}
	public String getName(){
		return name;
	}

	public String statement(){

		Enumeration rentalsEnum=rentals.elements();
		String result="Rental Record for "+ getName()+"\n";
		while(rentalsEnum.hasMoreElements()){
			Rental each=(Rental) rentalsEnum.nextElement();
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+"\t" +String.valueOf(each.getCharge())+"\n";
		}

		//add footer lines
		result += "Amount owed is " + String.valueOf(getTotalAmount()) +"\n";
		result += "You earned "+ String.valueOf(getTotalFrequentRenterPoints())+ " frequent renter points";
		return result;
	}

	private double getTotalAmount(){
		double result=0;
		Enumeration rentalsEnum=rentals.elements();
		while(rentalsEnum.hasMoreElements()){
			double thisAmount=0;
			Rental each=(Rental) rentalsEnum.nextElement();

			thisAmount=each.getCharge();
			result += thisAmount;
		}
		return result;
	}
	private int getTotalFrequentRenterPoints(){

		int result=0;
		Enumeration rentalsEnum=rentals.elements();
		while(rentalsEnum.hasMoreElements()){
			Rental each=(Rental) rentalsEnum.nextElement();
			result+=each.getFrequentRenterPoints();
		}
		return result;


	}



}

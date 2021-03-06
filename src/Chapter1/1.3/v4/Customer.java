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
		double totalAmount=0;
		int frequentRenterPoints=0;
		Enumeration rentalsEnum=rentals.elements();
		String result="Rental Record for "+ getName()+"\n";
		while(rentalsEnum.hasMoreElements()){
			double thisAmount=0;
			Rental each=(Rental) rentalsEnum.nextElement();

			//determine amounts for each line
			//thisAmount=amountFor(each);
			thisAmount=each.getCharge();
			//frequentRenterPoints+=getFrequentRenterPoints(each);
			frequentRenterPoints+=each.getFrequentRenterPoints();

			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+"\t" +String.valueOf(thisAmount)+"\n";
			totalAmount += thisAmount;


		}

		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) +"\n";
		result += "You earned "+ String.valueOf(frequentRenterPoints)+ " frequent renter points";
		return result;
	}

	private double amountFor(Rental aRental){
		return aRental.getCharge();
	}
	private int getFrequentRenterPoints(Rental aRental){
		return aRental.getFrequentRenterPoints();


	}



}

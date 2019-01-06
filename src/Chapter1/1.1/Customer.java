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
			switch(each.getMovie().getPriceCode()){
				case Movie.REGULAR:
					thisAmount+=2;
					if(each.getDaysRented()>2)
						thisAmount += (each.getDaysRented()-2)*1.5;
					break;
				case Movie.CHILDREN:
					thisAmount += 1.5;
					if(each.getDaysRented()>3)
						thisAmount += (each.getDaysRented()-3)*1.5;
					break;
				case Movie.NEW_RELEASE:
					thisAmount += each.getDaysRented()*3;
					break;

			}

			//add frequent renter points
			frequentRenterPoints++;
			// add bonus for a 2 day's new release rental
			if((each.getMovie().getPriceCode()== Movie.NEW_RELEASE)&& each.getDaysRented()>1)
				frequentRenterPoints++;
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+"\t" +String.valueOf(thisAmount)+"\n";
			totalAmount += thisAmount;


		}

		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) +"\n";
		result += "You earned "+ String.valueOf(frequentRenterPoints)+ " frequent renter points";
		return result;
	}
}

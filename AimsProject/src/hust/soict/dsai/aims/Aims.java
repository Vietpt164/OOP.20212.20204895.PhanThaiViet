package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
	
	public static void main(String[] args) {
		
		//Create a new cart
		Cart anOrder = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Aller", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		//Print total cost of the items in the cart
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());

		//Test the removeDigitalVideoDisc(DigitalVideoDisc disc) method 
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("6 Underground",
				"Action", "Michael Bay", 128, 30.50f);
		anOrder.addDigitalVideoDisc(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 24.95f);
		anOrder.addDigitalVideoDisc(dvd5);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd6);
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Fifty Shades of Grey",
				"Romance", "Sam Taylor-Johnson", 125, 16.04f);
		anOrder.addDigitalVideoDisc(dvd7);
				
		System.out.println(anOrder.removeDigitalVideoDisc(dvd2));
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
		
		//Test overloading methods
		DigitalVideoDisc[] dvdList1 = {new DigitalVideoDisc("On Your Wedding Day", "Romance", 12.25f), 
				new DigitalVideoDisc("Spider-Man: Homecoming", "Superhero Film", 35.49f),
				new DigitalVideoDisc("Fast and Furious", "Action", 22.50f)
		};	
		anOrder.addDigitalVideoDisc1(dvdList1);
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
		anOrder.addDigitalVideoDisc(dvd6, dvd7);
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
	
	}

}

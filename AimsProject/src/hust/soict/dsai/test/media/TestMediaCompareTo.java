package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestMediaCompareTo {

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Aller", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		
		
		java.util.Collection collection = new java.util.ArrayList();
		
		// Add the DVD objects to the ArrayList
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		
		// Iterate through the ArrayList and output their titles (unsorted order)
		java.util.Iterator iterator = collection.iterator();
		
		System.out.println("---------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		// Sort the collection of DVDs based on the compareTo method
		java.util.Collections.sort((java.util.List<DigitalVideoDisc>)collection);
		
		// Iterate through the ArrayList and output their titles in sorted order
		iterator = collection.iterator();
		
		System.out.println("---------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		System.out.println("---------------------------------");
		
		
		
	}

}

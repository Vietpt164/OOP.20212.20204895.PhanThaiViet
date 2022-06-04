package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[100];
	private int numItems = 0;
	public DigitalVideoDisc[] getItemsInStore() {
		return itemsInStore;
	}
	public int getNumItems() {
		return numItems;
	}


	public void print() {
		System.out.println("\n***********************STORE***********************");
		System.out.println("Items In Store:");
		for (int i = 0; i < numItems; i++) {	
			System.out.println(itemsInStore[i]);
		}
		System.out.println("***************************************************\n");
	}
	
	public void addDVD(DigitalVideoDisc disc) {
		itemsInStore[numItems] = disc;
		numItems++;
		System.out.println("The disc named " + disc.getTitle() + " has been added to store");
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		int count = 0;
		for (int i = 0; i < numItems; i++) {
            if (itemsInStore[i].getTitle() == disc.getTitle()) {
                for (int j = i; j < numItems; j++) {
                    itemsInStore[j] = itemsInStore[j+1];
                }
                i--;
                numItems--;
                count++;
            }
        }
		if (count == 1) {
		System.out.println("The dvd named " + disc.getTitle() + 
				" has been removed from store");
		} else {
			System.out.println("There is no dvd named " + disc.getTitle() + " in the store");
		}
	}
	


	

}

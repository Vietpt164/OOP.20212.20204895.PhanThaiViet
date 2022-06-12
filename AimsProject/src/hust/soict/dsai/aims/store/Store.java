package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;


public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}


	public void print() {
		System.out.println("\n***********************STORE***********************");
		System.out.println("Items In Store:");
		for (int i = 0; i < itemsInStore.size(); i++) {	
			System.out.println(itemsInStore.get(i));
		}
		System.out.println("***************************************************\n");
	}
	
	
	
	public void addMedia(Media media) {
		if (itemsInStore.contains(media)) {
			System.out.println("The media \"" + media.getTitle() + "\" has already in the store");
		} else {
			itemsInStore.add(media);
			System.out.println("The media \"" + media.getTitle() + "\" has been added to the store");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store");
		} else {
			System.out.println("This media \"" + media.getTitle() + "\" is not in the store");
		}
	}
	


	

}

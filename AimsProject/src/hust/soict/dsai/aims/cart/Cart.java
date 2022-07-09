package hust.soict.dsai.aims.cart;
import java.util.Random;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	//attributes
	public static final int MAX_NUMBERS_ORDER = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}



	public void addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDER) {
			if (itemsOrdered.contains(media)) {
				System.out.println("The media is already in the cart");
			} else {
				itemsOrdered.add(media);
				System.out.println("The media \"" + media.getTitle() + "\" has been added to the cart");
			}
		} else {
			throw new LimitExceededException("ERROR: The number of media has reached cart's limit");
		}
	}
	
	
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("The media \"" + media.getTitle() + "\" has been removed from the cart");
		} else {
			System.out.println("This media \"" + media.getTitle() + "\" is not in the cart");
		}
		
	}
	
	public float totalCost() {
		float totalCost = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			totalCost += itemsOrdered.get(i).getCost();
		}
		return totalCost;
	}
	
	public void sortByTitleCost() {
		java.util.Collections.sort(itemsOrdered,Media.COMPARE_BY_TITLE_COST);
		print(itemsOrdered);
	}
	
	public void sortByCostTitle() {
		java.util.Collections.sort(itemsOrdered,Media.COMPARE_BY_COST_TITLE);
		print(itemsOrdered);
	} 

	
	public void searchById(int id) {
		int res = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				System.out.println(itemsOrdered.get(i));
				res += 1;
				break;
			}		
		}
		if (res == 0) {
			System.out.println("No DVD is found!");
		}
	}
	
	public void print() {
		//Print the list of items. The order of medias should be alphabetical, then by cost(decreasing)
		java.util.Collections.sort(itemsOrdered,Media.COMPARE_BY_TITLE_COST);
		print(itemsOrdered);
	}
	
	private void print(ObservableList<Media> itemsOrdered2) {
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered2.size(); i++) {
			System.out.println((i+1) + ". " + itemsOrdered2.get(i));
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************\n");
	}
	
	public void searchByTitle(String title) {
		int res = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle() == title) {
				System.out.println(itemsOrdered.get(i));
				res += 1;
				break;
			}		
		}
		if (res == 0) {
			System.out.println("No DVD is found!");
		}
	} 
	
	public void empty() {
		itemsOrdered.clear();
	} 
	
	public Media getALuckyItem() {
		Random rand = new Random();
		int luckyNumber = rand.nextInt(itemsOrdered.size());
		Media luckyItem = itemsOrdered.get(luckyNumber);
		return luckyItem;
	}

	
} 

package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Random;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.utils.MediaUtils;

public class Cart {
	//attributes
	public static final int MAX_NUMBERS_ORDER = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private float discount;
	
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}



	public void addMedia(Media media) {
		if (itemsOrdered.size() < 20) {
			itemsOrdered.add(media);
			System.out.println("The media \"" + media.getTitle() + "\" has been added to the cart");
		} else {
			System.out.println("The cart is already full");
		}
	}
	
	
	
	public void removeMedia(Media media) {
		int numItemsRemoved = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle() == media.getTitle()) {
                itemsOrdered.remove(i);
                numItemsRemoved++;
            }
        }
		if (numItemsRemoved == 0) {
			System.out.println("This media \"" + media.getTitle() + "\" is not in the cart");
		}
		System.out.println("Number of media named \"" + media.getTitle() + 
				"\" has been removed from cart : " + numItemsRemoved);
		
	}
	
	public float totalCost() {
		float totalCost = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			totalCost += itemsOrdered.get(i).getCost();
		}
		return totalCost - discount;
	}
	
	public void sortByCost() {
		ArrayList<Media> sortedByCost = MediaUtils.sortByCost(this.itemsOrdered);
		print(sortedByCost);
	}
	
	public void sortByTitle() {
		ArrayList<Media> sortedByTitle = MediaUtils.sortByTitle(this.itemsOrdered);
		print(sortedByTitle);
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
		ArrayList<Media> print_items = MediaUtils.sortByTitle(itemsOrdered);
		print(print_items);
	}
	
	private void print(ArrayList<Media> mediaList) {
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < mediaList.size(); i++) {
			System.out.println((i+1) + ". " + mediaList.get(i));
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
		discount = luckyItem.getCost();
		return luckyItem;
	}

	
} 

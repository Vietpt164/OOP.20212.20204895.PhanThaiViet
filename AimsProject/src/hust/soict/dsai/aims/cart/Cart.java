package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Cart {
	//attributes
	public static final int MAX_NUMBERS_ORDER = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDER];
	private int qtyOrdered = 0;
	
	
	//methods
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public DigitalVideoDisc[] getItemsOrdered() {
		return itemsOrdered;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered > 19) {
			System.out.println("The cart is already full");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc named " + disc.getTitle() + " has been added to cart");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		int num_dvd_added = 0;
		while (qtyOrdered <= 20 && num_dvd_added < dvdList.length) {
			itemsOrdered[qtyOrdered] = dvdList[num_dvd_added];
			qtyOrdered++;
			num_dvd_added++;
		}
		System.out.println("Number of dvds added to cart: " + num_dvd_added);
	}
	
	public void addDigitalVideoDisc1(DigitalVideoDisc... dvds) {
		int num_dvd_added = 0;
		for (int i = 0; i < dvds.length; i++) {
			this.addDigitalVideoDisc(dvds[i]);
			num_dvd_added++;
		}
		System.out.println("Number of dvds added to cart: " + num_dvd_added);
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		this.addDigitalVideoDisc(dvd1);
		this.addDigitalVideoDisc(dvd2);
	}
	
	public String removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int num_disc_deleted = 0;
		for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle() == disc.getTitle()) {
                for (int j = i; j < qtyOrdered; j++) {
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                i--;
                num_disc_deleted++;
                qtyOrdered--;
            }
        }
		return num_disc_deleted + " dvds named " + disc.getTitle() + 
				" has been removed from cart";
		
	}
	
	public float totalCost() {
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			totalCost += itemsOrdered[i].getCost();
		}
		return totalCost;
	}
	
	public void sortByCost() {
		DigitalVideoDisc[] sortedByCost = DVDUtils.sortByCost(this.itemsOrdered);
		print(sortedByCost);
	}
	
	public void sortByTitle() {
		DigitalVideoDisc[] sortedByTitle = DVDUtils.sortByTitle(this.itemsOrdered);
		print(sortedByTitle);
	}
	
	public void searchById(int id) {
		int res = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.println(itemsOrdered[i]);
				res += 1;
				break;
			}		
		}
		if (res == 0) {
			System.out.println("No DVD is found!");
		}
	}
	
	public void print() {
		DigitalVideoDisc[] print_items = itemsOrdered.clone();
		for (int i = 1; i < Cart.MAX_NUMBERS_ORDER && print_items[i] != null; ++i) {
            DigitalVideoDisc key = print_items[i];
            int j = i - 1;
            //Sort by title, then by cost(desc), then by length(desc)
            while ( j >= 0 
            		&& 
            		( DVDUtils.compareByTitle(print_items[j], key) > 0
            		|| ( DVDUtils.compareByTitle(print_items[j], key) == 0 && DVDUtils.compareByCost(print_items[j], key) == "smaller cost")
            		|| ( DVDUtils.compareByTitle(print_items[j], key) == 0 && DVDUtils.compareByCost(print_items[j], key) == "equal cost" && print_items[i].getLength() < key.getLength() ) 
            )) {
            	print_items[j + 1] = print_items[j];
                j = j - 1;
            }
            print_items[j + 1] = key;
        }
		print(print_items);
	}
	
	private void print(DigitalVideoDisc[] dvdList) {
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i+1) + ". " + dvdList[i]);
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************\n");
	}
	
	public void searchByTitle(String title) {
		int res = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle() == title) {
				System.out.println(itemsOrdered[i].toString());
				res += 1;
				break;
			}		
		}
		if (res == 0) {
			System.out.println("No DVD is found!");
		}
	} 
	
	public void empty() {
		for (int i = 0; i < qtyOrdered; i++) {
			itemsOrdered[i] = null;
			qtyOrdered = 0;
		}
	}

	
}

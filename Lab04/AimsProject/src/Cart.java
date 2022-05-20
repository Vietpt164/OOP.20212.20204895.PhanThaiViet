
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
			System.out.println("The disc named " + disc.getTitle() + " has been added");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		int num_dvd_added = 0;
		while (qtyOrdered <= 20 && num_dvd_added < dvdList.length) {
			itemsOrdered[qtyOrdered] = dvdList[num_dvd_added];
			qtyOrdered++;
			num_dvd_added++;
		}
		System.out.println("Number of dvds added: " + num_dvd_added);
	}
	
	public void addDigitalVideoDisc1(DigitalVideoDisc... dvds) {
		int num_dvd_added = 0;
		for (int i = 0; i < dvds.length; i++) {
			this.addDigitalVideoDisc(dvds[i]);
			num_dvd_added++;
		}
		System.out.println("Number of dvds added: " + num_dvd_added);
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
				" has been removed";
		
	}
	
	public float totalCost() {
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			totalCost += itemsOrdered[i].getCost();
		}
		return totalCost;
	}
	

	
}

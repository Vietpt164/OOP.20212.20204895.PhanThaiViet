package hust.soict.dsai.aims.utils;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class DVDUtils {
	public static String compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (dvd1.getCost() > dvd2.getCost()) {
			return "greater cost";
		} else if (dvd1.getCost() == dvd2.getCost()) {
			return "equal cost";
		} else {
			return "smaller cost";
		}
	}
	
	/*compareByTitle method returns the value as follows: 
	1. if (string1 > string2) it returns a positive value.
	2. if both the strings are equal lexicographically
		i.e.(string1 == string2) it returns 0.
	3. if (string1 < string2) it returns a negative value.*/
	public static int compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		return dvd1.getTitle().compareTo(dvd2.getTitle());
	}
	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvdList) {
        for (int i = 1; i < Cart.MAX_NUMBERS_ORDER && dvdList[i] != null; ++i) {
            DigitalVideoDisc key = dvdList[i];
            int j = i - 1;
 
            /* Move elements of dvdList[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && 
            		( DVDUtils.compareByCost(dvdList[j], key) == "smaller cost"
            		|| (DVDUtils.compareByCost(dvdList[j], key) == "equal cost" && DVDUtils.compareByTitle(dvdList[j], key) > 0))) {
                dvdList[j + 1] = dvdList[j];
                j = j - 1;
            }
            dvdList[j + 1] = key;
        }
        return dvdList;
	}
	
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvdList) {
        for (int i = 1; i < Cart.MAX_NUMBERS_ORDER && dvdList[i] != null; ++i) {
            DigitalVideoDisc key = dvdList[i];
            int j = i - 1;
 
            /* Move elements of dvdList[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && 
            		( DVDUtils.compareByTitle(dvdList[j], key) > 0
            		|| (DVDUtils.compareByTitle(dvdList[j], key) == 0 && DVDUtils.compareByCost(dvdList[j], key) == "smaller cost"))) {
                dvdList[j + 1] = dvdList[j];
                j = j - 1;
            }
            dvdList[j + 1] = key;
        }
        return dvdList;
	}
}



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
		int n = dvdList.length;
        for (int i = 1; i < n; ++i) {
            DigitalVideoDisc key = dvdList[i];
            int j = i - 1;
 
            /* Move elements of dvdList[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && DVDUtils.compareByCost(dvdList[j], key) == "greater cost") {
                dvdList[j + 1] = dvdList[j];
                j = j - 1;
            }
            dvdList[j + 1] = key;
        }
        return dvdList;
	}
	
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvdList) {
		int n = dvdList.length;
        for (int i = 1; i < n; ++i) {
            DigitalVideoDisc key = dvdList[i];
            int j = i - 1;
 
            /* Move elements of dvdList[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && DVDUtils.compareByTitle(dvdList[j], key) > 0) {
                dvdList[j + 1] = dvdList[j];
                j = j - 1;
            }
            dvdList[j + 1] = key;
        }
        return dvdList;
	}
}

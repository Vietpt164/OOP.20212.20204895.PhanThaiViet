package hust.soict.dsai.aims.utils;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;

public class MediaUtils {
	public static String compareByCost(Media media1, Media media2) {
		if (media1.getCost() > media2.getCost()) {
			return "greater cost";
		} else if (media1.getCost() == media2.getCost()) {
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
	public static int compareByTitle(Media media1, Media media2) {
		return media1.getTitle().compareTo(media2.getTitle());
	}
	
	public static ArrayList<Media> sortByCost(ArrayList<Media> mediaList) {
        for (int i = 1; i < mediaList.size(); ++i) {
            Media key = mediaList.get(i);
            int j = i - 1;
 
            /* Move elements of mediaList[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && 
            		( MediaUtils.compareByCost(mediaList.get(j), key) == "smaller cost"
            		|| (MediaUtils.compareByCost(mediaList.get(j), key) == "equal cost" && MediaUtils.compareByTitle(mediaList.get(j), key) > 0))) {
                mediaList.set(j+1, mediaList.get(j));
                j = j - 1;
            }
            mediaList.set(j+1, key);
        }
        return mediaList;
	}
	
	public static ArrayList<Media> sortByTitle(ArrayList<Media> mediaList) {
        for (int i = 1; i < mediaList.size(); ++i) {
            Media key = mediaList.get(i);
            int j = i - 1;
 
            /* Move elements of mediaList[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && 
            		( MediaUtils.compareByTitle(mediaList.get(j), key) > 0
            		|| (MediaUtils.compareByTitle(mediaList.get(j), key) == 0 && MediaUtils.compareByCost(mediaList.get(j), key) == "smaller cost"))) {
                mediaList.set(j+1, mediaList.get(j));
                j = j - 1;
            }
            mediaList.set(j+1, key);
        }
        return mediaList;
	}
	

	
}

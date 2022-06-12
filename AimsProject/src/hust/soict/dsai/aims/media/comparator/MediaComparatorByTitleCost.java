package hust.soict.dsai.aims.media.comparator;

import java.util.Comparator;
import hust.soict.dsai.aims.media.*;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	@Override
	public int compare(Media media1, Media media2) {
		int TitleCompare = media1.getTitle().compareTo(media2.getTitle());
 
        int CostCompare = (media1.getCost() - media2.getCost() == 0) ? 0 : (int)Math.floor(media1.getCost() - media2.getCost());
 
            // 2nd level comparison
            return (TitleCompare == 0) ? CostCompare
                                      : TitleCompare; 
		
	}
	


}

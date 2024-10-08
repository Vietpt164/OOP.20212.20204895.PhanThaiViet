package hust.soict.dsai.test.utils;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.MediaUtils;

public class DVDTest {

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		
		System.out.println(MediaUtils.compareByCost(dvd1, dvd2));
		System.out.println(MediaUtils.compareByTitle(dvd5, dvd3));
		
/*		DigitalVideoDisc[] sorted = MediaUtils.sortByCost(new DigitalVideoDisc[] {dvd1, dvd2, dvd3, dvd4, dvd5});
		System.out.println("sort by cost: ");
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getCost());
		}
		
		sorted = MediaUtils.sortByTitle(new DigitalVideoDisc[] {dvd1, dvd2, dvd3, dvd4, dvd5});
		System.out.println("sort by title: ");
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getTitle());
		} */
	}
}

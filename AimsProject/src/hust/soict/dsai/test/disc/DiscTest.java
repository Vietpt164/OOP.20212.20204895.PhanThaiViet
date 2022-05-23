package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class DiscTest {

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Aller", 87, 19.95f);
		System.out.println(dvd1.isMatch("The Lion King"));
		System.out.println(dvd1.isMatch("The Chef"));
		System.out.println(dvd1.isMatch("KiNg JaMeS"));
		System.out.println(dvd1.isMatch("fsdif"));

	}

}

//Create a wrapper class that contains references of DVD, 
//we can swap DVDs by swapping references of the wrapper class.
class DVDWrapper {
	DigitalVideoDisc d;
	
	DVDWrapper(DigitalVideoDisc d) {this.d = d;}
}

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", "Action", 25.50f);
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", "Animation", 18.05f);
		
		/*//swap 2 dvds using wrapper class
		DVDWrapper dw1 = new DVDWrapper(jungleDVD);
		DVDWrapper dw2 = new DVDWrapper(cinderellaDVD);
		swap(dw1, dw2);
		System.out.println("jungle dvd category: " + dw1.d.getCategory());
		System.out.println("cinderella dvd category: " + dw2.d.getCategory());

		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle()); */
		
		//swap title of 2 dvds
		swapTitle(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
	}
	
	public static void swap(DVDWrapper dvdw1, DVDWrapper dvdw2) {
		DigitalVideoDisc tmp = dvdw1.d;
		dvdw1.d = dvdw2.d;
		dvdw2.d = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle	 = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
	//method to swap title of 2 dvds, we can swap 2 dvds by swapping all their members
	public static void swapTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String temp = dvd1.getTitle();
		dvd1.setTitle(dvd2.getTitle());
		dvd2.setTitle(temp);
	}

}

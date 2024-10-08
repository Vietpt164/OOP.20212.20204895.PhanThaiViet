package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {


	public static void main(String[] args) {
		
		
		Cart cart = new Cart();
		Store Store1 = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Aller", 87, 19.95f);
		Store1.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		Store1.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		Store1.addMedia(dvd3);
		
		
		
		Scanner keyboard  = new Scanner(System.in);
		int option1, option2,option3,option4,option5,option6;
		do {
			showMenu();
			String strOption1 = keyboard.nextLine();
			option1 = Integer.parseInt(strOption1);
			if (option1 == 0) { 	// Exit
				System.out.println("Exiting...");
				keyboard.close();
				break;
			} else if (option1 == 1) {		// View store
				do {
					Store1.print();
					storeMenu();
					String strOption2 = keyboard.nextLine();
					option2 = Integer.parseInt(strOption2);
					if (option2 == 0) {		//Back
						//showMenu();
						break;
					} else if (option2 == 1) {		// See a Media's details
						System.out.println("Enter the title of the Media: ");
						String title = keyboard.nextLine();
						int i;
						for (i = 0; i < Store1.getItemsInStore().size(); i++) {
							if (Store1.getItemsInStore().get(i).getTitle().compareTo(title) == 0) {
								System.out.println(Store1.getItemsInStore().get(i));
								break;
							}
						}
						//System.out.println(i + "----" + (Store1.getNumItems() - 1 ));
						if (i == Store1.getItemsInStore().size()) {
							System.out.println("No Media is found!");
							
						} else {
							System.out.println("Do you want to add this Media to cart? Type \"yes\" to add");
							String addMedia = keyboard.nextLine();
							if (addMedia.compareToIgnoreCase("yes") == 0) {
								cart.addMedia(Store1.getItemsInStore().get(i));	
							}
						}
				
					} else if (option2 == 2) {		//Add a Media to cart
						Store1.print();
						System.out.println("Enter the title of the Media: ");
						String title = keyboard.nextLine();
						for (int i = 0; i < Store1.getItemsInStore().size(); i++) {
							if (Store1.getItemsInStore().get(i).getTitle().compareTo(title) == 0) {
								cart.addMedia(Store1.getItemsInStore().get(i));
								break;
							}
						}
						System.out.println("Number of Medias in the current cart:" + cart.getItemsOrdered().size());
					} else if (option2 == 3) {		// See current cart
						
						//cartMenu();
						do {
							cartMenu();
							String strOption4 = keyboard.nextLine();
							option4 = Integer.parseInt(strOption4);
							if (option4 == 0) {
								break;
							} else if (option4 == 1) {	// Filter Medias in cart
								do {
									System.out.println("Options: ");
									System.out.println("--------------------------------");
									System.out.println("1. Filter by id");
									System.out.println("2. Filter by title");
									System.out.println("0. Back");
									System.out.println("--------------------------------");
									System.out.println("Please choose a number: 0-1-2");
									String strOption5 = keyboard.nextLine();
									option5 = Integer.parseInt(strOption5);
									if (option5 == 0) {
										break;
									} else if (option5 == 1) {
										System.out.println("Enter Media's id: ");
										String strId = keyboard.nextLine();
										int id = Integer.parseInt(strId);
										cart.searchById(id);
									} else if (option5 == 2) {
										System.out.println("Enter Media's title: ");
										String title = keyboard.nextLine();
										cart.searchByTitle(title);
									}
								} while(true);
								
							} else if (option4 == 2) { // Sort Medias in cart
								do {
									System.out.println("Options: ");
									System.out.println("--------------------------------");
									System.out.println("1. Sort by title");
									System.out.println("2. Sort by cost");
									System.out.println("0. Back");
									System.out.println("--------------------------------");
									System.out.println("Please choose a number: 0-1-2");
									String strOption6 = keyboard.nextLine();
									option6 = Integer.parseInt(strOption6);
									if (option6 == 0) {
										break;
									} else if (option6 == 1) { 
										cart.sortByTitleCost();
									} else if (option6 == 2) {
										cart.sortByCostTitle();
									}
									
								} while (true);
									
							} else if (option4 == 4) { //Place order
								if (cart.getItemsOrdered().size() < 5) {
									System.out.println("An order is created.");
								} else {
									System.out.println("You will receive a random, free lucky item below");
									Media luckyItem = cart.getALuckyItem();
									System.out.println(luckyItem);
									cart.addMedia(luckyItem);
								}
								cart.print();
								cart.empty();
							} else if (option4 == 5) { // Play a media
								System.out.println("Choose media's id:");
								String strId = keyboard.nextLine();
								int id = Integer.parseInt(strId), count = 0;
								for (Media media : cart.getItemsOrdered()) {
									if (media.getId() == id && media instanceof Playable && ((Disc)media).getLength() > 0) {
										try {
											((Playable)media).play();
										} catch (PlayerException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										count += 1;
										break;
									}
								}
								if (count == 0) {
									System.out.println("This media cannot be played");
								}
							}
						
						} while(true); 
					} else if (option2 == 4) { // Play a media
						System.out.println("Choose media's id:");
						String strId = keyboard.nextLine();
						int id = Integer.parseInt(strId), count = 0;
						for (Media media : Store1.getItemsInStore()) {
							if (media.getId() == id && media instanceof Playable && ((Disc)media).getLength() > 0) {
								try {
									((Playable)media).play();
								} catch (PlayerException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								count += 1;
								break;
							}
						}
						if (count == 0) {
							System.out.println("This media cannot be played");
						}
					}
					
				} while (true);		
				
				
				
			} else if (option1 == 2) {		//Update store
				do {
					System.out.println("Options: ");
					System.out.println("--------------------------------");
					System.out.println("1. Add a Media to store");
					System.out.println("2. Remove a Media from store");
					System.out.println("0. Back");
					System.out.println("--------------------------------");
					System.out.println("Please choose a number: 0-1-2");
					String strOption3 = keyboard.nextLine();
					option3 = Integer.parseInt(strOption3);
					if (option3 == 0) {
						break;
					} else if (option3 == 1) {
						System.out.println("Enter Media's title: ");
						String title = keyboard.nextLine();
						Store1.addMedia(new DigitalVideoDisc(title));

					} else if (option3 == 2) {
						System.out.println("Enter DVD's title: ");
						String title = keyboard.nextLine();
						Store1.removeMedia(new DigitalVideoDisc(title));

					}
				} while(true);
				
			} else if (option1 == 3) {		// See current cart
				do {
					cartMenu();
					String strOption4 = keyboard.nextLine();
					option4 = Integer.parseInt(strOption4);
					if (option4 == 0) {
						break;
					} else if (option4 == 1) {	// Filter Medias in cart
						do {
							System.out.println("Options: ");
							System.out.println("--------------------------------");
							System.out.println("1. Filter by id");
							System.out.println("2. Filter by title");
							System.out.println("0. Back");
							System.out.println("--------------------------------");
							System.out.println("Please choose a number: 0-1-2");
							String strOption5 = keyboard.nextLine();
							option5 = Integer.parseInt(strOption5);
							if (option5 == 0) {
								break;
							} else if (option5 == 1) {
								System.out.println("Enter Media's id: ");
								String strId = keyboard.nextLine();
								int id = Integer.parseInt(strId);
								cart.searchById(id);
							} else if (option5 == 2) {
								System.out.println("Enter Media's title: ");
								String title = keyboard.nextLine();
								cart.searchByTitle(title);
							}
						} while(true);
						
					} else if (option4 == 2) { // Sort Medias in cart
						do {
							System.out.println("Options: ");
							System.out.println("--------------------------------");
							System.out.println("1. Sort by title");
							System.out.println("2. Sort by cost");
							System.out.println("0. Back");
							System.out.println("--------------------------------");
							System.out.println("Please choose a number: 0-1-2");
							String strOption6 = keyboard.nextLine();
							option6 = Integer.parseInt(strOption6);
							if (option6 == 0) {
								break;
							} else if (option6 == 1) { 
								cart.sortByTitleCost();
							} else if (option6 == 2) {
								cart.sortByCostTitle();
							}
							
						} while (true);
							
					} else if (option4 == 3) {	// Remove Media from cart
						System.out.println("Enter DVD's title: ");
						String title = keyboard.nextLine();
						cart.removeMedia(new DigitalVideoDisc(title));

					} else if (option4 == 4) { //Place order
						if (cart.getItemsOrdered().size() < 5) {
							System.out.println("An order is created.");
						} else {
							System.out.println("You will receive a random, free lucky item below");
							Media luckyItem = cart.getALuckyItem();
							System.out.println(luckyItem);
							cart.addMedia(luckyItem);
						}
						cart.print();
						cart.empty();
					} else if (option4 == 5) { // Play a media
						System.out.println("Choose media's id:");
						String strId = keyboard.nextLine();
						int id = Integer.parseInt(strId), count = 0;
						for (Media media : cart.getItemsOrdered()) {
							if (media.getId() == id && media instanceof Playable && ((Disc)media).getLength() > 0) {
								try {
									((Playable)media).play();
								} catch (PlayerException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								count += 1;
								break;
							}
						}
						if (count == 0) {
							System.out.println("This media cannot be played");
						}
					}
				
				} while(true);
			
			}
		
		} while (true);
			
		
		
		Thread threadD = new Thread(new MemoryDaemon());
		threadD.setDaemon(true);
		threadD.run();

		
		


		
		
		
		
	
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a Media�s details");
		System.out.println("2. Add a Media to cart");
		System.out.println("3. See current cart");
		System.out.println("4. Play a media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter Medias in cart");
		System.out.println("2. Sort Medias in cart");
		System.out.println("3. Remove Media from cart");
		System.out.println("4. Place order");
		System.out.println("5. Play a media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	



	
	
	

}

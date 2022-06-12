package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		Book book1 = new Book("A Promised Land", "Documentary", 16.99f, 
				"He would chuck, he #%would, as     much as he$ could, and chuck! as, much wood:");
		//book1.processContent();
		System.out.println(book1);

	}

}

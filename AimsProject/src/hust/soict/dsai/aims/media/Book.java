package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
	private ArrayList<String> author = new ArrayList<String>();
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public void addAuthor(String authorName) {
		if (author.contains(authorName)) {
			author.add(authorName);
			System.out.println("The author " + authorName + " has been added");
		} else {
			System.out.println("Author is already in author arraylist");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (author.contains(authorName)) {
			author.remove(authorName);
		} else {
			System.out.println("There is not in author array list");
		}
	}
	
	
	
	
	
	
	

}

package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
	private ArrayList<String> author = new ArrayList<String>();
	public ArrayList<String> getAuthor() {
		return author;
	}

	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Book(String title, String category) {
		super(title, category);
	}

	public Book(String title) {
		super(title);
	}
	
	

	public void addAuthor(String authorName) {
		if (author.contains(authorName) == false) {
			author.add(authorName);
			System.out.println("The author " + authorName + " has been added");
		} else {
			System.out.println("Author is already in author arraylist");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (author.contains(authorName)) {
			author.remove(authorName);
			System.out.println("The author " + authorName + " has been removed");
		} else {
			System.out.println("This author is not in author array list");
		}
	}
	
	public String toString() {
		return "Book - " + title + " - " + category + " - " 
				 + ": " + cost + "$";
	}
	
	
	
	
	
	
	
	

}

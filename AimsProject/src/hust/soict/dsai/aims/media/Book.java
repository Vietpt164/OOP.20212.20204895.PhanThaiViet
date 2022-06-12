package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
	private ArrayList<String> author = new ArrayList<String>();
	private String content;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String, Integer> wordFrequency;
	
	
	public void setContent(String content) {
		this.content = content;
		processContent();
	}


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
	
	public Book(String title, String category, float cost, String content) {
		super(title, category, cost);
		this.content = content;
		processContent();
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
		String tokenList = "";
		for (String t : contentTokens) {
			tokenList += t + ", " ;
		}
		tokenList = tokenList.substring(0, tokenList.length() -2);
		
		String tokenFreq = "";
		for (Map.Entry<String, Integer> m : wordFrequency.entrySet()) {
               tokenFreq += m.getKey() + "=" + m.getValue() + ", ";
    	}
		tokenFreq = tokenFreq.substring(0, tokenFreq.length() -2);
		
		return "Book " + id + " - " + title + " - " + category + ": " + cost + "$" +
			"\nContent length: " + contentTokens.size() +
			"\nToken list: {" + tokenList + "}" +
			"\nWord frequency : {" + tokenFreq + "}"
		;
	}
	
	
	public void processContent() {
		String[] words = content.split("[\\p{Punct}\\s]+");
		for (int i = 0; i < words.length; i++) {
			contentTokens.add(words[i]);
		}
		
		contentTokens.sort(null);
		
		wordFrequency = new TreeMap<String, Integer>();
		for (String t : contentTokens) {
            Integer c = wordFrequency.get(t);
            wordFrequency.put(t, (c == null) ? 1 : c + 1);
        }
	}
	
	
	
	
	
	
	
	

}

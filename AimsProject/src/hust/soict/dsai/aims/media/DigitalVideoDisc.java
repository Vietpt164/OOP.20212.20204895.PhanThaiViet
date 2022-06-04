package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbMedias++;
		this.id = nbMedias;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMedias++;
		this.id = nbMedias;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbMedias++;
		this.id = nbMedias;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbMedias++;
		this.id = nbMedias;
	}
	
	public String toString() {
		return "DVD - " + title + " - " + category + " - " 
				+ director + " - " + length + ": " + cost + "$";
	}

	public boolean isMatch(String title) {
		String[] tokens = title.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			if (this.title.toLowerCase().contains(tokens[i].toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	
	
}

package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

	public void setTitle(String title) {
		this.title = title;
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(category, category, cost);
	} 
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);

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
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		}

	
	
}

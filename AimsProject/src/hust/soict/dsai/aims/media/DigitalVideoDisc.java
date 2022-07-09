package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.Playable;
import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

	public void setTitle(String title) {
		this.title = title;
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	} 
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, cost);
		this.length = length;

	}
	
	public String toString() {
		return "DVD " + id + " - " + title + " - " + category + " - " 
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
	
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
		
	}

	
	
}

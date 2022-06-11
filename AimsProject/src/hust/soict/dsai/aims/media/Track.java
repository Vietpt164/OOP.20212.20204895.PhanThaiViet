package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.Playable;

public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
		}

	public String toString() {
		return "Track - " + title + " - " + length;
	}
	
}

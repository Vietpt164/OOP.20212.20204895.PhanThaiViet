package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.Playable;

public class Track implements Playable, Comparable<Track> {
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
	
	public boolean equals(Object o) {
		return title.equals(((Track)o).getTitle()) && length == ((Track)o).getLength();
	}
	
	public int compareTo(Track track) {
		return title.compareTo(track.getTitle());
	}
	
	
}

package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public int getLength() {
		int cdLength = 0;
		for (int i = 0; i < tracks.size(); i++) {
			cdLength += tracks.get(i).getLength();
		}
		return cdLength;
	}
	

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}

	public CompactDisc(String title, String category) {
		super(title, category);
	}

	public CompactDisc(String title) {
		super(title);
	}

	public CompactDisc(String title, String category, float cost, String artist) {
		super(title, category, cost);
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track) == false) {
			tracks.add(track);
			System.out.println("The track " + track.getTitle() + " has been added");
		} else {
			System.out.println("This track is already in tracks list");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("The track " + track.getTitle() + " has been removed");
		} else {
			System.out.println("This track is not in tracks list");
		}
	}
	
	public void play() {
		for (int i = 0; i < tracks.size(); i++) {
			tracks.get(i).play();
		}
	}

	public String toString() {
		return "CD - " + title + artist + " - " + category + " - " 
				+ director + " - " + length + ": " + cost + "$";
	}
	
	

	

}

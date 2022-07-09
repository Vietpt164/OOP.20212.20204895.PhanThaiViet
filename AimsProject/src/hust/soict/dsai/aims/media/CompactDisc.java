package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.dsai.aims.Playable;
import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public int getLength() {
		length = 0;
		for (int i = 0; i < tracks.size(); i++) {
			length += tracks.get(i).getLength();
		}
		return length;
	}
	

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}

	public CompactDisc(String title, String category) {
		super(title, category);
	}

	public CompactDisc(String title) {
		super(title);
	}

	public CompactDisc(String title, String category, String director, float cost, String artist) {
		super(title, category, director, cost);
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
	
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			Iterator<Track> iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = (Track)iter.next();
				try {
					nextTrack.play();
				} catch (PlayerException e){
					throw e;
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}

	public String toString() {
		return "CD " + id + " - " + title + " - " + artist + " - " + category + " - " 
				+ director + " - " + length + ": " + cost + "$";
	}
	
	

	

}

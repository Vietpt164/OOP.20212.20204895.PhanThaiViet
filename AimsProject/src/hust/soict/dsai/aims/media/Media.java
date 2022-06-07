package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public class Media {
	protected static int nbMedias = 0;
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected LocalDate dateAdded = LocalDate.now(); 
	
	public static int getNbMedias() {
		return nbMedias;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public Media(String title) {
		super();
		this.title = title;
		nbMedias++;
		this.id = nbMedias;
	}

	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
		nbMedias++;
		this.id = nbMedias;
	}

	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMedias++;
		this.id = nbMedias;
	}
	
	
	
	
}


interface Playable {
	public void play();
}

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

	public Media() {
		// TODO Auto-generated constructor stub
	}

}

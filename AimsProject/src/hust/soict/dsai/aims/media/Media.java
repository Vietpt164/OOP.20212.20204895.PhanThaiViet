package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

import hust.soict.dsai.aims.media.comparator.*;

public abstract class Media implements Comparable<Media> {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost(); 
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	
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
	
	public boolean equals(Object o) {
		return this.id == ((Media)o).getId();
	}
	
	public int compareTo(Media media) {
		if (title.compareTo(media.getTitle()) == 0) {
			return category.compareTo(media.getCategory());
		} else {
			return title.compareTo(media.getTitle());
		}	
	}
	
	
	
}




package hust.soict.dsai.aims.disc;
import java.time.LocalDate;
public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0;

	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private LocalDate dateAdded = LocalDate.now();
	private int id;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public int getId() {
		return id;
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
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

//Student Name: John Holcomb
//Student ID: 890968950


import java.util.*;
public class BookStore{

	public static void main(String[] args) {
		ArrayList<Publication> myBookStore = new ArrayList<>();

		myBookStore.add(new Book("Patricia Churchland", "Consciousness", "Neurophilosophy"));
		myBookStore.add(new Magazine("Springer Nature", "Nature", "Science and Technology"));
		myBookStore.add(new Publication("Mastering the game of Go", "Science and Technology"));
		myBookStore.add(new Book("LazyTown", "On the Nature of Baking Cakes", "Cakeshop Philosophy"));

		Collections.sort(myBookStore);

		for(Publication p: myBookStore)
		 System.out.println(p.getInfo());
	}
	
}

class Publication implements Comparable<Publication>{
	
	private String genre;
	private String title;
	
	public Publication(String title, String genre) {
		this.genre = genre;
		this.title = title;
	}
	
	public String getInfo() {
		return title + ", " + genre;
	}
	
	public int compareTo(Publication other) {
		if (genre.compareTo(other.genre) != 0) {
			return genre.compareTo(other.genre);
		} else {
			return title.compareTo(other.title);
		}
	}
	
}

class Book extends Publication {
	
	private String author;
	
	public Book(String author, String title, String genre) {
		super(title, genre);
		this.author = author;
	}
	
	public String getInfo() {
		return super.getInfo() + ", Written by " + author;
	}
	
}

class Magazine extends Publication {
	
	private String publisher;
		
	public Magazine(String publisher, String title, String genre) {
		super(title, genre);
		this.publisher = publisher;
	}
	
	public String getInfo() {
		return super.getInfo() + ", Published by " + publisher;
	}
	
}
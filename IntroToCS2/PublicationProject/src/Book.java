public class Book extends Publication {
	//subclass attributes
	private String author;
	private Genre genre;
	
	public Book(String author, String title, Genre genre, int edition, int year) {
		//inherits superclass attributes
		super(title, genre, edition, year);
		this.genre = genre;
		this.author = author;
	}
	
	public void printInfo() {
		super.printInfo();
		System.out.printf("%s book by %s.\n", genre, author);
		return;
	}
}
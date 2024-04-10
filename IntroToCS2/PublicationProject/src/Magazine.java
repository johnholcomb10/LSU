public class Magazine extends Publication {
	//subclass attributes
	private String publisher;
	private Genre genre;
		
	public Magazine(String publisher, String title, Genre genre, int edition, int year) {
		//inherits superclass attributes
		super(title, genre, edition, year);
		this.genre = genre;
		this.publisher = publisher;
	}
	
	public void printInfo() {
		super.printInfo();
		System.out.printf("%s magazine by %s.\n", genre, publisher);
		return;
	}
}
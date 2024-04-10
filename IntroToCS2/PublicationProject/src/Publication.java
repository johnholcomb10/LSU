public class Publication implements Comparable<Publication> {
	//attributes of superclass
	private String title;
	private Genre genre;
	private int edition, year;
	
	public Publication(String title, Genre genre, int edition, int year) {
		this.genre = genre;
		this.title = title;
		this.edition = edition;
		this.year = year;
	}
	
	public void printInfo() {
		System.out.printf("%s. Edition (%d) published in %d.\n", title, edition, year);
		return;
	}

	public void printFooter() {
		System.out.print("All rights reserved.\n--------------------\n");
	}
	
	public int compareTo(Publication other) {
		if (genre.toString().compareTo(other.genre.toString()) != 0) {
			return genre.toString().compareTo(other.genre.toString());
		} else {
			return title.compareTo(other.title);
		}
	}
}
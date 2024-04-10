import java.util.ArrayList;
import java.util.Collections;

public class Driver{
	public static void main(String[] args) {
		ArrayList<Publication> pubs = new ArrayList<>();
		//list of publications

		pubs.add(new Book("John Carreyrou", "Bad Blood: Secrets and Lies in a Silicon Valley Startup",
		Genre.THRILLER, 1, 2018));
		pubs.add(new Book("Andriy Burkov", "The Hundred-Page Machine Learning Book", Genre.SCIENCE, 1,
		2019));
		pubs.add(new Magazine("Meredith Corporation", "Sports Illustrated", Genre.ATHLETIC, 633, 2020));
		pubs.add(new Magazine("Meredith Corporation", "People", Genre.ENTERTAINMENT, 466, 2020));

		Collections.sort(pubs);
		//sorts list based on genre, then title

		for(Publication p : pubs) {
			//prints info for each publication in list
			p.printInfo();
			p.printFooter();
		}
	}
}

enum Genre {SCIENCE,ROMANCE,COMIC,CLASSIC,ATHLETIC,BEAUTY,FASHION,ENTERTAINMENT,THRILLER;}
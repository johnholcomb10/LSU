
public class SuperSecret {

	public static void main(String[] args) {
		String SecretMessage = "eYTaPBBF^CUXBvD\\S^eYPzPE";
		System.out.println("Message is: " + sauceIfy(SecretMessage));
	}
	public static String sauceIfy(String message) {
		int sauce = 44;
		String Revealed = "";
		for (int i = 0; i < 10; i++) {
			Revealed = "";
			for (char letter : message.toCharArray()) {
				Revealed +=  Character.toString(letter ^ (sauce + i));
			}
		}
		return Revealed;
	}
}

public class Cipher {

	private String Msg;
	private int Key;
	private boolean isE;
	
	public Cipher(String msg, char key) {
		Msg = msg;
		Key = (int) key;
		isE = false;
	}
	
	public String GetMessage() {
		return Msg;
	}
	
	public void Encrypt() {
		if(isE == true) {
			return;
		} else {
			char[] eChars = Msg.toCharArray();
			for (int i = 0; i < Msg.length(); i++){	
				if(!Character.isLetter(eChars[i])) {
					continue;
				} else if(Character.isUpperCase(eChars[i])){
					eChars[i] += Key;
					if(eChars[i] > 'Z') {
						eChars[i] -= 26;
					}
				} else if(Character.isLowerCase(eChars[i])) {
					eChars[i] += Key;
					if(eChars[i] > 'z') {
						eChars[i] -= 26;
					}
				}
			}
			Msg = new String(eChars);
			isE = true;
		}
	}
	
	public void Decrypt() {
		if(isE == false) {
			return;
		} else {
			char[] eChars = Msg.toCharArray();
			for (int i = 0; i < Msg.length(); i++){	
				if(!Character.isLetter(eChars[i])) {
					continue;
				} else if(Character.isUpperCase(eChars[i])){
					eChars[i] -= Key;
					if(eChars[i] < 'A') {
						eChars[i] += 26;
					}
				} else if(Character.isLowerCase(eChars[i])) {
					eChars[i] -= Key;
					if(eChars[i] < 'a') {
						eChars[i] += 26;
					}
				}
			}
			Msg = new String(eChars);
			isE = false;
		}
	}
	
	public boolean IsEncrypted() {
		return isE;
	}
	
}


public class CipherDriver {

	public static void main(String[] args) {

		
		String s1 = "Hello, World!";
		String s2 = "Try this on for size!";
		String s3 = "THIS IS SUPER SECRET";
		
		Cipher c1 = new Cipher(s1, (char) 13);
		Cipher c2 = new Cipher(s2,(char) 6);
		Cipher c3 = new Cipher(s3,(char) 2);
		
		c1.Encrypt();
		System.out.printf("[*]C1: %s\tC2: %s\t\tC3: %s\n",(c1.IsEncrypted()) ? "Encrypted" : "Unencrypted",(c2.IsEncrypted()) ? "Encrypted" : "Unencrypted",(c3.IsEncrypted()) ? "Encrypted" : "Unencrypted");
		c2.Encrypt();
		c3.Encrypt();
		System.out.printf("[*]Encrypting %s with a key of %d gives us %s\n", s1,13,c1.GetMessage());
		System.out.printf("[*]Encrypting %s with a key of %d gives us %s\n", s2,6,c2.GetMessage());
		System.out.printf("[*]Encrypting %s with a key of %d gives us %s\n", s3,2,c3.GetMessage());
		
		c1.Decrypt();
		c2.Decrypt();
		System.out.printf("[*]C1: %s\tC2: %s\t\tC3: %s\n",(c1.IsEncrypted()) ? "Encrypted" : "Unencrypted",(c2.IsEncrypted()) ? "Encrypted" : "Unencrypted",(c3.IsEncrypted()) ? "Encrypted" : "Unencrypted");
		c3.Decrypt();
		System.out.printf("[*]Now decrypted:\n");
		System.out.printf("[*]C1 -> %s\n",c1.GetMessage());
		System.out.printf("[*]C2 -> %s\n",c2.GetMessage());
		System.out.printf("[*]C3 -> %s\n",c3.GetMessage());
		
	}

}

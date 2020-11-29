import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;

public class FindIt {

  public static void main(String args[]) throws Exception {
    String cText = "A1TEAJWqY8c=";
    // Decode the cyber text
    byte[] ciphertext = Base64.getDecoder().decode(cText);

    // Set Key
    SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
    sr.setSeed("1234".getBytes());
    byte[] k = new byte[16];
    sr.nextBytes(k);
    SecretKeySpec key = new SecretKeySpec(k, "AES");

    // Set Iv
    Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
    byte[] iv = new byte[16];
    sr.nextBytes(iv);
    IvParameterSpec ivspec = new IvParameterSpec(iv);

    // Initializing a Cipher in DECRYPT_MODE
    cipher.init(Cipher.DECRYPT_MODE, key, ivspec);

    // Decrypting the ciphertext
    byte[] plainText = cipher.doFinal(ciphertext);

    // Decryption pass
    System.out.println("Plain text length: " + plainText.length);
    String s = new String(plainText);
    System.out.println("plain text: " + s);

  }
}

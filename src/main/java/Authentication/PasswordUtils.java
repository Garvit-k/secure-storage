package Authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class PasswordUtils {
    String getPasswordHash(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        md.update(salt.getBytes());

        byte[] bytes = md.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    String createCryptoRandomString() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        StringBuilder sb = new StringBuilder();
        for (byte b : salt) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }

        //System.out.println("gen salt: "+sb);
        return sb.toString();
    }
}

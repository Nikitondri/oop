package by.egorstrupinski.crypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class CryptService {
    Cipher cipher;
    String transformation = "AES";

    public CryptService() {
    }

    private byte[] makeEncryption(SecretKeySpec secretKey, byte[] plainText) {
        try {
            this.cipher = Cipher.getInstance(this.transformation);
            this.cipher.init(1, secretKey);
            return this.cipher.doFinal(plainText);
        } catch (Exception var4) {
            System.out.println("Encryption fail");
            return null;
        }
    }

    private byte[] makeDecryption(SecretKeySpec secretKey, byte[] encryptedText) {
        try {
            this.cipher = Cipher.getInstance(this.transformation);
            this.cipher.init(2, secretKey);
            return this.cipher.doFinal(encryptedText);
        } catch (Exception var4) {
            System.out.println("Encryption fail");
            return null;
        }
    }

    private SecretKeySpec createSecretKey() {
        SecretKeySpec sks = null;
        byte[] bytes = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] key = md.digest(bytes);
            key = Arrays.copyOf(key, 16);
            sks = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException var6) {
            var6.printStackTrace();
        }

        return sks;
    }

    public byte[] encrypt(byte[] data) {
        CryptService cryptoServ = new CryptService();
        SecretKeySpec key = cryptoServ.createSecretKey();
        byte[] enc = cryptoServ.makeEncryption(key, data);
        char[] hex = Hex.encodeHex(key.getEncoded());
        System.out.println("It`s your key, keep it in secret)\n" + String.valueOf(hex));
        return enc;
    }

    private static String getSecretKey() {
        Scanner input = new Scanner(System.in);
        String str = "";

        boolean isIncorrect;
        do {
            System.out.println("Enter the secret key to decrypt data \n");
            System.out.print("Input: ");
            isIncorrect = false;

            try {
                str = input.nextLine();
            } catch (Exception var4) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }

            if (!isIncorrect && str.length() == 0) {
                System.out.println("Enter the key!!!!!!");
                isIncorrect = true;
            }
        } while(isIncorrect);

        return str;
    }

    public byte[] decrypt(byte[] data) {
        CryptService cryptoServ = new CryptService();

        byte[] encoded;
        try {
            encoded = Hex.decodeHex(getSecretKey().toCharArray());
        } catch (DecoderException var6) {
            var6.printStackTrace();
            return null;
        }

        SecretKeySpec originalKey = new SecretKeySpec(encoded, this.transformation);
        byte[] bytes = cryptoServ.makeDecryption(originalKey, data);
        return bytes;
    }
}

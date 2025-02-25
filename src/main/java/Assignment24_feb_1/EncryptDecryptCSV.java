package Assignment24_feb_1;
import java.io.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static final String KEY = "MySecretKey12345";

    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String encryptedFile = "encrypted_employees.csv";
        String decryptedFile = "decrypted_employees.csv";

        encryptCSV(inputFile, encryptedFile);
        decryptCSV(encryptedFile, decryptedFile);
    }

    public static void encryptCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String header = br.readLine();
            bw.write(header + "\n");

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                data[3] = encrypt(data[3]);
                data[4] = encrypt(data[4]);
                bw.write(String.join(",", data) + "\n");
            }
            System.out.println("✅ Data encrypted and saved to: " + outputFile);
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public static void decryptCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String header = br.readLine();
            bw.write(header + "\n");

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                data[3] = decrypt(data[3]);
                data[4] = decrypt(data[4]);
                bw.write(String.join(",", data) + "\n");
            }
            System.out.println("✅ Data decrypted and saved to: " + outputFile);
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public static String encrypt(String value) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("❌ Encryption error", e);
        }
    }

    public static String decrypt(String value) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(value)));
        } catch (Exception e) {
            throw new RuntimeException("❌ Decryption error", e);
        }
    }
}


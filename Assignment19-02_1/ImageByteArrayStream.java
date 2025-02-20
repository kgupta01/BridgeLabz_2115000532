import java.io.*;
import java.nio.file.Files;
public class ImageByteArrayStream {
    public static void main(String[] args) {
        String inputImagePath = "input.jpeg";
        String outputImagePath = "output.jpeg";
        try {
            byte[] imageData = Files.readAllBytes(new File(inputImagePath).toPath());
            ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int data;
            while ((data = bais.read()) != -1) {
                baos.write(data);
            }
            Files.write(new File(outputImagePath).toPath(), baos.toByteArray());
            System.out.println("Image successfully converted to byte array and written back to file.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

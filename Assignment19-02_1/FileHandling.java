import java.io.*;
public class FileHandling {
    public static void copyFile(String sourceFile, String destinationFile) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }       
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found.");
        } catch (IOException e) {
            System.out.println("Error while copying file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String source = "file.txt";
        String destination = "file1.txt";
        copyFile(source, destination);
    }
}

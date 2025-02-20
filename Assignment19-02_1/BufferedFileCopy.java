import java.io.*;
public class BufferedFileCopy {
    private static final int BUFFER_SIZE = 4096;
    public static void copyFileWithBufferedStreams(String sourceFile, String destinationFile) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered copy completed in " + (System.nanoTime() - startTime) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void copyFileWithNormalStreams(String sourceFile, String destinationFile) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }       
            System.out.println("Normal copy completed in " + (System.nanoTime() - startTime) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String source = "file.txt";
        String destinationBuffered = "copy_buffered.txt";
        String destinationNormal = "copy_normal.txt";
        copyFileWithBufferedStreams(source, destinationBuffered);
        copyFileWithNormalStreams(source, destinationNormal);
    }
}

import javax.swing.*;
import java.io.*;

public class FileInspector {
    public static void main(String[] args) {
        // Open JFileChooser in src directory
        JFileChooser fileChooser = new JFileChooser("src");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Echo lines to the screen and generate summary report
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;

                // Read the file line by line
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    lineCount++;

                    // Count words in the line
                    String[] words = line.split("\\s+");
                    wordCount += words.length;

                    // Count characters in the line
                    charCount += line.length();
                }

                // Print summary report
                System.out.println("\nSummary Report:");
                System.out.println("File Name: " + file.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

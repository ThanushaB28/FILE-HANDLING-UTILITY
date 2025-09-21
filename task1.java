package CodeTech;

import java.io.*;
import java.util.Scanner;

public class FileHandlingDemo {

    // Method to write content into a file
    public static void writeFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("✅ File written successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error while writing file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("📖 Reading file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error while reading file: " + e.getMessage());
        }
    }

    // Method to append/modify content in a file
    public static void modifyFile(String fileName, String newContent) {
        try (FileWriter writer = new FileWriter(fileName, true)) { // true = append mode
            writer.write("\n" + newContent);
            System.out.println("✏️ File modified successfully (content appended)!");
        } catch (IOException e) {
            System.out.println("❌ Error while modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String fileName = "sample.txt";

        System.out.println("Enter text to write in the file:");
        String content = sc.nextLine();
        writeFile(fileName, content);

        readFile(fileName);

        System.out.println("Enter new text to append:");
        String newContent = sc.nextLine();
        modifyFile(fileName, newContent);

        readFile(fileName);

        sc.close();
    }
}

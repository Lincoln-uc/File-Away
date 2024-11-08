import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Scanner;

public class DataSaver {

    public static void main(String[] args) {
        ArrayList<String> records = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean moreRecords = true;
        int idNumber = 1;

        while (moreRecords) {
            String firstName = SafeInput.getString("Enter first name:");
            String lastName = SafeInput.getString("Enter last name:");
            String id = String.format("%06d", idNumber++);
            String email = SafeInput.getString("Enter email:");
            int yearOfBirth = SafeInput.getInt("Enter year of birth:");

            String record = firstName + ", " + lastName + ", " + id + ", " + email + ", " + yearOfBirth;
            records.add(record);

            System.out.println("Record added: " + record);
            System.out.println("Do you want to add another record? (yes/no)");
            moreRecords = scanner.nextLine().equalsIgnoreCase("yes");
        }

        // Prompt for file name
        System.out.println("Enter the file name to save the records (with .csv extension):");
        String fileName = scanner.nextLine();

        // Write records to CSV file
        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Records saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SafeInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static int getInt(String prompt) {
        int number = 0;
        boolean valid = false;
        while (!valid) {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
            scanner.nextLine(); // Consume newline
        }
        return number;
    }
}

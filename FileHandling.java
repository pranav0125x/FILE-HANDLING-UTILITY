import java.io.*;
import java.util.*;

public class FileHandling{

    public static void WriteToFile(String file, String text){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write(text);
            System.out.println("Written Successfully");
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void ReadTheFile(String file){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            System.out.println("Reading the File");
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void AppendToFile(String file, String text){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            writer.newLine();
            writer.write(text);
            System.out.println("Appended Succesfully");
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String fileName = "xyz.txt";
        int choice;

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Write to File");
            System.out.println("2. Append to File");
            System.out.println("3. Read the File");
            System.out.println("4. Close");
            System.out.print("Enter your choice (1-4): ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter the info to Write: ");
                    String writeText = sc.nextLine();
                    WriteToFile(fileName, writeText);
                    break;

                case 2:
                    System.out.print("Enter the info to Append: ");
                    String appendText = sc.nextLine();
                    AppendToFile(fileName, appendText);
                    break;

                case 3:
                    ReadTheFile(fileName);
                    break;

                case 4:
                    System.out.println("Closing the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1 to 4.\n");
            }

        } while (choice != 4);
        sc.close();
    }
}

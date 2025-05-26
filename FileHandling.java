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
        System.out.print("Enter the info to write: ");
        String a = sc.nextLine();
        WriteToFile("xyz.txt", a);

        ReadTheFile("xyz.txt");

        System.out.print("Enter the info to Append: ");
        String b = sc.nextLine();
        AppendToFile("xyz.txt", b);

        ReadTheFile("xyz.txt");
    }
}

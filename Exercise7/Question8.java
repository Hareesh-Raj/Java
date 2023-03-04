package Exercise7;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

public class Question8 {
	public static void main(String[] args) {
        try  (BufferedReader reader=new BufferedReader(new FileReader("myFile1.txt"));
            BufferedWriter writer=new BufferedWriter(new FileWriter("newFile.txt"));){
            String line=reader.readLine();
            while(line!=null)
            {
                writer.write(line);
                line=reader.readLine();
                writer.newLine();
            }
        } catch (Exception e) {
           e.printStackTrace();
        }   
    }
}

package Exercise7;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class LineByLineCopy {
	public static void main(String[] args) {
        try  (BufferedReader reader = new BufferedReader(new FileReader("newFile.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("CopyMyFile.txt"));) {
            String line = reader.readLine();
            while(line != null)
            {
                writer.write(line);
                line = reader.readLine();
                writer.newLine();
            }
        } catch (Exception e) {
           e.printStackTrace();
        }  
        
    }
}

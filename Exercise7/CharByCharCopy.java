package Exercise7;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharByCharCopy {
    public static void main(String[] args) {
        try (
				FileReader fileReader = new FileReader("myFile1.txt");
				FileWriter fileWriter = new FileWriter("copy.txt",false);
				)
			{
				int numberOfCharacters = 0;
				char byteArray[] = new char[1];
				while((numberOfCharacters = fileReader.read(byteArray)) != -1) {			
					fileWriter.write(byteArray,0,numberOfCharacters);
				}
			} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

package Exercise7;
import java.io.*;

public class CopyImage {
  public static void main(String[] args) {
    try 	(
    		FileInputStream fileInputStream = new FileInputStream("image.jpg");
			FileOutputStream fileOutputStream = new FileOutputStream("copyimage.jpg",true);)
		{
			
    	int numberOfCharacters = 0;
		byte byteArray[] = new byte[1024];
		while((numberOfCharacters=fileInputStream.read(byteArray)) != -1) 
		{			
			fileOutputStream.write(byteArray,0,numberOfCharacters);
		} 
		} catch (IOException e) {
			e.printStackTrace();
		} 
  }
   
}

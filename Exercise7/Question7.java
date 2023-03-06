package Exercise7;
import java.io.FileReader;
import java.io.FileWriter;
public class Question7 {
    public static void main(String[] args) {
        try (
				FileReader fis=new FileReader("myFile1.txt");
				FileWriter fos=new FileWriter("copy.txt",false);
				)
		{
			
			int n=0;char b[]= new char[1];
			while((n=fis.read(b))!=-1) {			
				fos.write(b,0,n);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
}

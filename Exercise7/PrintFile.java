package Exercise7;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
public class PrintFile {
    public static void main(String[] args) {
    	Scanner scanner=null;
    	try {
	    		File file=new File("CopyMyFile.txt");
	    		scanner=new Scanner(file);
	    		while(scanner.hasNextLine())
	    		{
	    			System.out.println(scanner.nextLine());
	            }
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally {
                scanner.close();
            }   
        }
    }


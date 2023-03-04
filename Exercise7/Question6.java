package Exercise7;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
public class Question6 {
    public static void main(String[] args) {
        
            Scanner sc=null;
            try  {
                File file=new File("myFile1.txt");
                 sc=new Scanner(file);
                while(sc.hasNextLine())
                {
                    System.out.println(sc.nextLine());
                }
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                sc.close();
            }   
        }
    }


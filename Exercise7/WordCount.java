package Exercise7;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
       
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        scanner.close();
        Scanner reader=new Scanner(input);
        int wordsCount=0;
        while(reader.hasNext())
        {
            reader.next();
            wordsCount++;
        }
        
        System.out.println("The Number if words "+wordsCount);
    }
   
}

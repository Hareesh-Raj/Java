package Exercise7;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        String sentence="Hello world i am happyy";
        Scanner sc=new Scanner(sentence);
        int wordsCount=0;
        while(sc.hasNext())
        {
            sc.next();
            wordsCount++;
        }
        
        System.out.println("The Number if words "+wordsCount);
    }
   
}

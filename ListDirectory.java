package Exercise7;
import java.io.File;
public class ListDirectory {
    public static void main(String[] args) {
        File myfile = new File("/Users/hareeshraj/eclipse-workspace/AceExercise/src/Exercise7");
        String[] contents = myfile.list();
        for(String str:contents)
        {
            System.out.println(str);
        }
    }
}

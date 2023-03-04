package Exercise7;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
public class Question9 {
    public static void main(String[] args) {
        try {
            Date d1=new Date();
		System.out.println("Intial Time ...:"+d1);
		new WriteObject().writeObject(d1);
        
        Thread.sleep(5000);

		System.out.println("After Delay.....");
		d1=new Date();
		System.out.println("Time after delay..:"+d1);
		
		System.out.println("Restore back to time.........");
		
		Date d2=new ReadObject().readObject("date.dat");
		System.out.println("After restoring...........:"+d2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
class WriteObject {
	public void writeObject(Date date) throws Exception{
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("date.dat"));
		oos.writeObject(date);
	}
}
class ReadObject {
	public Date readObject(String filename) throws Exception{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filename));
		return (Date)ois.readObject();
	}
}

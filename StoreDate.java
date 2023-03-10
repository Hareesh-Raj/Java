package Exercise7;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class StoreDate {
    public static void main(String[] args) {
    	try {
    		Date date=new Date();
            System.out.println("Intial Time ...:" + date);
    		new WriteObject().writeObject(date);
			Thread.sleep(5000);
			System.out.println("After Delay.....");
			date = new Date();
			System.out.println("Time after delay..:" + date);
			
			System.out.println("Restore back to time......");
			
			Date date2;
			date2 = new ReadObject().readObject("date.dat");
			System.out.println("After restoring...........:" + date2);
    	}
    	catch(InterruptedException e)
    	{
    		e.printStackTrace();
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}

// Writes the object
class WriteObject {
	public void writeObject(Date date) throws IOException, FileNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("date.dat"));
		oos.writeObject(date);
		oos.close();
	}
}

// Reads the Object
class ReadObject {
	public Date readObject(String filename) throws Exception{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filename));
		ois.close();
		return (Date)ois.readObject();
	}
}

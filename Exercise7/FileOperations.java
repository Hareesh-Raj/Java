package Exercise7;

import java.io.*;
import java.util.Scanner;


public class FileOperations {
    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter The Operation need to be performed..");
    	String operation = scanner.next();
    	FilesCRUD.myOperation(operation); 
     }
}
class FilesCRUD{
	public static void myOperation(String request)
	{
		if(request.equals("create"))
		{
			System.out.println("Enter The FileName");
			Scanner scanner = new Scanner(System.in);
			String fileName = scanner.next();
			File file = new File(fileName+".txt");
			if(!file.exists())
			{				
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("File Already Exists...");
			}
		}
		else if(request.equals("rename"))
		{
			System.out.println("Enter The FileName to be renamed..");
			Scanner scanner = new Scanner(System.in);
			String fileName = scanner.next();
			File file = new File(fileName+".txt");	
			if(file.exists())
			{				
				System.out.println("Enter The NewName..");
				String newFileName = scanner.next();
				File newFile = new File(newFileName+".txt");
				file.renameTo(newFile);
				System.out.println("FileName Changed...");
			}
			else
			{
				System.out.println("File Doesn't Exists...");
			}
			
		}
		else if(request.equals("delete"))
		{
			System.out.println("Enter The FileName to be Deleted..");
			Scanner scanner = new Scanner(System.in);
			String fileName = scanner.next();
			File file =new File(fileName+".txt");	
			if(file.exists())
			{				
				file.delete();
				System.out.println("File Deleted...");
			}
			else
			{
				System.out.println("File Doesn't Exists...");
			}
		}
	}
}
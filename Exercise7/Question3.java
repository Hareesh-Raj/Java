package Exercise7;

import java.io.*;
// import java.io.IOException;

public class Question3 {
    public static void main(String[] args) throws IOException{
        File myfile1 =new File("MyFile.txt");
        File myfile =new File("myFile1.txt");
        System.out.println(myfile.length());
        // System.out.println(myfile1.createNewFile());

        // BufferedWriter writer =new BufferedWriter(new FileWriter("MyFile.txt",true));
        // writer.write("Hiiiiii");
        // writer.close();

        // try{
        //     Thread.sleep(5000);
        // }
        // catch(Exception e)
        // {
        //     e.printStackTrace();
        // }
        // myfile1.renameTo(myfile);
        // myfile.delete();
        // FileOutputStream fileoutputstream = new FileOutputStream("myfile1.txt");
        // File myfile =new File("myFile1.txt");
        // try{

        //     Thread.sleep(5000);
        // }
        // catch(Exception e){
        //     e.printStackTrace();
        // }
        // fileoutputstream.close();

        // myfile.delete();
    }
}

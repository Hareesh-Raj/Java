package Exercise7;
import java.io.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Question5 {
  public static void main(String[] args) {
    try (
				FileInputStream fis=new FileInputStream("image.jpg");
				FileOutputStream fos=new FileOutputStream("copyimage.jpg",true);
				)
		{
			
			int n=0;
      byte b[]= new byte[8];
			while((n=fis.read(b))!=-1) {			
				fos.write(b,0,n);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
  }
    // public static void main(String[] args) throws IOException{
    //     BufferedImage image = ImageIO.read(new File("image.jpg"));
        
    //     // create the object of ByteArrayOutputStream class
    //     ByteArrayOutputStream outStreamObj = new ByteArrayOutputStream();
          
    //     // write the image into the object of ByteArrayOutputStream class
    //     ImageIO.write(image, "jpg", outStreamObj);
          
    //     // create the byte array from image
    //     byte [] byteArray = outStreamObj.toByteArray();
        
    //     // create the object of ByteArrayInputStream class
    //     // and initialized it with the byte array.
    //     ByteArrayInputStream inStreamObj = new ByteArrayInputStream(byteArray);
          
    //     // read image from byte array
    //     BufferedImage newImage = ImageIO.read(inStreamObj);
          
    //     // write output image
    //     ImageIO.write(newImage, "jpg", new File("outputImage.jpg"));
    //     System.out.println("Image generated from the byte array.");
    //   }
}

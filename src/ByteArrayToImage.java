import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ByteArrayToImage {



    public static BufferedImage convertByteArrayToImage(byte[] imageData) {


        try {

            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
            BufferedImage image = ImageIO.read(bis);
            bis.close();
            return image;


        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }


    }



}

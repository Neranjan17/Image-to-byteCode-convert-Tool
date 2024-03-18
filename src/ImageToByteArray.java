import java.io.*;

public class ImageToByteArray {
    public static byte[] convertImageToByteArray(String imagePath) {

        try {

            FileInputStream fis = new FileInputStream(imagePath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = bos.toByteArray();
            fis.close();
            bos.close();
            return imageBytes;

        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
    }

}

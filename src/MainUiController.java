import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class MainUiController {
    public TextField edAddressT1;
    public TextArea edByteCodeT1;
    public ImageView imageViewT2;
    public TextArea edByteCodeT2;

    String byteCode = "";

    public void btnCovertOnActionT1(ActionEvent actionEvent) {


        String address = edAddressT1.getText();
        byte[] byteArray = ImageToByteArray.convertImageToByteArray(address);
        byteCode = Arrays.toString(byteArray);

        if (byteArray != null) {
            edByteCodeT1.setText(byteCode);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid image address!");
            alert.showAndWait();
        }
        

    }

    public void btnCopyOnActionT1(ActionEvent actionEvent) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(byteCode);
        clipboard.setContent(content);

    }

    public void btnConvertOnActionT2(ActionEvent actionEvent) {

        String byteCode = edByteCodeT2.getText();
        byte[] byteArray = convertStringToByteArray(byteCode);
        BufferedImage image = ByteArrayToImage.convertByteArrayToImage(byteArray);

        if (image != null) {

            Image fxImage = SwingFXUtils.toFXImage(image, null);
            imageViewT2.setImage(fxImage);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Byte code is not valid");
            alert.showAndWait();
        }
    }

    public void btnClearOnActionT2(ActionEvent actionEvent) {
        imageViewT2.setImage(null);
        edByteCodeT2.clear();
    }

    public void tabByteToImgSelectionChangeT2(Event event) {
        edByteCodeT2.setText(byteCode);
    }

    private byte[] convertStringToByteArray(String byteCode) {

        String[] byteValues = byteCode.substring(1, byteCode.length() - 1).split(", ");

        byte[] byteArray = new byte[byteValues.length];

        for (int i = 0; i < byteValues.length; i++) {
            byteArray[i] = Byte.parseByte(byteValues[i].trim());
        }
        return byteArray;
    }
}

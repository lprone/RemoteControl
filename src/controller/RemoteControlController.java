package controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import logic.LocalData;
import logic.Server;
import view.RemoteControlView;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class RemoteControlController {
    private static final String QR_IMAGE_NAME = "URL_QR.png";

    public static void startRemoteControl() {
        final int PORT = 9999;
        try {
            LocalData localData = new LocalData(PORT);
            registerRemoteControl(localData);
            new Server(PORT);
            new RemoteControlView(localData, QR_IMAGE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void registerRemoteControl(LocalData localData) {
        final String paramValue = "http://" + localData.getIp() + ":" + localData.getPort();
        try {
            generateQRCodeImage(paramValue, 350, 350, QR_IMAGE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "error al generar QR");
        }
    }

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
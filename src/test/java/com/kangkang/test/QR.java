package com.kangkang.test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDateTime;

/**
 * ClassName:QR
 * Package:com.kangkang.test
 * Description:
 *
 * @date:2022/4/25 11:21
 * @author:kangkang
 */
public class QR {


    private static  String QR_CODE_IMAGE_PATH = "src/main/resources/images/";

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    public static void main(String[] args) {
        String name = String.valueOf( System.currentTimeMillis()) + ".png";
        QR_CODE_IMAGE_PATH += name;


        System.out.println(QR_CODE_IMAGE_PATH);

        try {
            generateQRCodeImage("http://www.baidu.com", 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
    }
}

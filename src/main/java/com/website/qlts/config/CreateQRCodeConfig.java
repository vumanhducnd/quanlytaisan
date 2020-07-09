package com.website.qlts.config;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class CreateQRCodeConfig {
    public void createQrCodeAssets(String url,long id)  {
        try {
            File directory = new File("");
            File file = new File(directory.getAbsolutePath()  + "\\src\\main\\resources\\static\\images\\MyQRCode" + id +".png");
            String filePath = directory.getAbsolutePath()  + "\\src\\main\\resources\\static\\images\\\\MyQRCode" + id +".png";
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 600, 600);
            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        }catch (IOException | WriterException e){

        }
    }
}
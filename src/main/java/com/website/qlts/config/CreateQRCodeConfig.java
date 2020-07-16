package com.website.qlts.config;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.website.qlts.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class CreateQRCodeConfig {

    @Autowired
    FileStorageService storageService;

    public String createQrCodeAssets(String uri,String url,long id)  {
        String filePath = "";
        try {
            File directory = new File("");
            File file = new File(  uri + id +".png");
             filePath =  uri + id +".png";
//            String fileName = storageService.storeFile(file);
//            String fileDownloadUri = fileStoragePropertiesQRCode.getUrl() + "/avatar/" + id + ".png";
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 600, 600);
            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
            return filePath;
        }catch (IOException | WriterException e){

        }
        return filePath;
    }
}

package com.website.qlts.config;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.website.qlts.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


public class CreateQRCodeConfig {

    @Autowired
    FileStorageService storageService;

    public void createQrCodeAssets(String uri,String url,long id)  {
        String filePath = "";
        try {
            String link = "D:\\Download\\qlts\\src\\main\\resources\\static\\images";
            File directory = new File("");
            File file = new File(  link +"/"  +"QRCode.png");
             filePath =  link + "/" + id +".png";
//            String fileName = storageService.storeFile(file);
//            String fileDownloadUri = fileStoragePropertiesQRCode.getUrl() + "/avatar/" + id + ".png";
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 600, 600);
            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        }catch (IOException | WriterException e){

        }
    }

    public void qrCode(String url, long id){
        try {
            String qrCodeData = "www.chillyfacts.com";
            String filePath = "D:\\Download\\qlts\\src\\main\\resources\\static\\images\\"+ id+ ".png";
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap< EncodeHintType, ErrorCorrectionLevel >();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(url.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                    .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

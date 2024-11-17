package com.example.restservice.controller;

import com.example.restservice.utils.FtpDownloader;
import com.example.restservice.utils.FtpUploader;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/v1")
public class LeadImageController {

    @Value("${ftp.host}")
    private String host;

    @Value("${ftp.username}")
    private String userName;

    @Value("${ftp.password}")
    private String password;

    @PutMapping("/upload-image/{leadNo}/{path}/{fileName}")
    public String uploadFile(@PathVariable String leadNo, @PathVariable String path, @PathVariable String fileName, @RequestPart("file") MultipartFile file) {

        try {
            FtpUploader ftpUploader = new FtpUploader(host, userName, password);
            String effectivePath = "/"+path+"/";
            ftpUploader.uploadFile(file, fileName, effectivePath);
        } catch (Exception e) {
            return "failed";
        }

        return "Success";
    }

    @GetMapping(
            value = "/image/{leadNo}",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public byte[] getImage(@PathVariable String leadNo) throws IOException {

        FtpDownloader ftpDownloader;
        InputStream inStream;

        try {
            ftpDownloader = new FtpDownloader(host, userName, password);
            String fileName = "leadpic"+leadNo+".png";
            String path = "/Images/";
            String fullPath = path+fileName;
            inStream = ftpDownloader.downloadFile(fullPath);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new IOException();
        }

        return IOUtils.toByteArray(inStream);

    }

}

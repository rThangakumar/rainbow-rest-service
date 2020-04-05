package com.example.restservice.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.restservice.ftp.FTPUploader;
import com.example.restservice.ftp.FtpDownloader;

@RestController
@RequestMapping("/api/v1")
public class ChildImageController {

	@PutMapping("/upload-image")
	public String uploadFile(@RequestPart("file") MultipartFile file) {
		
		try {
			FTPUploader fTPUploader = new FTPUploader("66.7.148.186", "testrainbowhome", "rainbow@7");
			fTPUploader.uploadFile("C:\\Users\\rthan\\OneDrive\\Pictures\\Sermon pics\\11.png", "childPic.png", "/Images/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping(
			  value = "/image",
			  produces = MediaType.IMAGE_JPEG_VALUE
			)
	public @ResponseBody byte[] getImage() throws IOException {
		
		FtpDownloader ftpDownloader;
		InputStream inStream;
		try {
			ftpDownloader = new FtpDownloader("66.7.148.186", "testrainbowhome", "rainbow@7");
			inStream = ftpDownloader.downloadFile("/Images/childPic.png", "C:\\Users\\rthan\\OneDrive\\Pictures\\Sermon pics\\111.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IOException();
		}
		 return IOUtils.toByteArray(inStream);

	}

}
package com.example.restservice.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.restservice.dto.ImageDTO;
import com.example.restservice.utils.FtpUploader;
import com.example.restservice.utils.FtpDownloader;

@RestController
@RequestMapping("/api/v1")
public class ChildImageController {
	
	@Value("${ftp.host}")
	private String host;
	
	@Value("${ftp.username}")
	private String userName;
	
	@Value("${ftp.password}")
	private String password;

	@PutMapping("/upload-image/{childNo}")
	public String uploadFile(@PathVariable Integer childNo, @RequestPart("file") MultipartFile file) {
		
		try {
			FtpUploader ftpUploader = new FtpUploader(host, userName, password);
			String fileName = "childpic"+childNo+".png";
			String path = "/Images/";
			ftpUploader.uploadFile(file, fileName, path);
		} catch (Exception e) {
			return "failed";
		}
		
		return "Success";
	}
	
	@GetMapping(
			  value = "/image/{childNo}",
			  produces = MediaType.IMAGE_PNG_VALUE
			)
	public byte[] getImage(@PathVariable Integer childNo) throws IOException {
		
		FtpDownloader ftpDownloader;
		InputStream inStream;
		
		try {
			ftpDownloader = new FtpDownloader(host, userName, password);
			String fileName = "childpic"+childNo+".png";
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
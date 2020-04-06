package com.example.restservice.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class FileUploadController {
	
	@PutMapping("/upload-file")
	public String uploadFile(@RequestPart("file") MultipartFile file) {

		FTPClient client = new FTPClient();
		String filename = "data.txt";
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		try (InputStream is = classLoader.getResourceAsStream(filename)) {
			client.connect("66.7.148.186");
			client.login("testrainbowhome", "rainbow@7");

			// Store file to server
			client.storeFile(filename, is);
			client.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
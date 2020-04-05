package com.example.restservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.restservice.utils.FtpUploader;

@Component
public class FTPService {
	
	@Value("${ftp.host}")
	private String host;
	
	@Value("${ftp.username}")
	private String userName;
	
	@Value("${ftp.password}")
	private String password;
	
	public String uploadFile(Long childNo, MultipartFile file) {
		
		try {
			FtpUploader fTPUploader = new FtpUploader(host, userName, password);
			String fileName = "childpic"+childNo+".png";
			String path = "/Images/";
			fTPUploader.uploadFile(file, fileName, path);
		} catch (Exception e) {
			return "failed";
		}
		return "Success";
	}

}

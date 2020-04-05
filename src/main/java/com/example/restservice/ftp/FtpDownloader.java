package com.example.restservice.ftp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpDownloader {

    FTPClient ftp = null;

    public FtpDownloader(String host, String user, String pwd) throws Exception {
        ftp = new FTPClient();
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        ftp.connect(host);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftp.login(user, pwd);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();
    }

    public InputStream downloadFile(String remoteFilePath, String localFilePath) {
    	InputStream inputStream = null;
        try {
        	inputStream = this.ftp.retrieveFileStream(remoteFilePath);
        	//this.ftp.retrieveFile(remoteFilePath, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public void disconnect() {
        if (this.ftp.isConnected()) {
            try {
                this.ftp.logout();
                this.ftp.disconnect();
            } catch (IOException f) {
                // do nothing as file is already downloaded from FTP server
            }
        }
    }

    /*public static void main(String[] args) {
        try {
        	FtpDownloader ftpDownloader =
                new FtpDownloader("ftp_server.journaldev.com", "ftp_user@journaldev.com", "ftpPassword");
            ftpDownloader.downloadFile("sitemap.xml", "/Users/pankaj/tmp/sitemap.xml");
            System.out.println("FTP File downloaded successfully");
            ftpDownloader.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

package com.example.restservice.ftp;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpClient {
	 
    private String server;
    private int port;
    private String user;
    private String password;
    private FTPClient ftp;
 
    public FtpClient(String server, int port, String user, String password) {
    	this.server = server;
    	this.port = port;
    	this.user = user;
    	this.password = password;
    }
 
    void open() throws IOException {
        ftp = new FTPClient();
 
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
 
        ftp.connect(server, port);
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }
 
        ftp.login(user, password);
    }
 
    void close() throws IOException {
        ftp.disconnect();
    }
}

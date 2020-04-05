package com.example.restservice.model;

public class EmailData {

	private String toAddress;
	private String subject;
	private String bccAdress;
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String fromAddress;
	private String message;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBccAdress() {
		return bccAdress;
	}
	public void setBccAdress(String bccAdress) {
		this.bccAdress = bccAdress;
	}
	
}

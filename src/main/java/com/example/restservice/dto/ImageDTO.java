package com.example.restservice.dto;

import lombok.Getter;
import lombok.Setter;

public class ImageDTO {
	
	public ImageDTO(Integer imageKey, byte[] imageBytes) {
		this.imageKey = imageKey;
		this.imageBytes = imageBytes;
	}
	
	private Integer imageKey;
	private byte[] imageBytes;
	
	public Integer getImageKey() {
		return imageKey;
	}
	public void setImageKey(Integer imageKey) {
		this.imageKey = imageKey;
	}
	public byte[] getImageBytes() {
		return imageBytes;
	}
	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}
	
}
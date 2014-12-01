/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.employee.dto;

import java.io.Serializable;

/**
 *
 * @author kishor
 */
public class ImageDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12229333L;
	private String imagePath;
	private byte[] image;
	private String fileExtension;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public byte[] getImage() {
		return image.clone();
	}

	public void setImage(byte[] image) {
		this.image = image.clone();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

}

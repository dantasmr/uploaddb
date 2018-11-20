package com.upload.db.uploaddb.model;

import java.io.Serializable;

public class ImageUpload implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1635721316653992477L;
	private String name;
	private String data;
	private int total;
	private int index;
	
	public ImageUpload(){
	}
	
	
	public ImageUpload(String name, String data, int total, int index){
		this.name = name;
		this.data = data;
		this.total = total;
		this.index = index;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	@Override
	public String toString() {
		String info = String.format("Image name = %s, data = %s, total= %s, index= %s", name, data, total, index);
		return info;
	}
	
	
}

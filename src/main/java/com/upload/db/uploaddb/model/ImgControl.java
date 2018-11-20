package com.upload.db.uploaddb.model;

import org.springframework.stereotype.Component;

@Component
public class ImgControl {
	
	private boolean[] array = null;
	
	public boolean checkImage(int index, int total){

		if (array == null){
			array = new boolean[total];
		}
		array[index-1] = true;
		
		for (boolean item : array){
			if (item == false) return false;
		}
		return true;
	}
	
}

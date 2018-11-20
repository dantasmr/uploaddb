package com.upload.db.uploaddb.thread;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.upload.db.uploaddb.model.Img;
import com.upload.db.uploaddb.repository.ImgRepository;
import com.upload.db.uploaddb.util.UtilBase64Image;

@Component
@Scope("prototype")
public class ImgThread implements Runnable {

	private static final String PATH = "/Users/xxxx/Documents/xxx/clientimg/";

	private volatile String name;
	
	@Autowired
	ImgRepository imgRepository;

	public ImgThread() {
		
	}
	
	public void setName(String name){
		this.name = name;
	}

	@Override
	public void run() {

		StringBuilder stringbuilder = new StringBuilder();

		List<Img> img = imgRepository.findImageByName(name);
		for (Img item : img) {
			stringbuilder.append(item.getBytes());
		}

		// save Image to C:\\server folder
		String path = ImgThread.PATH + name;
		UtilBase64Image.decoder(stringbuilder.toString(), path);

	}

}
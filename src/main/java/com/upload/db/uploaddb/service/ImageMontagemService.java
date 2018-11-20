package com.upload.db.uploaddb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.upload.db.uploaddb.model.Img;
import com.upload.db.uploaddb.repository.ImgRepository;
import com.upload.db.uploaddb.util.UtilBase64Image;

@Service
public class ImageMontagemService {

	private static final String PATH = "/Users/dantasmr/Documents/Marcelo/mobile_itau/consigapp/clientimg/";


	@Autowired
	ImgRepository imgRepository;

	private StringBuilder stringbuilder = new StringBuilder();

	public String gerarImagem(String name) {

		List<Img> img = imgRepository.findImageByName(name);
		for (Img item : img){
			stringbuilder.append(item.getBytes());
		}
		
		// save Image to C:\\server folder
		String path = ImageMontagemService.PATH + name;
		UtilBase64Image.decoder(stringbuilder.toString(), path);
		return "imagem completa 100%";
	}
		

}

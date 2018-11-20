package com.upload.db.uploaddb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.upload.db.uploaddb.model.ImageUpload;
import com.upload.db.uploaddb.model.Img;
import com.upload.db.uploaddb.model.ImgControl;
import com.upload.db.uploaddb.repository.ImgRepository;
import com.upload.db.uploaddb.service.ImageUploadService;
import com.upload.db.uploaddb.thread.AsynchronousService;

@RestController
public class ImgController {
	
	@Autowired
    private ImgRepository imgRepository;
	
	@Autowired
	ImageUploadService imageUploadService;
	
	@Autowired
	ImgControl imgControl;
	
	@Autowired
	AsynchronousService asynchronousService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestBody ImageUpload imageupload) {
		System.out.println("/POST request with " + imageupload.toString());
		
		
		Img img = new Img();
		img.setNome(imageupload.getName());
		img.setIndex(imageupload.getIndex());
		img.setTotal(imageupload.getTotal());
		img.setBytes(imageupload.getData());
		img.setUpload(false);
		
		imgRepository.save(img);
		
		if (imgControl.checkImage(imageupload.getIndex(), imageupload.getTotal())){
			asynchronousService.executeAsynchronously(imageupload.getName());
		}
		
		
		 return String.format("imagem %s index= %s de + total= %s", imageupload.getName(),
				 imageupload.getIndex(), imageupload.getTotal());
		}
	
	
	
	@RequestMapping(value = "/envio_partes", method = RequestMethod.GET)
	public String envio_partes() {
		System.out.println("Envio de imagem iniciado...");
		imageUploadService.postUploadEntity();
		System.out.println("Envio de imagem finalizado...");
		return "Imagem finalizada!";

	}
	

			
}


package com.upload.db.uploaddb.service;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.upload.db.uploaddb.model.ImageUpload;
import com.upload.db.uploaddb.util.UtilBase64Image;


@Service
public class ImageUploadService {

	private static final String PATH = "/Users/xxxx/Documents/img/";


	RestTemplate restTemplate;
	
	@PostConstruct
	public void init() {
		restTemplate = new RestTemplate();
	}
	
	public void postUploadEntity() {
		System.out.println("Begin /POST request!");
		String name = "demoImage.png";
		String imagePath = ImageUploadService.PATH + "demoImage.jpeg";
		String data = UtilBase64Image.encoder(imagePath);

		String[] dados = getSplitString(data,"UTF-8", 1000000);
		sendHTTP(name, dados, 0);

	
	}
	
	private void sendHTTP(String name, String[] dados, int index){
		String postUrl = "http://localhost:8080/upload";
		int total = dados.length;
		int img = index+1;
		System.out.println("Enviando parte : " + new Integer(img).toString() + " de " + new Integer(total).toString());
		ImageUpload imageupload = new ImageUpload(name, dados[index], total, img);
		ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, imageupload, String.class);
		System.out.println("Response for Post Request: " + postResponse.getBody());
		if (img < total){
			sendHTTP(name, dados, index+1);
		}
		
	}
	
	
	

	private String[] getSplitString(String src,String encoding, int maxsize) {
	    Charset cs = Charset.forName(encoding);
	    CharsetEncoder coder = cs.newEncoder();
	    ByteBuffer out = ByteBuffer.allocate(maxsize);  // output buffer of required size
	    CharBuffer in = CharBuffer.wrap(src);
	    List<String> ss = new ArrayList<>();            // a list to store the chunks
	    int pos = 0;
	    while(true) {
	        CoderResult cr = coder.encode(in, out, true); // try to encode as much as possible
	        int newpos = src.length() - in.length();
	        String s = src.substring(pos, newpos);
	        ss.add(s);                                  // add what has been encoded to the list
	        pos = newpos;                               // store new input position
	        out.rewind();                               // and rewind output buffer
	        if (! cr.isOverflow()) {
	            break;                                  // everything has been encoded
	        }
	    }
	    return ss.toArray(new String[0]);
	}

}
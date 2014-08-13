package com.jl.spring.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.jl.spring.data.DBCard;
import com.jl.spring.validator.UploadItem;

public class FileService {

	public void writeFile(UploadItem uploadItem, DBCard card){
		try {
			MultipartFile file = uploadItem.getFileData();
			InputStream inputStream = null;
			OutputStream outputStream = null;
			
			if(file.getSize() > 0) {
				inputStream = file.getInputStream();
				outputStream = new FileOutputStream("C:\\pliki\\"+card.getIdcard()+"\\"+file.getOriginalFilename());
				int readBytes = 0;
				byte[] buffer = new byte[8192];
				while((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

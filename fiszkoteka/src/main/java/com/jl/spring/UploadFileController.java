package com.jl.spring;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.jl.spring.form.UploadItem;

@Controller
@RequestMapping(value="/uploadfile")
public class UploadFileController {
private String uploadFolderPath;
ServletConfig config;

public String getUploadFolderPath() {
	return uploadFolderPath;
}
public void setUploadFolderPath(String uploadFolderPath) {
	this.uploadFolderPath = uploadFolderPath;
}

@RequestMapping(method=RequestMethod.GET)
public String getUploadForm(Model model) {
	model.addAttribute(new UploadItem());
	return "";

}

@RequestMapping(method=RequestMethod.POST)
public String create(UploadItem uploadItem, HttpServletRequest request, HttpServletResponse response, Object command, BindException errors, HttpSession session){
return null;
}

}

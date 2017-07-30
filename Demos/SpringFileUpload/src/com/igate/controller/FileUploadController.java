package com.igate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.igate.form.FileUploadForm;

@Controller
public class FileUploadController {
	@RequestMapping(value="/fileUpload")
	
	public String uploadFile(Model model){
		model.addAttribute("uploadForm",new FileUploadForm());
		return "fileUpload";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String displayForm() {
		return "file_upload_form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
			Model map) {

		MultipartFile multipartFile = uploadForm.getFile();

		String fileName = "";

		if (multipartFile != null) {
			fileName = multipartFile.getOriginalFilename();

		}
		

		map.addAttribute("files", fileName);
		return "success";
	}


}

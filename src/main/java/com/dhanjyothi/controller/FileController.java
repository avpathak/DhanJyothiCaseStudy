package com.dhanjyothi.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {

	@GetMapping("/showuploadpage")
	public ModelAndView showUploadPage() {

		return new ModelAndView("");
	}

	@PostMapping(value = "/doUpload")
	public ModelAndView saveFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload)
			throws Exception {

		return new ModelAndView("");
	}

	@GetMapping("/viewall")
	public ModelAndView viewAllFiles() {

		return new ModelAndView("");
	}

	@GetMapping("/doDownload/{fileName}")
	public ModelAndView downloadFile(@PathVariable("fileName") String fileName, HttpServletResponse response)
			throws IOException {

		return new ModelAndView("");

	}

}

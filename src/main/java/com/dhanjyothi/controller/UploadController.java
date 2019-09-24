package com.dhanjyothi.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.dhanjyothi.model.UploadFile;

@Controller
public class UploadController {
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView showUpload() {

		return new ModelAndView("");

	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView fileUploadPage(UploadFile uploadFile) throws IOException {

		return new ModelAndView("");

	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ModelAndView fileDownloadPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

		return new ModelAndView("");
	}
}

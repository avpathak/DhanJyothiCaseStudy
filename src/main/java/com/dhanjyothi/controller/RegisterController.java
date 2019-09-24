package com.dhanjyothi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.RegisterService;
import com.dhanjyothi.validator.RegistrationValidator;

@Controller
public class RegisterController {
	
	private static final Logger logger = Logger.getLogger(RegisterController.class);
	
	@Autowired
	private RegistrationValidator registrationValidator;

	@Autowired
	private RegisterService registerService;

	@Value("${filePath}")
	private String fileUploadPath;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		logger.info("Inside Registration controller");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("signup");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveRegister(@ModelAttribute("user") User user, BindingResult bindingResult) {
		logger.info("File Upload Path:" + fileUploadPath);
		logger.info(user);
		//registrationValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("signup");
		}

		logger.info(user);		
		if (user.getUserName().startsWith("admin")) {
			user.setUserStatus("A");
			user.setUserRole("M");
		} else {
			user.setUserStatus("N");
			user.setUserRole("C");
		}
		registerService.saveRegister(user);
		return new ModelAndView("redirect:login");
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ModelAndView getAllUsers() {

		return new ModelAndView("");
	}

}

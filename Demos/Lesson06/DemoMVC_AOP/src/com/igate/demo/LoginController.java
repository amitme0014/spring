package com.igate.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping(value="/showlogin", method=RequestMethod.GET)
	public String showLogin(Model model)
	{
		model.addAttribute("log",new Login());
		return "login";
	}
	
	@RequestMapping(value="/afterlogin", method=RequestMethod.POST)
	public ModelAndView validate(@ModelAttribute("log") @Valid Login log ,BindingResult result)
	{
		if(result.hasErrors())
			return new ModelAndView("login");
		
		System.out.println(log.getUserName());
		if(loginDao.validate(log))
		    return new ModelAndView("success","l",log);
		else
			return new ModelAndView("error");
			
	}
	

}

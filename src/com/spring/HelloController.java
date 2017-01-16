package com.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.spring.LoginBean;

@Controller
public class HelloController  {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "Hellopage";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
			if (loginBean.getUserName().equals("admin") && loginBean.getPassword().equals("admin123")) {
				model.addAttribute("msg", loginBean.getUserName());
				return "success";
			} else {
				model.addAttribute("error", "Invalid Details");
				return "Hellopage";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}
	/*@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("Hellopage");
	}*/

}

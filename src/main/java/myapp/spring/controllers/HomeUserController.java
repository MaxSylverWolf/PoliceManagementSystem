package myapp.spring.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import myapp.spring.controllers.commands.LogonCommand;
import myapp.spring.dao.CriminalDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeUserController{
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	CriminalDao dao;
	
	@RequestMapping(value="/home.html", method = RequestMethod.GET)
	protected String showForm(HttpServletRequest request, Model model)
			throws Exception {
		
		
		return "home";
	}
	
}



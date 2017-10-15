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
public class LogonFormAdminController{
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	CriminalDao dao;
	
	@RequestMapping(value="/logonADMINForm.html", method = RequestMethod.GET)
	protected String showForm(HttpServletRequest request, Model model)
			throws Exception {
		
		LogonCommand logonAdmin = new LogonCommand();
		
		Cookie[] c = request.getCookies();
		if(c!=null){
			for(int i=0; i<c.length; i++){
				if(c[i].getName().equals("login")){
					logonAdmin.setLogin(c[i].getValue());
					logonAdmin.setRemember(true);
				}
			}
		}
		
		model.addAttribute("logonCommand", logonAdmin);
		
		return "logonADMINForm";
	}
	
	
	@RequestMapping(value="/logout2.html", method = RequestMethod.GET)
	protected String logout(HttpSession session)
			throws Exception {
				session.removeAttribute("logInSession");
				log.info("U¿ytkownik zosta³ wylogowany");
		return "redirect:index.html";
	}	
	
	
	@RequestMapping(value="/logonADMINForm.html", method = RequestMethod.POST)
	protected String onSubmit(HttpServletRequest request,
			HttpServletResponse response, @Valid LogonCommand logonAdmin, BindingResult errors, HttpSession session)
			throws Exception {
		
		int cookieLife = 60000;
		
		if(errors.hasErrors()){
			return "logonADMINForm";
		}else if(!dao.checkUser(logonAdmin.getLogin(), logonAdmin.getPassword())){
			log.error("Nie ma u¿ytkownika o parametrach login='"+logonAdmin.getLogin()+"', password='"+logonAdmin.getPassword()+"'");
			errors.rejectValue("login", null, "brak u¿ytkownika o podanym loginie lub hasle");
			return "logonADMINForm";
		}else{
			log.info("U¿ytkownik zosta³ zalogowany");
			
			if(logonAdmin.isRemember()){
				log.info("Zapamiêtywanie u¿ytkownika w cookies");
			
				Cookie c1 = new Cookie("login", logonAdmin.getLogin());
				c1.setMaxAge(cookieLife);
				
				response.addCookie(c1);
			
			}else{
				
				Cookie c1 = new Cookie("login", null);
				c1.setMaxAge(0);
				response.addCookie(c1);
			}
			
			session.setAttribute("logInSession", logonAdmin);
			
			return "redirect:homeADMIN.html";
		}
	}
}



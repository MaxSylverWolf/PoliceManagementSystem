package myapp.spring.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import myapp.spring.controllers.commands.LogonCommand;
import myapp.spring.dao.RegisterDao;
import myapp.spring.domain.Register;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LogonFormController{
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	RegisterDao dao2;
	
	@RequestMapping(value="/logonForm.html", method = RequestMethod.GET)
	protected String showForm(HttpServletRequest request, Model model)
			throws Exception {
		
		LogonCommand logon = new LogonCommand();
		
		Cookie[] c = request.getCookies();
		if(c!=null){
			for(int i=0; i<c.length; i++){
				if(c[i].getName().equals("login")){
					logon.setLogin(c[i].getValue());
					logon.setRemember(true);
				}
			}
		}
		
		model.addAttribute("logonCommand", logon);
		
		return "logonForm";
	}
	
	
	@RequestMapping(value="/logout.html", method = RequestMethod.GET)
	protected String logout(HttpSession session)
			throws Exception {
				session.removeAttribute("logInSession");
				log.info("U¿ytkownik zosta³ wylogowany");
		return "redirect:index.html";
	}	
	
	
	@RequestMapping(value="/logonForm.html", method = RequestMethod.POST)
	protected String onSubmit(HttpServletRequest request,
			HttpServletResponse response, @Valid LogonCommand logon, BindingResult errors, HttpSession session)
			throws Exception {
		
		int cookieLife = 60000;
		
		if(errors.hasErrors()){
			return "logonForm";
		}else if(!dao2.checkUser(logon.getLogin(), logon.getPassword())){
			log.error("Nie ma u¿ytkownika o parametrach login='"+logon.getLogin()+"', password='"+logon.getPassword()+"'");
			errors.rejectValue("login", null, "brak u¿ytkownika o podanym loginie lub hasle");
			return "logonForm";
		}else{
			log.info("U¿ytkownik zosta³ zalogowany");
			
			if(logon.isRemember()){
				log.info("Zapamiêtywanie u¿ytkownika w cookies");
			
				Cookie c1 = new Cookie("login", logon.getLogin());
				c1.setMaxAge(cookieLife);
				
				response.addCookie(c1);
			
			}else{
				
				Cookie c1 = new Cookie("login", null);
				c1.setMaxAge(0);
				response.addCookie(c1);
			}
			
			session.setAttribute("logInSession", logon);
			
			return "redirect:home.html";
		}
	}
}



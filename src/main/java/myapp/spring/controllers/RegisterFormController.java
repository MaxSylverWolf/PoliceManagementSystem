package myapp.spring.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;








import myapp.spring.controllers.commands.LogonCommand;
import myapp.spring.dao.CriminalDao;
import myapp.spring.dao.RegisterDao;
import myapp.spring.domain.Accessory;
import myapp.spring.domain.AccessoryWebEditor;
import myapp.spring.domain.Criminal;
import myapp.spring.domain.CriminalType;
import myapp.spring.domain.Register;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller


public class RegisterFormController {

	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	RegisterDao dao2;
	
	@Autowired
	LocalValidatorFactoryBean validator;
	
	
	@RequestMapping(value="/registerForm.html", method=RequestMethod.GET)
	public String showForm(Model model, @RequestParam(value="id", defaultValue="-1") Long id, HttpSession session){

		
		myapp.spring.domain.Register v = (id>0)?dao2.getRegister(id):new Register();
		
		model.addAttribute("register", v);
		return "registerForm";
	}
	
	@RequestMapping(value="/registerForm.html", method=RequestMethod.POST)
	public String processForm(Model model, @ModelAttribute("register") Register v, BindingResult result){
	
		validator.validate(v, result);
		
		if(v.getLogin()!=null && v.getLogin().equals("SYLVERWOLF"))
			result.rejectValue("login", "wrongName.register.login");
		
		if(result.hasErrors()){

			return "registerForm";
		}
		
		
		List<FieldError> errors =result.getFieldErrors();
		for (FieldError objectError : errors) {
			System.out.println(objectError.getRejectedValue());
		}
		
		
		dao2.saveRegister(v);
		
		return "successRegisterForm";
	}	

	
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }	

}









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
import myapp.spring.dao.DocumentDao;
import myapp.spring.domain.Accessory;
import myapp.spring.domain.AccessoryWebEditor;
import myapp.spring.domain.Criminal;
import myapp.spring.domain.CriminalType;
import myapp.spring.domain.Document;
import myapp.spring.domain.DocumentType;

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

@SessionAttributes(value={"documentTypes, accessories"})
public class DocumentFormController {

	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	DocumentDao dao3;
	
	@Autowired
	LocalValidatorFactoryBean validator;
	
	
	@RequestMapping(value="/documentForm.html", method=RequestMethod.GET)
	public String showForm(Model model, @RequestParam(value="id", defaultValue="-1") Long id, HttpSession session){

		myapp.spring.domain.Document v = (id>0)?dao3.getDocument(id):new Document();
		
		model.addAttribute("document", v);

		return "documentForm";
	}
	
	@RequestMapping(value="/documentForm.html", method=RequestMethod.POST)
	public String processForm(Model model, @ModelAttribute("document") Document v, BindingResult result){
	
		validator.validate(v, result);
		
		if(v.getName()!=null && v.getName().equals("admin"))
			result.rejectValue("name", "wrongName.document.name");
		
		if(result.hasErrors()){

			return "documentForm";
		}
		
		
		List<FieldError> errors =result.getFieldErrors();
		for (FieldError objectError : errors) {
			System.out.println(objectError.getRejectedValue());
		}
		
	
		dao3.saveOrUpdateDocument(v);
		
		return "successDocumentForm";
	}	
	
	
	@ModelAttribute("documentTypes")
	public List<DocumentType> loadTypes(){
		List<DocumentType> types = dao3.getDocumentTypes();
		log.info("£adowanie listy "+types.size()+" typów ");
		return types;
	}
	@ModelAttribute("accessories")
	public List<Accessory> loadAcc(){
		List<Accessory> types = dao3.getAccessories();
		return types;
	}

	@InitBinder
    public void initBinder1(WebDataBinder binder) {
    	binder.registerCustomEditor(Accessory.class, new AccessoryWebEditor());
    }

	
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }	

}









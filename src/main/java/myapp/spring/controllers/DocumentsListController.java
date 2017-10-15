package myapp.spring.controllers;



import myapp.spring.dao.CriminalDao;
import myapp.spring.dao.DocumentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DocumentsListController{
	
	@Autowired
	DocumentDao dao3;

	@RequestMapping(value="/documentList.html", method = RequestMethod.GET)
	protected String handleRequestInternal(ModelMap model) throws Exception {
		
		model.addAttribute("documents", dao3.getAllDocuments());
		return "documentList";
	}
	
	@RequestMapping(value="/documentList.html", method = RequestMethod.GET, params={"did"})
	public String deleteDocument(@RequestParam("did") Long id){
		System.out.println("Usuwanie");
		dao3.deleteDocument(dao3.getDocument(id));

		return "redirect:documentList.html";
	}
	
	@RequestMapping(value="/documentList.html", method = RequestMethod.GET, params={"id"})
	public String showDocumentDetails(Model model, @RequestParam("id") Long id){
		System.out.println("Pokayzwanie szczegu³ów");
		model.addAttribute("document", dao3.getDocument(id));
		return "documentDetails";
	}	
	
	
}

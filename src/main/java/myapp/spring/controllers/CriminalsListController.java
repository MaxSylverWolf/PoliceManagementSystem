package myapp.spring.controllers;



import myapp.spring.dao.CriminalDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CriminalsListController{
	
	@Autowired
	CriminalDao dao;

	@RequestMapping(value="/criminalList.html", method = RequestMethod.GET)
	protected String handleRequestInternal(ModelMap model) throws Exception {
		
		model.addAttribute("criminals", dao.getAllCriminals());
		return "criminalList";
	}
	
	@RequestMapping(value="/criminalList.html", method = RequestMethod.GET, params={"did"})
	public String deleteCriminal(@RequestParam("did") Long id){
		System.out.println("Usuwanie");
		dao.deleteCriminal(dao.getCriminal(id));

		return "redirect:criminalList.html";
	}
	
	@RequestMapping(value="/criminalList.html", method = RequestMethod.GET, params={"id"})
	public String showCriminalDetails(Model model, @RequestParam("id") Long id){
		System.out.println("Pokayzwanie szczegu³ów");
		model.addAttribute("criminal", dao.getCriminal(id));
		return "criminalDetails";
	}	
	
	
}

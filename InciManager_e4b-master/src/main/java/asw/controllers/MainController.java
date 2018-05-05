package asw.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import asw.database.entities.Message;
import asw.services.IncidenceService;

/**
 * 
 * Controlador encargado de las páginas principales de la aplicación,
 * como es el index.
 *
 */
@Controller
public class MainController {
	
	@Autowired
	private IncidenceService inciService;

    @RequestMapping("/index")
    public String index(Model model) {
        return "redirect:/";
    }
    
    @RequestMapping("/")
    public String landing(Model model) {
    	model.addAttribute("message", new Message());
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    
    @RequestMapping("/send")
    public String send(Model model, @ModelAttribute Message message) {
    	inciService.sendIncidence(message);
        return "redirect:/";
    }

}
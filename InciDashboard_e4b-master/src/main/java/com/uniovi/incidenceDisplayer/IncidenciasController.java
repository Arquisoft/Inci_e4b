package com.uniovi.incidenceDisplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.Incidencia;
import com.uniovi.incidenceManager.services.IncidenceService;

/**
 * Controlador encargado de gestionar las direcciones relacionadas con las incidencias.
 */
@Controller
public class IncidenciasController {
	
	@Autowired
	private IncidenceService incidenceService;

	@RequestMapping("/incidencias/location/{id}")
	public String getLocationInci(Model model, @PathVariable Long id) {
		Incidencia incidencia = incidenceService.findById(id);
		if (incidencia != null) {
			model.addAttribute("incid", incidencia);
			return "incidencias/map";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/incidence/update", method=RequestMethod.GET)
	public String updateStatus(@RequestParam Long id, 
				@RequestParam String estado) {
		incidenceService.updateStatusIncidence(id, estado);
		return "incidencias/list";
	}
	
	@RequestMapping(value = "/incidencias/all", method=RequestMethod.GET)
	public String getAll(Model model) {
		//model.addAttribute("incidencias", incidenceService.findAll());
		return "incidencias/all";
	}
}

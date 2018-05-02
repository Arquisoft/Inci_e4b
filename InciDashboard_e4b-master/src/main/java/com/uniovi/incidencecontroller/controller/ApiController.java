package com.uniovi.incidencecontroller.controller;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.incidencecontroller.services.IncidenceService;
import com.uniovi.incidencecontroller.services.OperarioService;

@RestController
public class ApiController {

	@Autowired
	private IncidenceService incidenceService;
	
	@Autowired
	private OperarioService operarioService;
	
	@RequestMapping(value = "/api/incidencias", produces = "application/json")
	public String viewAllIncidences() {
		List<Incidencia> incidencias = incidenceService.findAll();
		return serializeIncidenceList(incidencias);
	}
	
	@RequestMapping(value = "/api/operario/{id}", produces = "application/json")
	public String viewOperaryIncidences(@PathVariable Long id) {
		Operario operario = operarioService.findById(id);
		return serializeIncidenceList( operario.getIncidencias() );
	}
	
	
	public String serializeIncidenceList(List<Incidencia> incidencias) {
		JSONArray serialized = new JSONArray();
		incidencias.forEach(i -> serialized.put( i.toJson() ));
		return serialized.toString();
	}
	
}

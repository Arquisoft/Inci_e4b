package com.uniovi.incidencecontroller.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.assignmentcontroller.assigner.IncidenceAssignerImpl;
import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.entities.extras.Location;

/**
 * Servicio encargado de insertar unos datos iniciales en la base de datos.
 */
@Service
public class IncludeDataService {

	@Autowired
	private OperarioService operarioService;
	
	@Autowired
	private IncidenceService incidenceService;
	
	@Autowired
	private IncidenceAssignerImpl asignadorIncidencias;
	
	@PostConstruct
	public void init() {
		Operario operario1 = new Operario("Jose","000000Z");
		operario1.setPassword("123456");
		operario1.setPasswordConfirm("123456");
		
		Operario operario2 = new Operario("Jose","111111Z");
		operario2.setPassword("123456");
		operario2.setPasswordConfirm("123456");
		
		operarioService.addOperario(operario1);
		operarioService.addOperario(operario2);
		
		
		for(int i=0;i<20;i++) {
			Incidencia incidencia = new Incidencia("Incidencia " + i,"Incidencia de prueba " + i, new Location(i,i));	
			if(i%2==0) {
				HashMap<String,String> campos = new HashMap<String,String>();
				campos.put("Temperatura", "100");
				campos.put("Humo", "50");
				incidencia.setFields(campos);
				List<String> etiquetas = new ArrayList<>();
				etiquetas.add("Incendio");
				incidencia.setTags(etiquetas);
				
			}
			if(i%2==1) {
				HashMap<String,String> campos = new HashMap<String,String>();
				campos.put("Humedad", "20");
				incidencia.setFields(campos);
				List<String> etiquetas = new ArrayList<>();
				etiquetas.add("Lluvias");
				incidencia.setTags(etiquetas);
			}
			incidenceService.saveIncidence(incidencia);
			asignadorIncidencias.assign(incidencia.getId());
		}

		Incidencia incidencia = new Incidencia("Incidencia temperatura","Comprobamos si el filtro de temperatura funciona", new Location(50,50));
		HashMap<String,String> campos = new HashMap<String,String>();
		campos.put("Temperatura", "80");
		incidencia.setFields(campos);
		incidenceService.saveIncidence(incidencia);
	}
	
	
}

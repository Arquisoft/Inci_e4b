package com.uniovi.assignmentcontroller.assigner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.incidencecontroller.services.IncidenceService;
import com.uniovi.incidencecontroller.services.OperarioService;

public class NotificationAssignerImpl implements NotificationAssigner{

	@Autowired
	private OperarioService operarioService;
	
	@Autowired
	private IncidenceService incidenceService;
	
	@Override
	public void assign(Long id) {
		Operario toAssign = chooseOperario();
		Incidencia incidencia = incidenceService.findById(id);
		incidencia.setOperario(toAssign);
		incidenceService.saveIncidence(incidencia);
	}
	
	private Operario chooseOperario() {
		List<Operario> operarios = operarioService.findAll();
		operarios.sort((o1, o2) -> Integer.compare(o1.getIncidencias().size(), o2.getIncidencias().size()));
		
		if(operarios.size()>0)
			return operarios.get(0);
		
		return null;
	}
}

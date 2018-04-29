package com.uniovi.incidencedisplayer;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.Application;
import com.uniovi.entities.Notificacion;
import com.uniovi.entities.Operario;
import com.uniovi.incidencecontroller.services.NotificacionService;
import com.uniovi.incidencecontroller.services.OperarioService;

/**
 * Controlador encargado de gestionar las urls de las notificaciones.
 */
@Controller
public class NotificacionController {
	
	private static Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private NotificacionService ns;
	
	@Autowired
	private OperarioService os;

	/**
	 * Metodo que muestra las notificaciones de un operario 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/notificaciones/list/{id}")
	public String getInvitations(Model model, Pageable pageable, @PathVariable Long id) {
		Page<Notificacion> notificaciones = new PageImpl<Notificacion>(new LinkedList<Notificacion>());
		
		Operario operario = os.findById(id);

		notificaciones = ns.getNotificacionPorOperario(pageable, operario.getId());	
		model.addAttribute("page", notificaciones);
		model.addAttribute("notificaciones", notificaciones.getContent());

		log.info("Listando notificaciones de:"+ operario.getNombre());
		return "redirect:/";
	}
}

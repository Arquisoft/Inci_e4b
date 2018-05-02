package com.uniovi.incidencedisplayer;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@RequestMapping(value = "/notificaciones/list")
	public String getNotificacionesList(Model model, Pageable pageable) {
		Page<Notificacion> notificaciones = new PageImpl<Notificacion>(new LinkedList<Notificacion>());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Operario operario = os.findByDni(auth.getName());

		notificaciones = ns.getNotificacionPorOperario(pageable, operario.getId());

		model.addAttribute("notificaciones", notificaciones.getContent());

		return "/notificaciones/list";
	}

	@RequestMapping(value="/notificaciones/delete/{id}")
	public String deleteNotificacion(@PathVariable Long id) {
		ns.deleteNotificacion(id);
		return "redirect:/notificaciones/list";
	}
}

package asw.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;

import asw.chatbot.ChatBot;
import asw.database.entities.Agent;
import asw.database.entities.Incidence;
import asw.database.entities.extras.Location;
import asw.database.entities.extras.Status;
import asw.services.IncidenceService;

/**
 * 
 * Controlador encargado de las páginas relacionadas con la generación
 * de incidencias.
 *
 */
@Controller
public class InciManagerController {
	@Autowired
	private IncidenceService inciService;

	@RequestMapping(value = "/incidence/add")
	private String GETaddIncidence(HttpSession session, Model model) {
		if (session.getAttribute("agent") == null) {

			return "redirect:/login";
		}

		model.addAttribute("inci", new Incidence());
		model.addAttribute("loc", new Location());
		return "/incidence/add";
	}

	@RequestMapping(value = "/incidence/add", method = RequestMethod.POST)
	private String POSTaddIncidence(HttpSession session, Model model, @ModelAttribute Incidence inci,
			@ModelAttribute Location loc) throws JsonProcessingException {

		Agent agent = (Agent) session.getAttribute("agent");
		
		inci.setLocalizacion(loc);
		inci.setUser(agent.getEmail());
		inci.setStatus(Status.ABIERTA);
		if (inciService.filterIncidence(inci))
			inciService.addIncidence(inci);
		else
			return "redirect:/";

		model.addAttribute("inciId", inci.getId());
		
		inciService.sendIncidence(String.valueOf(inci.getId()));

		return "/incidence/confirm";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "incidence/chatbot")
	private String chatBotGet(Model model, HttpSession session) {

		if (session.getAttribute("agent") == null) {
			return "redirect:/login";
		}

		ChatBot chatBot = ChatBot.getInstance();
		chatBot.resetState();

		ArrayList<String> messages = new ArrayList<String>();
		messages.add(chatBot.getMessage());
		session.setAttribute("messages", messages);
		List<String> reversedMessages = (List<String>) messages.clone();
		Collections.reverse(reversedMessages);
		model.addAttribute("messages", reversedMessages);

		return "/incidence/chatbot";

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="incidence/chatbot", method = RequestMethod.POST)
	private String chatBotPost(HttpSession session, Model model, String answer) throws JsonProcessingException {
		
		ChatBot chatBot = ChatBot.getInstance();
		
		ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
		
		messages.add(answer);
		
		if (!chatBot.isMessageValid(answer)) {
			messages.add(chatBot.getErrorMessage());
			List<String> reversedMessages = (List<String>) messages.clone();
			Collections.reverse(reversedMessages);
			model.addAttribute("messages", reversedMessages);
			return "/incidence/chatbot";
			
		} else {
			chatBot.nextState(answer);
			messages.add(chatBot.getMessage());
			if (!chatBot.isFinished()) {
				List<String> reversedMessages = (List<String>) messages.clone();
				Collections.reverse(reversedMessages);
				model.addAttribute("messages", reversedMessages);
				return "/incidence/chatbot";
				
			} else {
				Incidence i = chatBot.getFinalIncidence();
				Location l = chatBot.getFinalLocation();
				return POSTaddIncidence(session, model, i, l);
			}
		}
		
		
	}

}

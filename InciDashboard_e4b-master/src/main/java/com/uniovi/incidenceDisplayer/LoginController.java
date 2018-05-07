package com.uniovi.incidenceDisplayer;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador encargado de gestionar la vista del login.
 */
@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);
	
    @RequestMapping("/login")
    public String viewLogin() {
    		logger.info("Desplegando vista login");
		return "login";
    }
	
}

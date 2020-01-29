package com.lluis.ServiGest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RutasInicio {

	@GetMapping("/")
	public ModelAndView inicio() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("inicio"); // Nombre de la vista
		
		return model;
	}
}

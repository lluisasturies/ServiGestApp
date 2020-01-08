package com.lluis.ServiGest.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RutasEmpresas {

	@GetMapping("")
	public ModelAndView viviendas() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName(""); // Nombre de la vista
		
		return model;
	}
}

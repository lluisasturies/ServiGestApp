package com.lluis.ServiGest.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lluis.ServiGest.beans.Trabajo;

@Controller
public class RutasTrabajos {
		
	/*
	 * Post que añade un trabajo
	 * 
	 */
	@PostMapping("/trabajos/add")
	public ModelAndView addTrabajo(@ModelAttribute Trabajo trabajo) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/ordenes");
		
		return model;
	}
	
	/*
	 * Post que edita un trabajo
	 * 
	 */	
	@PostMapping("/trabajos/update")
	public ModelAndView updateTrabajo(@ModelAttribute Trabajo trabajo) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/ordenes");
		
		return model;
	}
	
	/*
	 * Post que borra un trabajo
	 * 
	 */
	@PostMapping("/trabajo/delete/{idTrabajo}")
	public ModelAndView deleteTrabajo(@PathVariable Integer idTrabajo) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/ordenes");
		
		return model;
	}
}

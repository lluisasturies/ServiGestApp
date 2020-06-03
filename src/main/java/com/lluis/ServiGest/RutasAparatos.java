package com.lluis.ServiGest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lluis.ServiGest.pojos.Aparato;
import com.lluis.ServiGest.pojos.Orden;

@Controller
public class RutasAparatos {

	/*
	 * Ruta de la lista de aparatos
	 * 
	 */
	@GetMapping("/aparatos")
	public ModelAndView aparatos() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("aparatos/aparatos"); // Nombre de la vista
		
		return model;
	}
	
	
	/*
	 * Post que añade un aparato
	 * 
	 */
	@PostMapping("/aparatos/add")
	public ModelAndView addAparato(@ModelAttribute Aparato aparato) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/aparatos");
		
		return model;
	}
	
	/*
	 * Post que edita un aparato
	 * 
	 */	
	@PostMapping("/aparatos/update")
	public ModelAndView updateVivienda(@ModelAttribute Orden orden) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/ordenes");
		
		return model;
	}
	
	/*
	 * Post que borra un aparato
	 * 
	 */
	@PostMapping("/aparatos/delete/{idAparato}")
	public ModelAndView deleteVivienda(@PathVariable Integer idAparato) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/aparatos");
		
		return model;
	}
	
}

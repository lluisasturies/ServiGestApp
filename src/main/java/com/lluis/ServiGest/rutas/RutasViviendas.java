package com.lluis.ServiGest.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lluis.ServiGest.beans.Vivienda;

@Controller
public class RutasViviendas {

	/*
	 * Ruta de la lista de viviendas
	 * 
	 */
	@GetMapping("/viviendas")
	public ModelAndView viviendas() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("viviendas/viviendas"); // Nombre de la vista
		
		return model;
	}
	
	/*
	 * Ruta de una vivienda {idVivienda}
	 * 
	 */
	@GetMapping("/viviendas/ver/{idVivienda}")
	public ModelAndView verVivienda(@PathVariable Integer idVivienda) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("viviendas/verVivienda"); // Nombre de la vista
		
		return model;
	}
	
	
	/*
	 * Post que añade una vivienda
	 * 
	 */
	@PostMapping("/viviendas/add")
	public ModelAndView addVivienda(@ModelAttribute Vivienda vivienda) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/viviendas");
		
		return model;
	}
	
	/*
	 * Post que edita una vivienda
	 * 
	 */	
	@PostMapping("/viviendas/update")
	public ModelAndView updateVivienda(@ModelAttribute Vivienda vivienda) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/viviendas");
		
		return model;
	}
	
	/*
	 * Post que borra una vivienda
	 * 
	 */
	@PostMapping("/viviendas/delete/{idVivienda}")
	public ModelAndView deleteVivienda(@PathVariable Integer idVivienda) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/viviendas");
		
		return model;
	}
}

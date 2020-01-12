package com.lluis.ServiGest.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lluis.ServiGest.beans.Albaran;

@Controller
public class RutasAlbaranes {
		
	/*
	 * Post que añade un albaran
	 * 
	 */
	@PostMapping("/albaranes/add")
	public ModelAndView addTrabajo(@ModelAttribute Albaran albaran) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/albaranes");
		
		return model;
	}
	
	/*
	 * Post que edita un albaran
	 * 
	 */	
	@PostMapping("/albaranes/update")
	public ModelAndView updateTrabajo(@ModelAttribute Albaran albaran) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/albaranes");
		
		return model;
	}
	
	/*
	 * Post que borra un albaran
	 * 
	 */
	@PostMapping("/albaran/delete/{idAlbaran}")
	public ModelAndView deleteTrabajo(@PathVariable Integer idAlbaran) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/albaranes");
		
		return model;
	}
}

package com.lluis.ServiGest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lluis.ServiGest.pojos.Empresa;
import com.lluis.ServiGest.pojos.Orden;
import com.lluis.ServiGest.repositorios.EmpresaDAO;
import com.lluis.ServiGest.repositorios.OrdenDAO;

@Controller
public class RutasOrdenes {
	
	@Autowired
	private OrdenDAO ordenDAO;
	
	@Autowired
	private EmpresaDAO empresaDAO;
	

	/*
	 * LISTA de Ordenes
	 * 
	 */
	@GetMapping("/ordenes")
	public ModelAndView ordenes() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("ordenes/ordenes"); // Nombre de la vista
		
		return model;
	}
	
	
	/*
	 * VER Orden {idOrden}
	 * 
	 */
	@GetMapping("/ordenes/ver/{idOrden}")
	public ModelAndView verOrden(@PathVariable Integer idOrden) {
		
		ModelAndView model = new ModelAndView();
		
		// Si la orden existe...
		if (ordenDAO.existsById(idOrden)) {
					
			model.setViewName("ordenes/verOrden"); // Nombre de la vista
					
			// Obtengo la orden concreta
			Orden orden = ordenDAO.findById(idOrden).get();
					
			// Lo añado a la vista...
			model.addObject("vivienda", orden);
					
		} 
		else {
			model.setViewName("redirect:/viviendas");
		}
		
		return model;
	}
	
	
	/*
	 * ADD Orden a una Vivienda
	 * 
	 */
	@GetMapping("/ordenes/crear/vivienda/{idVivienda}")
	public ModelAndView crearOrden(@PathVariable Integer idVivienda) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("ordenes/crearOrden"); // Nombre de la vista
		
		model.addObject("orden", new Orden());
		
		List<Empresa> listaEmpresas = (List<Empresa>) empresaDAO.findAll();
		model.addObject("listaEmpresas", listaEmpresas);
		
		model.addObject("idVivienda", idVivienda);
		
		return model;
	}
	
	@PostMapping("/ordenes/add")
	public ModelAndView addOrden(@ModelAttribute Orden orden) {
		
		ModelAndView model = new ModelAndView();
		
		// Obtengo la fecha de hoy y se la coloco
		LocalDate fecha = LocalDate.now();
		orden.setFecha(fecha);
		
		// Guardo la Orden...
		ordenDAO.save(orden);
		
		// Redirijo a la Vivienda
		model.setViewName("redirect:/viviendas/ver/" + orden.getIdVivienda().getIdVivienda());
		
		return model;
	}
	
	
	/*
	 * UPDATE Orden
	 * 
	 */	
	@PostMapping("/ordenes/update")
	public ModelAndView updateOrden(@ModelAttribute Orden orden) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/ordenes");
		
		return model;
	}
	
	/*
	 * DELETE Orden
	 * 
	 */
	@PostMapping("/ordenes/delete/{idOrden}")
	public ModelAndView deleteOrden(@PathVariable Integer idOrden) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/ordenes");
		
		return model;
	}
}

package com.lluis.ServiGest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lluis.ServiGest.pojos.Cliente;
import com.lluis.ServiGest.pojos.Vivienda;
import com.lluis.ServiGest.repositorios.ClienteDAO;
import com.lluis.ServiGest.repositorios.ViviendaDAO;

@Controller
public class RutasClientes {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private ViviendaDAO viviendaDAO;

	/*
	 * Ruta de la lista de clientes
	 * 
	 */
	@GetMapping("/clientes")
	public ModelAndView clientes() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("clientes/clientes"); // Nombre de la vista
		
		List<Cliente> listaClientes = (List<Cliente>) clienteDAO.findAll();
		model.addObject("listaClientes", listaClientes);
		
		return model;
	}
	
	/*
	 * Ruta de un cliente {idCliente}
	 * 
	 */
	@GetMapping("/clientes/ver/{idCliente}")
	public ModelAndView verCliente(@PathVariable Integer idCliente) {
		
		ModelAndView model = new ModelAndView();
		
		// Si el cliente existe...
		if (clienteDAO.existsById(idCliente)) {
					
			model.setViewName("clientes/verCliente"); // Nombre de la vista
					
			// Obtengo el cliente en concreto
			Cliente cliente = clienteDAO.findById(idCliente).get();
					
			// Obtengo la lista de viviendas de este cliente
			List<Vivienda> viviendas = (List<Vivienda>) viviendaDAO.viviendasPorCliente(idCliente);
					
			// Lo añado a la vista...
			model.addObject("cliente", cliente);
			model.addObject("listaViviendas", viviendas);
					
		} 
		else {
			model.setViewName("redirect:/clientes");
		}
		
		return model;
	}
	
	/*
	 * AÑADIR un cliente
	 * 
	 */
	@GetMapping("/clientes/crear")
	public ModelAndView nuevoCliente() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("clientes/crearCliente");
		
		model.addObject("cliente", new Cliente());
		
		return model;
	}
	
	@PostMapping("/clientes/add")
	public ModelAndView addCliente(@ModelAttribute Cliente cliente) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/clientes");
		
		clienteDAO.save(cliente);
		
		return model;
	}
	
	/*
	 * EDITAR un cliente
	 * 
	 */	
	@GetMapping("/clientes/editar/{idCliente}")
	public ModelAndView editarCliente(@PathVariable Integer idCliente) {
		
		ModelAndView model = new ModelAndView();
		
		// Si el cliente existe...
		if (clienteDAO.existsById(idCliente)) {
					
			model.setViewName("clientes/editarCliente"); // Nombre de la vista
					
			// Obtengo el cliente en concreto
			Cliente cliente = clienteDAO.findById(idCliente).get();
										
			// Lo añado a la vista...
			model.addObject("cliente", cliente);
					
		} 
		else {
			model.setViewName("redirect:/clientes");
		}
		
		return model;
	}
	
	@PostMapping("/clientes/update")
	public ModelAndView updateCliente(@ModelAttribute Cliente cliente) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/clientes");
		
		return model;
	}
	
	/*
	 * Post que borra un cliente
	 * 
	 */
	@PostMapping("/clientes/delete/{idCliente}")
	public ModelAndView deleteVivienda(@PathVariable Integer idCliente) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/clientes");
		
		return model;
	}
}

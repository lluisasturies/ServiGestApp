package com.lluis.ServiGest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lluis.ServiGest.pojos.Albaran;
import com.lluis.ServiGest.servicios.AlbaranService;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/albaranes")
public class AlbaranController {
	
	@Autowired
	AlbaranService albaranService;
	
	// Obtener LISTA de Albaranes
	@GetMapping
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public List<Albaran> listaAlbaranes(){
		return albaranService.listaAlbaranes();
	}
	
	// Obtener UN Albaran
	@GetMapping("/{idAlbaran}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public Albaran verAlbaran(@PathVariable("idAlbaran") Integer idAlbaran) {
		return albaranService.verAlbaran(idAlbaran);
	}
	
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Albaran albaran) {
		albaranService.add(albaran);
	}
	
	// UPDATE
	@PutMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Albaran albaran) {
		albaranService.update(albaran);
	}
	
	// DELETE
	@DeleteMapping("/delete/{idAparato}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idAlbaran") Integer idAlbaran) {
		albaranService.delete(idAlbaran);
	}

}

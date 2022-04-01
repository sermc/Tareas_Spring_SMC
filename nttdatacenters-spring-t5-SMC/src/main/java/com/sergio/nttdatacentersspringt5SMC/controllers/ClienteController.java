package com.sergio.nttdatacentersspringt5SMC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.nttdatacentersspringt5SMC.entity.Cliente;
import com.sergio.nttdatacentersspringt5SMC.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteService servicio;
	
	@RequestMapping(value="listar", method = RequestMethod.GET,produces = "application/json")
	public List<Cliente> getClientes(Model modelAndView){
		return servicio.buscarTodos();
	}
	
	@PostMapping("insert")
	public Cliente insertCliente(@RequestBody Cliente c,Model modelAndView) {		
		return servicio.insert(c);
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteCliente(@PathVariable Long id,Model modelAndView) {
		return servicio.delete(id);
	}
	
	@RequestMapping(value="searchByName/{nombre}", method = RequestMethod.GET,produces = "application/json")
	public List<Cliente> getClientesByName(@PathVariable("nombre") String nombre){
		return servicio.findByNombreIgnoreCaseLike(nombre);
	}
}

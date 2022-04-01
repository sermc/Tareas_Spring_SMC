package com.sergio.nttdatacentersspringt4SMC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sergio.nttdatacentersspringt4SMC.entity.Cliente;
import com.sergio.nttdatacentersspringt4SMC.service.ClienteService;

@Controller
@RequestMapping("/*")
public class ClienteController {
	
	@Autowired
	ClienteService servicio;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String inicio() {
		return "index";
	}
	
	@RequestMapping(value="consulta", method = RequestMethod.GET)
	public String consulta() {
		return "consulta";
	}
	
	@RequestMapping(value="addCliente", method = RequestMethod.GET)
	public String addCliente(Model mode) {
		mode.addAttribute("cliente",new Cliente());
		return "addCliente";
	}
	
	@RequestMapping(value="listar", method = RequestMethod.GET)
	public String getClientes(Model modelAndView){
		List<Cliente> clientes = servicio.buscarTodos();
		
		modelAndView.addAttribute("clientes",clientes);
		
		return "listadoClientes";
	}
	
	@PostMapping("insert")
	public String insertCliente(@ModelAttribute("cliente") Cliente c,Model modelAndView) {
		servicio.insert(c);
		
		List<Cliente> clientes = servicio.buscarTodos();
		
		modelAndView.addAttribute("clientes",clientes);
		
		return "listadoClientes";
	}
	
	@RequestMapping(value="update", method = RequestMethod.PUT)
	public void updateCliente() {
		
	}
	
	@RequestMapping(value="delete", method = RequestMethod.POST)
	public String deleteCliente(@ModelAttribute("clienteId") Long id,Model modelAndView) {
		
		servicio.delete(id);
		
		List<Cliente> clientes = servicio.buscarTodos();
		
		modelAndView.addAttribute("clientes",clientes);
		
		return "listadoClientes";
	}
	
	@RequestMapping(value="searchByName", method = RequestMethod.POST)
	public String getClientesByName(@ModelAttribute("nombre") String nombre, Model modelAndView){
		
		List<Cliente> c = servicio.findByNombreIgnoreCaseLike(nombre);
		
		//List<Cliente> c = servicio.buscarTodos();
		
		modelAndView.addAttribute("clientes",c);
		
		//modelAndView.addAttribute("dni",nombre);
		
		return "listadoClientes";
	}
}

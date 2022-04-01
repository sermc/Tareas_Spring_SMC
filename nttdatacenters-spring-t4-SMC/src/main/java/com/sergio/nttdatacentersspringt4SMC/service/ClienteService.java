package com.sergio.nttdatacentersspringt4SMC.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.nttdatacentersspringt4SMC.entity.Cliente;
import com.sergio.nttdatacentersspringt4SMC.repository.ClienteRepository;


@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repositorio;
	
	public void insert (Cliente c) {
		repositorio.save(c);
	}
	
	public void delete (Long c) {
		if(repositorio.findById(c).isPresent()) {
			repositorio.deleteById(c);
		}
	}
	
	public void update (Cliente c) {
		long num = c.getId();
		
		if(repositorio.findById(num).isPresent()) {
			Cliente clieToUpdate = repositorio.getById(num);
			
			if(c.getNombre() != null) {
				clieToUpdate.setNombre(c.getNombre());
			}
			
			if(c.getApellidos() != null) {
				clieToUpdate.setApellidos(c.getApellidos());
			}
			
			if(c.getFechaNacimiento() != null) {
				clieToUpdate.setFechaNacimiento(c.getFechaNacimiento());
			}
			
			if(c.getDni() != null) {
				clieToUpdate.setDni(c.getDni());
			}
			
			repositorio.save(clieToUpdate);
		}
	}
	
	public List<Cliente> buscarTodos() {
		return this.repositorio.findAll();
	}
	
	public Cliente findByNombreAndApellidosIgnoreCaseLike(String nombre, String apellidos) {
		return repositorio.findByNombreAndApellidosIgnoreCaseLike(nombre, apellidos);
	}
	
	public List<Cliente> findByNombreIgnoreCaseLike(String nombre) {
		return repositorio.findByNombreIgnoreCaseLike(nombre);
	}

}

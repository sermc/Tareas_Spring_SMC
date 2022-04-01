package com.sergio.nttdatacentersspringt5SMC.entity;

import javax.persistence.*;

@Entity
@Table(name="CLIENTE")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="NOMBRE",nullable=false)
	private String nombre;
	
	@Column(name="APELLIDOS",nullable=false)
	private String apellidos;
	
	@Column(name="FECHA_NACIMIENTO",nullable=false)
	private String fechaNacimiento;
	
	@Column(name="dni",unique=true,nullable=false,length=9)
	private String dni;

	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellidos, String fechaNacimiento, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
}

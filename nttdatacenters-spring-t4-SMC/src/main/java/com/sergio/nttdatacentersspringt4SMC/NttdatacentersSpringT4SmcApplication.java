package com.sergio.nttdatacentersspringt4SMC;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sergio.nttdatacentersspringt4SMC.entity.Cliente;
import com.sergio.nttdatacentersspringt4SMC.repository.ClienteRepository;

@SpringBootApplication
public class NttdatacentersSpringT4SmcApplication {

	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersSpringT4SmcApplication.class, args);
		
		
	}
	
	@Bean
	CommandLineRunner init(ClienteRepository repositorio) {
		return (args) -> {
			repositorio.saveAll(
					Arrays.asList(
							new Cliente("Antonio", "Garcia Rosales", "12/03/12", "49545488S"),
							new Cliente("Jesus", "Garcia Rosales",  "12/03/12", "49545428S"),
							new Cliente("Pepe", "Sanchez Garcia",  "12/03/12", "49545481S"),
							new Cliente("Laura", "Perez Rodriguez",  "12/03/12", "49545588S"),
							new Cliente("Sara", "Diaz Perez",  "12/03/12", "49545487S"),
							new Cliente("Antonio", "Olmo Rosales",  "12/03/12", "49245488S")
							)
					);
		};
	}

}

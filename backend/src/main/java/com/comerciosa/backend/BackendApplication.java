package com.comerciosa.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
	-Modificadores de acesso-
	public, protected, (default), private
	public -> pode acessar de qualquer lugar
	(default) -> 
 */

// API REST

@RestController
@SpringBootApplication
public class BackendApplication {

	@RequestMapping("/")
	String home() {
		return "Hello world!";
	}

	@RequestMapping("/cliente")
	String listarClientes() {
		return "<h1>Listando clientes...</h1>";
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}

package com.utn.ejer01;

import com.utn.ejer01.entidades.Persona;
import com.utn.ejer01.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejer01Application {

	@Autowired
	PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ejer01Application.class, args);
		System.out.println("Estoy funcionado hoy");
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepo) {
		return args -> {
			System.out.println("------------ESTOY FUNCIONANDO------------");
			Persona persona = new Persona();
			persona.setNombre("Damian");
			persona.setApellido("Aguero");
			persona.setEdad(22);

			//Guarda el objetivo Persona desde la base de datos
			personaRepository.save(persona);

			// Recuperar el objeto Persona desde la base de datos
			Persona personaRecuperada = personaRepository.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
			}
		};
	}
}

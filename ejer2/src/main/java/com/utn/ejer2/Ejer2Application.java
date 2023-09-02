package com.utn.ejer2;

import com.utn.ejer2.entidades.Domicilio;
import com.utn.ejer2.entidades.Persona;
import com.utn.ejer2.repositorios.DomicilioRepository;
import com.utn.ejer2.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejer2Application {

    @Autowired
    PersonaRepository PersonaRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ejer2Application.class, args);
    }

    @Bean
    CommandLineRunner init(PersonaRepository PersonaRepo) {
        return args -> {
            System.out.println("-------------ESTOY FUNCIONANDO------------");
			/*El método builder() se genera automáticamente por Lombok
			y te permite crear una instancia de Persona.Builder.
            Luego, puedes encadenar llamadas a los métodos
            setters generados automáticamente para establecer los
            valores de los atributos de la clase.
            Finalmente, build() crea la instancia
            de la clase Persona con los valores proporcionados.*/

            Persona persona = Persona.builder()
                    .nombre("Damian")
                    .apellido("Aguero")
                    .edad(22)
                    .build();

            Domicilio domicilio = Domicilio.builder()
                    .calle("Batalla de Maipu")
                    .numero(120)
                    .build();

            // Asocio el domicilio
            persona.setDomicilio(domicilio);

            // Guardar el objeto Persona en la base de datos

            PersonaRepository.save(persona);

            // Recuperar el objeto Persona desde la base de datos
            Persona personaRecuperada = PersonaRepository.findById(persona.getId()).orElse(null);
            if (personaRecuperada != null) {
                System.out.println("Nombre: " + personaRecuperada.getNombre());
                System.out.println("Apellido: " + personaRecuperada.getApellido());
                System.out.println("Edad: " + personaRecuperada.getEdad());
                System.out.println("Calle: " + personaRecuperada.getDomicilio().getCalle());
                System.out.println("Número: " + personaRecuperada.getDomicilio().getNumero());
            }

        };
    }
}

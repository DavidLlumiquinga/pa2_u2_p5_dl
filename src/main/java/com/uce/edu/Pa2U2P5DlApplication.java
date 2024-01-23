package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.service.ICiudadanoService;

@SpringBootApplication
public class Pa2U2P5DlApplication implements CommandLineRunner {

	// 1. Query (Usa JPQL)
	// 1.1 TypedQuery: Conocemos el tipo de dato retornamos
	// 1.2 NamedQuery: Declarar de una manera centralizada

	// 2 Native Query: Es usar SQL nativo, cuando el rendimiento prevalece ante a la
	// POO
	// Cuando se realiza una busqueda en SQL es muy sencilla con Hibernate
	// 3. Criteria API Query

	@Autowired
	private ICiudadanoService iCiudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Ciudadano ciu = this.iCiudadanoService.buscarPorApellido("Llumiquinga");
		System.out.println(ciu);

		Ciudadano ciu1 = this.iCiudadanoService.buscarPorCriteria("David", "Llumiquinga", "1725896110");
		System.out.println(ciu1);

		Ciudadano ciu2 = this.iCiudadanoService.buscarPorCriteria("Juan", "Lopez", "0589668541");
		System.out.println(ciu2);

		System.out.println("Criteria API Query AND OR");
		
		Ciudadano ciu3 = this.iCiudadanoService.buscarPorCriteriaAndOr("David", "Llumiquinga2", "1725896110");
		System.out.println(ciu3);
		
		Ciudadano ciu4 = this.iCiudadanoService.buscarPorCriteriaAndOr("David", "Llumiquinga2", "1725896110");
		System.out.println(ciu4);

		
	}
}

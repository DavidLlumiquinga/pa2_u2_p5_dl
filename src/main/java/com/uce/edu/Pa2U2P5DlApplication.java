package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.IHotelService;

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
	private IHotelService iHotelService;

	@Autowired
	private IAutorService iAutorService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("HOTEL");

		Hotel hot1 = this.iHotelService.buscarPorNombre("Hotel La Basilica");
		System.out.println(hot1);

		Hotel hot2 = this.iHotelService.buscarPorDireccion("Basilica Nacional");
		System.out.println(hot2);

		System.out.println("AUTOR");

		Autor aut1 = this.iAutorService.buscarPorNombre("Mario");
		System.out.println(aut1);

		Autor aut2 = this.iAutorService.buscarPorApellido("Vargas Llosa");
		System.out.println(aut2);

		Autor aut3 = this.iAutorService.buscarPorNombre("Gabriel");
		System.out.println(aut3);

		Autor aut4 = this.iAutorService.buscarPorNacionalidad("Argentino");
		System.out.println(aut4);

		Autor aut5 = this.iAutorService.buscarPorApellido("Garcia Marquez");
		System.out.println(aut5);

	}
}

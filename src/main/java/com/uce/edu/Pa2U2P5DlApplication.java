package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;
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
	private IHabitacionService iHabitacionService;
	
	@Autowired
	private IEstudianteService iEstudianteService;
	
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

		//TYPEDQUERY
		List<Habitacion> hab1=this.iHabitacionService.buscarPorNumeroHabitacion("1A");
		System.out.println(hab1);
		
		List<Habitacion> hab2=this.iHabitacionService.buscarPorPrecio(new BigDecimal(120));
		System.out.println(hab2);
		
		List<Estudiante> est1=this.iEstudianteService.buscarPorNombre("David");
		System.out.println(est1);
		
		List<Estudiante> est2=this.iEstudianteService.buscarPorCedula("172586110");
		System.out.println(est2);
		
		List<Estudiante> est3=this.iEstudianteService.buscarPorFechaNacimiento(LocalDateTime.of(2024, 1, 8, 13, 19));
		System.out.println(est3);
		
		
		//NATIVEQUERY
		
		Hotel hotel=this.iHotelService.buscarPorNombre("Hotel La Basilica");
		System.out.println(hotel);
		
		Hotel hotel1=this.iHotelService.buscarPorDireccion("Basilica Nacional");
		System.out.println(hotel1);
		
		Autor autor=this.iAutorService.buscarPorNombre("Mario Vargas Llosa");
		System.out.println(autor);
		
		Autor autor1=this.iAutorService.buscarPorApellido("Vargas Llosa");
		System.out.println(autor1);
		
		Autor autor2=this.iAutorService.buscarPorNacionalidad("Argentino");
		System.out.println(autor2);
		
	}
}

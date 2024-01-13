package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5DlApplication implements CommandLineRunner {

	//1. Query (Usa JPQL)
	//1.1 TypedQuery: Conocemos el tipo de dato retornamos
	//1.2 NamedQuery: Declarar de una manera centralizada 
	
	//2 Native Query
	//3. Criteria API Query
	
	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("QUERY");
		List<Libro> lista=this.iLibroService.buscarPorFechaPublicacion(LocalDateTime.of(2023, 1, 1, 7, 15));
		for(Libro libro: lista) {
			System.out.println(libro);
			
		}
		
		System.out.println("TYPED-QUERY");
		Libro li1=this.iLibroService.buscarPorTitulo("Mi primer programa");
		System.out.println(li1);
		
		
		List <Libro> lista2=this.iLibroService.buscarPorFecha(LocalDateTime.of(2024, 1, 7, 7, 15));
		for(Libro libro2: lista2) {
			System.out.println(libro2);
			
		}
		
		System.out.println("NAMED-QUERY");
		Libro li2=this.iLibroService.buscarPorTituloNamed("Cien años de soledad");
		System.out.println(li2);
		
		
		List <Libro> lista3=this.iLibroService.buscarPorFecha(LocalDateTime.of(2024, 1, 7, 7, 15));
		for(Libro libro3: lista3) {
			System.out.println(libro3);
			
		}
	}

}

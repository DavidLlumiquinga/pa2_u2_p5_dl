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

	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Libro2 libro2 = new Libro2();
		libro2.setTitulo("Mi primer programa");
		libro2.setFechaPublicacion(LocalDateTime.now());

		Autor2 autor2 = new Autor2();
		autor2.setNombre("Juana Arcos");
		autor2.setNacionalidad("Colombiana");

		Autor2 autor1 = new Autor2();
		autor1.setNombre("Manuel Medrano");
		autor1.setNacionalidad("Peruano");

		// Ingresar los autores por una lista
		List<Autor2> autores = new ArrayList<Autor2>();
		autores.add(autor1);
		autores.add(autor2);

		// Set de autoLibro
		AutorLibro autorLibro = new AutorLibro();
		autorLibro.setLibro2(libro2);
		autorLibro.setAutor2(autor2);
		autorLibro.setFecha(LocalDateTime.now());

		AutorLibro autorLibro2 = new AutorLibro();
		autorLibro2.setLibro2(libro2);
		autorLibro2.setAutor2(autor1);
		autorLibro2.setFecha(LocalDateTime.now());
		
		// Colocar en una lista AutorLibro
		List<AutorLibro> lista = new ArrayList<>();
		lista.add(autorLibro);
		lista.add(autorLibro2);

		libro2.setAutoresLibros(lista);

		//this.iLibroService.guardar(libro2);

		Libro libro=this.iLibroService.buscarPorNombre("Mi primer programa");
		System.out.println(libro);
	}

}

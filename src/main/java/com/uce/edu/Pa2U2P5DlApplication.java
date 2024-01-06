package com.uce.edu;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
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

		Libro libro = new Libro();
		libro.setTitulo("Mi primer programa");
		libro.setFechaPublicacion(LocalDateTime.now());
		

		Autor autor = new Autor();
		autor.setNombre("David");
		autor.setNacionalidad("Ecuatoriano");
		// autor.setLibros(null);

		Autor autor1 = new Autor();
		autor1.setNombre("Manuel");
		autor1.setNacionalidad("Ecuatoriano");

		Set<Autor> autores = new HashSet<Autor>();
		autores.add(autor1);
		autores.add(autor);
		
		libro.setAutores(autores);
		
		Set<Libro> libros=new HashSet<>();
		libros.add(libro);
		
		autor1.setLibros(libros);
		autor.setLibros(libros);
		
		this.iLibroService.guardar(libro);
		
		
	}

}

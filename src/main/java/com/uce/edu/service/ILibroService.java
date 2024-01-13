package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {

	public void guardar(Libro libro);

	public void guardar(Libro2 libro2);

	public Libro buscarPorNombre(String nombre);

	public List<Libro> buscarPorFechaPublicacion(LocalDateTime fechaPublicacion);

	//TYPED QUERY
	public Libro buscarPorTitulo(String titulo);

	public List<Libro> buscarPorFecha(LocalDateTime fecha);
	
	//NAMED QUERY'
	public Libro buscarPorTituloNamed(String titulo);

	public List<Libro> buscarPorFechaNamed(LocalDateTime fecha);
}

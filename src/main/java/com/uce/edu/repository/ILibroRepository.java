package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroRepository {

	public void insertar(Libro libro);
	public void insertar(Libro2 libro2);
	public Libro seleccionarPorNombre(String nombre);
	public Libro seleccionarPorTitulo(String titulo);
	//TYPED QUERY
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion);
	public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion);
	//NAMED QUERY
	public Libro seleccionarPorTituloNamed(String titulo);
	public List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion);
}

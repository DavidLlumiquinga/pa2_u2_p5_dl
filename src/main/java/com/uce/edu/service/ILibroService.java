package com.uce.edu.service;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {

	public void guardar(Libro libro);
	public void guardar(Libro2 libro2);
	public Libro buscarPorNombre(String nombre);
	
	
}

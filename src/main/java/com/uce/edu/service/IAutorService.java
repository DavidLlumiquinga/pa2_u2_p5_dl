package com.uce.edu.service;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorService {
	public Autor buscar(Integer id);

	public void guardar(Autor autor);

	public void actualizar(Autor autor);

	public Autor buscarPorNombre(String nombre);

	public Autor buscarPorApellido(String apellido);

	public Autor buscarPorNacionalidad(String nacionalidad);

}

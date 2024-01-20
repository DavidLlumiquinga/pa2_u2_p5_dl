package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorRespository {

	public void insertar(Autor autor);
	public  Autor seleccionar(Integer id);
	public void actualizar(Autor autor);
	
	public Autor seleccionarPorNombre(String nombre);

	public Autor seleccionarPorApellido(String apellido);
	public Autor seleccionarPorNacionalidad(String nacionalidad);
}

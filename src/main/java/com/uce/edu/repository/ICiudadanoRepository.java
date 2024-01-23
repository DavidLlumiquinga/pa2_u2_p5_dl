package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;

public interface ICiudadanoRepository {
	public void insertar(Ciudadano ciudadano);
	public Ciudadano seleccionar(Integer id);
	public void actualizar (Ciudadano ciudadano);
	public void borrar(Integer id);
	public Ciudadano seleccionarPorApellido(String apellido);
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula);
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);
}

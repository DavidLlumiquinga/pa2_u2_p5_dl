package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlumnoRepository {

	public Alumno seleccionar(String  id);
	public void insertar(Alumno alumno);
	public void actualizar(Alumno alumno);
	public void elmininar(String id);
}

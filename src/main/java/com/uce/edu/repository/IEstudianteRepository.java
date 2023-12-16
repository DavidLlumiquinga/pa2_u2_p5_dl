package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public Estudiante seleccionar(String id);
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void elmininar(String id);
}

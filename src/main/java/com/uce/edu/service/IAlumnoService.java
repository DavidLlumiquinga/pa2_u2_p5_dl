package com.uce.edu.service;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlumnoService {


	public Alumno buscar(String id);

	public void registrar(Alumno alumno);

	public void actualizar(Alumno alumno);

	public void eliminar(String id);
}

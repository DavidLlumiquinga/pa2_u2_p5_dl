package com.uce.edu.service;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlumnoService {

	public void guardar(Alumno alumno);

	public Alumno buscar(Integer id);

	public void actualizar(Alumno alumno);

	public void eliminar(Integer id);

}

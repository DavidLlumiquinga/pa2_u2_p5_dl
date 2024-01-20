package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public Estudiante seleccionar(Integer id);
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void eliminar(Integer id);
	public List<Estudiante> seleccionarPorNombre(String nombre);
	public List<Estudiante> seleccionarPorCedula(String cedula);
	public List<Estudiante> seleccionarPorFechaNacimiento(LocalDateTime fechaNacimiento);
}

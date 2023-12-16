package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAlumnoRepository;
import com.uce.edu.repository.modelo.Alumno;

@Service
public class AlumnoServiceImpl implements IAlumnoService{

	
	@Autowired
	private IAlumnoRepository iAlumnoRepository;
	
	@Override
	public Alumno buscar(String id) {
		// TODO Auto-generated method stub
		return this.iAlumnoRepository.seleccionar(id);
	}

	@Override
	public void registrar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.iAlumnoRepository.insertar(alumno);
	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.iAlumnoRepository.actualizar(alumno);
	}

	@Override
	public void eliminar(String id) {
		// TODO Auto-generated method stub
		this.iAlumnoRepository.elmininar(id);
	}

}

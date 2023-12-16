package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl  implements IEstudianteService{

	@Autowired
	private IEstudianteRepository iestudianteRepository;
	@Override
	public Estudiante buscar(String id) {
		// TODO Auto-generated method stub
		return this.iestudianteRepository.seleccionar(id);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iestudianteRepository.actualizar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iestudianteRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(String id) {
		// TODO Auto-generated method stub
		this.iestudianteRepository.elmininar(id);
	}

}

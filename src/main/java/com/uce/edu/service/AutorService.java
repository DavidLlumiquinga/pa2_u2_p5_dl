package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAutorRespository;
import com.uce.edu.repository.modelo.Autor;

@Service

public class AutorService implements IAutorService {

	@Autowired
	private IAutorRespository iAutorRespository;

	@Override
	public Autor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iAutorRespository.seleccionar(id);
	}

	@Override
	public void guardar(Autor autor) {
		// TODO Auto-generated method stub
		this.iAutorRespository.insertar(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.iAutorRespository.actualizar(autor);
	}

	@Override
	public Autor buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iAutorRespository.seleccionarPorNombre(nombre);
	}

	@Override
	public Autor buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.iAutorRespository.seleccionarPorApellido(apellido);
	}

	@Override
	public Autor buscarPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		return this.iAutorRespository.seleccionarPorNacionalidad(nacionalidad);
	}

}

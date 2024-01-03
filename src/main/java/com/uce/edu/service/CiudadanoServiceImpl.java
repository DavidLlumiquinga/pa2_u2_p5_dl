package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.CiudadanoRepositoryImpl;
import com.uce.edu.repository.modelo.Ciudadano;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private CiudadanoRepositoryImpl iCiudadanoRepositoryImpl;
	@Override
	public void guardar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepositoryImpl.insertar(ciudadano);
	}
	@Override
	public Ciudadano buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepositoryImpl.seleccionar(id);
	}
	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepositoryImpl.actualizar(ciudadano);
	}
	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepositoryImpl.borrar(id);
	}
	
	

}

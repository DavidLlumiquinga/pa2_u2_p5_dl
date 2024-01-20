package com.uce.edu.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHabitacionRespository;
import com.uce.edu.repository.modelo.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

	@Autowired
	private IHabitacionRespository iHabitacionRespository;

	@Override
	public Habitacion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iHabitacionRespository.seleccionar(id);
	}

	@Override
	public void guardar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.iHabitacionRespository.insertar(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.iHabitacionRespository.actualizar(habitacion);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iHabitacionRespository.eliminar(id);
	}

	@Override
	public List<Habitacion> buscarPorPrecio(BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.iHabitacionRespository.seleccionarPorPrecio(precio);
	}

	@Override
	public List<Habitacion> buscarPorNumeroHabitacion(String numero) {
		// TODO Auto-generated method stub
		return this.iHabitacionRespository.seleccionarPorNumeroHabitacion(numero);
	}
	
	
	
}

package com.uce.edu.repository;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.repository.modelo.Habitacion;

public interface IHabitacionRespository {

	public Habitacion seleccionar(Integer id);

	public void insertar(Habitacion habitacion);

	public void actualizar(Habitacion habitacion);

	public void eliminar(Integer id);
	
	public List<Habitacion> seleccionarPorPrecio(BigDecimal precio);
	
	public List<Habitacion> seleccionarPorNumeroHabitacion(String numero);
}

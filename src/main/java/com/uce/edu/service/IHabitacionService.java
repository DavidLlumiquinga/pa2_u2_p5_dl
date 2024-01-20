package com.uce.edu.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.repository.modelo.Habitacion;

public interface IHabitacionService {

	public Habitacion buscar(Integer id);

	public void guardar(Habitacion habitacion);

	public void actualizar(Habitacion habitacion);

	public void eliminar(Integer id);
	
public List<Habitacion> buscarPorPrecio(BigDecimal precio);
	
	public List<Habitacion> buscarPorNumeroHabitacion(String numero);
}

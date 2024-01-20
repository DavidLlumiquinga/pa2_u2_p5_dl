package com.uce.edu.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionRespository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Habitacion seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(habitacion);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Habitacion habi = this.seleccionar(id);
		this.entityManager.remove(habi);
	}

	@Override
	public List<Habitacion> seleccionarPorPrecio(BigDecimal precio) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQuery = this.entityManager
				.createQuery("select p from Habitacion p where p.precio = : precio", Habitacion.class);
		myQuery.setParameter("precio", precio);
		return myQuery.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarPorNumeroHabitacion(String numero) {
		TypedQuery<Habitacion> myQuery = this.entityManager
				.createQuery("select n from Habitacion n where n.numero = : numero", Habitacion.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getResultList();
	}

}

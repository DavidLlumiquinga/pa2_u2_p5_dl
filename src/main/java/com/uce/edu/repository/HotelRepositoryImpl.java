package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel hote = this.seleccionar(id);
		this.entityManager.remove(hote);
	}

	@Override
	public Hotel seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Hotel> myCriteriaQuery = builder.createQuery(Hotel.class);

		Root<Hotel> tablaFrom = myCriteriaQuery.from(Hotel.class);

		Predicate condicionNombre = builder.equal(tablaFrom.get("nombre"), nombre);

		myCriteriaQuery.select(tablaFrom).where(condicionNombre);

		TypedQuery<Hotel> typedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return typedQuery.getSingleResult();
	}

	@Override
	public Hotel seleccionarPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Hotel> myCriteriaQuery = builder.createQuery(Hotel.class);

		Root<Hotel> tablaFrom = myCriteriaQuery.from(Hotel.class);

		Predicate condicionDireccion = builder.equal(tablaFrom.get("direccion"), direccion);

		myCriteriaQuery.select(tablaFrom).where(condicionDireccion);

		TypedQuery<Hotel> typedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return typedQuery.getSingleResult();
	}

}

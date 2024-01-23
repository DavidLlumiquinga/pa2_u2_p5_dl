package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;

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
public class AutorRepositoryImpl implements IAutorRespository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public Autor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor.class, id);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(autor);
	}

	@Override
	public Autor seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Autor> myCriteriaQuery = builder.createQuery(Autor.class);

		Root<Autor> tablaFrom = myCriteriaQuery.from(Autor.class);

		Predicate condicionNombre = builder.equal(tablaFrom.get("nombre"), nombre);

		myCriteriaQuery.select(tablaFrom).where(condicionNombre);

		TypedQuery<Autor> typedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return typedQuery.getSingleResult();
	}

	@Override
	public Autor seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Autor> myCriteriaQuery = builder.createQuery(Autor.class);

		Root<Autor> tablaFrom = myCriteriaQuery.from(Autor.class);

		Predicate condicionApellido = builder.equal(tablaFrom.get("apellido"), apellido);

		myCriteriaQuery.select(tablaFrom).where(condicionApellido);

		TypedQuery<Autor> typedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return typedQuery.getSingleResult();
	}

	@Override
	public Autor seleccionarPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Autor> myCriteriaQuery = builder.createQuery(Autor.class);

		Root<Autor> tablaFrom = myCriteriaQuery.from(Autor.class);

		Predicate condicionNacionalidad = builder.equal(tablaFrom.get("nacionalidad"), nacionalidad);

		myCriteriaQuery.select(tablaFrom).where(condicionNacionalidad);

		TypedQuery<Autor> typedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return typedQuery.getSingleResult();
	}
}

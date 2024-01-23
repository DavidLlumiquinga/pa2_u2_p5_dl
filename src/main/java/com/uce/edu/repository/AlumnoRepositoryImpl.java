package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Alumno;
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
public class AlumnoRepositoryImpl implements IAlumnoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Alumno seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Alumno.class, id);
	}

	@Override
	public void insertar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.persist(alumno);
	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.merge(alumno);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Alumno alum = this.seleccionar(id);
		this.entityManager.remove(alum);
		
	}

	@Override
	public Alumno seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Alumno> myCriteriaQuery = builder.createQuery(Alumno.class);
		
		Root<Alumno> tablaFrom = myCriteriaQuery.from(Alumno.class);
		
		Predicate condicionNombre = builder.equal(tablaFrom.get("nombre"), nombre);
		
		myCriteriaQuery.select(tablaFrom).where(condicionNombre);
		
		TypedQuery<Alumno> typedQuery = this.entityManager.createQuery(myCriteriaQuery);
		
		return typedQuery.getSingleResult();
	}

}

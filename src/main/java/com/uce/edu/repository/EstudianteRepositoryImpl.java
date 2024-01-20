package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Estudiante estu = this.seleccionar(id);
		this.entityManager.remove(estu);
	}

	@Override
	public List<Estudiante> seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("select e from Estudiante e where e.nombre = : nombre", Estudiante.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("select e from Estudiante e where e.cedula = : cedula", Estudiante.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> seleccionarPorFechaNacimiento(LocalDateTime fechaNacimiento) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("select e from Estudiante e where e.fechaNacimiento = : fechaNacimiento", Estudiante.class);
		myQuery.setParameter("fechaNacimiento", fechaNacimiento);
		return myQuery.getResultList();
	}

}

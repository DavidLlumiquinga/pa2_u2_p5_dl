package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM autor a WHERE a.auto_nombre = :nombre",
				Autor.class);
		myQuery.setParameter("nombre", nombre);
		return (Autor) myQuery.getSingleResult();
	}

	@Override
	public Autor seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM autor a WHERE a.auto_apellido = :apellido",
				Autor.class);
		myQuery.setParameter("apellido", apellido);
		return (Autor) myQuery.getSingleResult();
	}

	@Override
	public Autor seleccionarPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM autor a WHERE a.auto_nacionalidad = :nacionalidad",
				Autor.class);
		myQuery.setParameter("nacionalidad", nacionalidad);
		return (Autor) myQuery.getSingleResult();
	}
}

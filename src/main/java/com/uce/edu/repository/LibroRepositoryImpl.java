package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public void insertar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro2);
	}

	@Override
	public Libro seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		// SQL: select * from libro l where l.libr_titulo= ?
		// JPQL: select li from Libro(Nombre de la clase) li where li.titulo =
		// :variable(<-cualquier nombre)
		Query myQuery = this.entityManager.createQuery("select li from Libro li where li.titulo = :variable");
		myQuery.setParameter("variable", nombre);
		return (Libro) myQuery.getResultList().get(0);
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		// SQL: select * from Libro l where l.libr_fecha_publicacion>=?
		// JPQL: select l from Libro l where l.fechaPublicacion >= : fecha
		Query myQuery = this.entityManager.createQuery("select l from Libro l where l.fechaPublicacion >= : fecha");
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

	//TYPED QUERY
	
	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		// TODO Auto-generated method stub

		TypedQuery<Libro> myQuery = this.entityManager.createQuery("select li from Libro li where li.titulo = :titulo",
				Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager
				.createQuery("select l from Libro l where l.fechaPublicacion >= : fecha", Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}
	
	//NAMED QUERY

	@Override
	public Libro seleccionarPorTituloNamed(String titulo) {
		// TODO Auto-generated method stub

		TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo", Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha", Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

}

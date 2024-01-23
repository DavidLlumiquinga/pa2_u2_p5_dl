package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;

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
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano ciu = this.seleccionar(id);
		this.entityManager.remove(ciu);
	}

	@Override
	public Ciudadano seleccionarPorApellido(String apellido) {
        //SELECT c FROM Ciudadano c WHERE c.apellido = :apellido
        //0. Creamos una instancia de la interfaz CriteriaBUilder a partir de un EM
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        //1. Detterminamos el tipo de retorno que va a tener mi Consulta(Query)
        CriteriaQuery<Ciudadano> myCriteriaQuery= builder.createQuery(Ciudadano.class);

        //2. Construir el SQL
        //2.1 Determinar el from
        //Nota: No necesariamente el from es igual al tipo de retorno
        //SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre =:dato
        Root<Ciudadano> tablaFrom = myCriteriaQuery.from(Ciudadano.class);

        //2.2 Construir las condiciones(WHERE) del SQL
        //En criteria api query las condiciones se las conoce como "Predicate"
        //c.apellido = :variable
        Predicate condicionApellido = builder.equal(tablaFrom.get("apellido"), apellido);

        //3. Construimos el SQL final
        myCriteriaQuery.select(tablaFrom).where(condicionApellido);

        //4. Ejecutamos la consulta con un TypedQuery
        TypedQuery<Ciudadano> typedQuery = this.entityManager.createQuery(myCriteriaQuery);
        
        return typedQuery.getSingleResult();
    }

	@Override
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {

		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);

		Root<Ciudadano> myForm = myCriteriaQuery.from(Ciudadano.class);

		Predicate condicionGenerica = null;
		
		
		if (cedula.startsWith("")) {

			condicionGenerica = myCriteriaBuilder.equal(myForm.get("nombre"), nombre);
		} else if (cedula.startsWith("05")) {
			condicionGenerica = myCriteriaBuilder.equal(myForm.get("apellido"), apellido);
		} else {
			condicionGenerica = myCriteriaBuilder.equal(myForm.get("cedula"), cedula);
		}

		// 3. Construimos el SQL final

		myCriteriaQuery.select(myForm).where(condicionGenerica);

		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {

		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);

		Root<Ciudadano> myForm = myCriteriaQuery.from(Ciudadano.class);

		Predicate condicionTotal = null;
		
		
		//c.nombre=: nombre
		Predicate condicionNombre=myCriteriaBuilder.equal(myForm.get("nombre"), nombre);
		
		//c.apellido=:apellido
		Predicate condicionApellido= myCriteriaBuilder.equal(myForm.get("apellido"), apellido);
		
		
		if (cedula.startsWith("17")) {
			//c.nombre=: nombre or c.apellido =:apellido
			condicionTotal = myCriteriaBuilder.or(condicionNombre,condicionApellido);
		} else if (cedula.startsWith("05")) {
			//c.nombre=: nombre and c.apellido =:apellido
			condicionTotal = myCriteriaBuilder.and(condicionNombre,condicionApellido);
		}

		// 3. Construimos el SQL final

		myCriteriaQuery.select(myForm).where(condicionTotal);

		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}
}

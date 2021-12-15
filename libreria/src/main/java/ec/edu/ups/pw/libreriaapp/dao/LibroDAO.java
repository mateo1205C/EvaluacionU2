package ec.edu.ups.pw.libreriaapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw.libreriaapp.model.Libro;

@Stateless
public class LibroDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Libro libro) {
		em.persist(libro);
	}
	
	public void update(Libro libro) {
		em.merge(libro);
	}
	
	public Libro read (int id) {
		Libro l = em.find(Libro.class, id);
		return l;
	}
	
	public void delete(Libro libro) {
		Libro l = em.find(Libro.class, libro.getId());
		em.remove(l);
	} 
	
	public List<Libro> getLibros() {
		List<Libro> libros = new ArrayList<Libro>();
		String jpqlLibro = "SELECT l FROM Libro l";
		Query query = em.createQuery(jpqlLibro, Libro.class);
		
		libros = query.getResultList();
		return libros;
	}
}

package ec.edu.ups.pw.proyecto.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw.proyecto.model.Libro;

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
		Libro l = em.find(Libro.class, libro);
		em.remove(l);
	}
	
	public List<Libro> getLibros() {
		String jpqlLibro = "SELECT l FROM Libro l";
		Query query = em.createQuery(jpqlLibro, Libro.class);
		
		List<Libro> libros = query.getResultList();
		return libros;
	}
}

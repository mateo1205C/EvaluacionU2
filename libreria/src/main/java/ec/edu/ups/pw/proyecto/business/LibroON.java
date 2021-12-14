package ec.edu.ups.pw.proyecto.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw.proyecto.dao.LibroDAO;
import ec.edu.ups.pw.proyecto.model.Libro;

@Stateless
public class LibroON implements LibroONLocal, LibroONRemote {
	
	@Inject
	private LibroDAO daoLibro;
	
	public void insertLibro(Libro libro) {
		daoLibro.insert(libro);
	}
	
	public void updateLibro(Libro libro) {
		daoLibro.update(libro);
	}
	
	public void deleteLibro(Libro libro) {
		int com = Integer.valueOf(libro.getId());
		daoLibro.delete(libro);
	}
	
	public List<Libro> getLibros() {
		return daoLibro.getLibros();
	}
	
	public Libro getLibro(int id) {
		Libro l = daoLibro.read(id);
		return l;
	}

}

package ec.edu.ups.pw.libreriaapp.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw.libreriaapp.dao.LibroDAO;
import ec.edu.ups.pw.libreriaapp.model.Libro;

@Stateless
public class LibroON implements LibroONLocal, LibroONRemote {
	
	@Inject
	private LibroDAO daoLibro;
	
	public void insertLibro(Libro libro) throws Exception {
		daoLibro.insert(libro);
	}
	
	public void updateLibro(Libro libro) throws Exception {
		daoLibro.update(libro);
	}
	
	public void deleteLibro(Libro libro) throws Exception {
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

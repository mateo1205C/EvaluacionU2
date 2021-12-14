package ec.edu.ups.pw.proyecto.business;

import javax.ejb.Local;

import ec.edu.ups.pw.proyecto.model.Libro;

@Local
public interface LibroONLocal {

	public void insertLibro(Libro libro);
	public void updateLibro(Libro libro);
	public void deleteLibro(Libro libro);
}

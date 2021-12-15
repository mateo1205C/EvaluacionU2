package ec.edu.ups.pw.libreriaapp.business;

import javax.ejb.Local;

import ec.edu.ups.pw.libreriaapp.model.Libro;

@Local
public interface LibroONLocal {

	public void insertLibro(Libro libro) throws Exception;
	public void updateLibro(Libro libro) throws Exception;
	public void deleteLibro(Libro libro) throws Exception;
	public Libro getLibro(int id);
}

package ec.edu.ups.pw.libreriaapp.business;

import javax.ejb.Remote;

import ec.edu.ups.pw.libreriaapp.model.Libro;

@Remote
public interface LibroONRemote {

	public void insertLibro(Libro libro) throws Exception;
	public void updateLibro(Libro libro) throws Exception;
	public void deleteLibro(Libro libro) throws Exception;
	public Libro getLibro(int id);
	
}

package ec.edu.ups.pw.proyecto.business;

import javax.ejb.Remote;

import ec.edu.ups.pw.proyecto.model.Libro;

@Remote
public interface LibroONRemote {

	public void insertLibro(Libro libro);
	public void updateLibro(Libro libro);
	public void deleteLibro(Libro libro);
	
}

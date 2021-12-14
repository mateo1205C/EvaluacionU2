package ec.edu.ups.pw.libreriacliente.view;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.edu.ups.pw.proyecto.business.LibroONRemote;
import ec.edu.ups.pw.proyecto.model.Libro;


public class VentanaLibreria {
	
	private LibroONRemote libroRemote;

	public void intanciarMemberRegistration() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "xxxxxx_xx");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/libreria/LibroON!ec.edu.ups.pw.proyecto.business.LibroONRemote";  
              
            this.libroRemote = (LibroONRemote) context.lookup(lookupName);  
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
	
	public void crearLibro(int id, String titulo, String autor, String editorial, String fecha) {
		Libro l = new Libro();
		l.setId(id);
		l.settitulo(titulo);
		l.setAutor(autor);
		l.setEditorial(editorial);
		l.setFecha(fecha);
		
		try {
			libroRemote.insertLibro(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		VentanaLibreria vtnLibro = new VentanaLibreria();
		try {
			vtnLibro.intanciarMemberRegistration();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

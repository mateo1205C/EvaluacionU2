package ec.edu.ups.pw.libreriaapp.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ec.edu.ups.pw.libreriaapp.business.LibroONRemote;
import ec.edu.ups.pw.libreriaapp.model.Libro;


public class VentanaLibreria extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LibroONRemote libroRemote;
	private JPanel              panel;
    private List<JLabel>        lblList;
    private List<JTextField>    txtList;
    private List<JButton>       botonList;

    public VentanaLibreria(String title) throws HeadlessException {
        super(title);
        this.iniciaComponentes();
        this.setSize(400, 350);
        this.setLocation(5,10);
        this.setVisible(true);
    }
    
    public void iniciaComponentes(){
        
    	this.panel = new JPanel(new BorderLayout());
        JPanel panelSuperior = new JPanel(new GridLayout(1,1));
        JPanel panelInferior = new JPanel(new FlowLayout());
        
        this.lblList = new ArrayList<JLabel>();
        this.lblList.add(new JLabel("Codigo:"));
        this.lblList.add(new JLabel("Titulo:"));
        this.lblList.add(new JLabel("Autor:"));
        this.lblList.add(new JLabel("Editorial:"));
        this.lblList.add(new JLabel("Fecha:"));
        
        this.txtList = new ArrayList<JTextField>();
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        
        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Agregar"));
        this.botonList.add(new JButton("Modificar"));
        this.botonList.add(new JButton("Borrar"));
        this.botonList.add(new JButton("Buscar"));

        
        panelInferior.add(this.botonList.get(0));
        panelInferior.add(this.botonList.get(1));
        panelInferior.add(this.botonList.get(2));
        panelInferior.add(this.botonList.get(3));
        
        ActionListener agregar = new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		
        		int id = Integer.valueOf(txtList.get(0).getText());
                String titulo = txtList.get(1).getText();
                String autor = txtList.get(2).getText();
                String editorial = txtList.get(3).getText();
                String fecha = txtList.get(4).getText();
                
                insertLibro(id, titulo, autor, editorial, fecha);
                txtList.get(0).setEditable(true);
                txtList.get(0).setText("");
                txtList.get(1).setText("");
                txtList.get(2).setText("");
                txtList.get(3).setText("");
                txtList.get(4).setText("");
                JOptionPane.showMessageDialog(null, "Libro Guardado");
            }
        };
        
        ActionListener modificar = new ActionListener( ) {
        	public void actionPerformed(ActionEvent ae) {
        		
        		int id = Integer.valueOf(txtList.get(0).getText());
                String titulo = txtList.get(1).getText();
                String autor = txtList.get(2).getText();
                String editorial = txtList.get(3).getText();
                String fecha = txtList.get(4).getText();
                
                updateLibro(id, titulo, autor, editorial, fecha);
                txtList.get(0).setEditable(true);
                txtList.get(0).setText("");
                txtList.get(1).setText("");
                txtList.get(2).setText("");
                txtList.get(3).setText("");
                txtList.get(4).setText("");                
                JOptionPane.showMessageDialog(null, "Libro Modificado");


            }
        };
        
        ActionListener borrar = new ActionListener( ) {
        	public void actionPerformed(ActionEvent ae) {
        		
        		int id = Integer.valueOf(txtList.get(0).getText());
                String titulo = txtList.get(1).getText();
                String autor = txtList.get(2).getText();
                String editorial = txtList.get(3).getText();
                String fecha = txtList.get(4).getText();
                
                deleteLibro(id, titulo, autor, editorial, fecha);
                txtList.get(0).setEditable(true);
                txtList.get(0).setText("");
                txtList.get(1).setText("");
                txtList.get(2).setText("");
                txtList.get(3).setText("");
                txtList.get(4).setText("");
                JOptionPane.showMessageDialog(null, "Libro Borrado");
            }
        };
        
        ActionListener buscar = new ActionListener( ) {
        	public void actionPerformed(ActionEvent ae) {
        		int id = Integer.valueOf(txtList.get(0).getText());
        		Libro l = libroRemote.getLibro(id);
        		txtList.get(0).setText(String.valueOf(l.getId()));
        		txtList.get(0).setEditable(false);
                txtList.get(1).setText(l.getitulo());
                txtList.get(2).setText(l.getAutor());
                txtList.get(3).setText(l.getEditorial());
                txtList.get(4).setText(l.getFecha());
            }
        };
        this.botonList.get(0).addActionListener(agregar);
        this.botonList.get(1).addActionListener(modificar);
        this.botonList.get(2).addActionListener(borrar);
        this.botonList.get(3).addActionListener(buscar);
              
        JPanel panelDatos = new JPanel(new GridLayout(5,1));
      
        for(int i = 0; i<this.lblList.size();i++){
        	panelDatos.add(this.lblList.get(i));
        	panelDatos.add(this.txtList.get(i));
        }
        panelSuperior.add(panelDatos);
        this.panel.add(panelSuperior, BorderLayout.CENTER);
        this.panel.add(panelInferior, BorderLayout.SOUTH);
        this.add(this.panel);
    }
	
	public void intanciarMemberRegistration() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "Francis12M");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "M@teoC1205");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/libreria/LibroON!ec.edu.ups.pw.libreriaapp.business.LibroONRemote";  
              
            this.libroRemote = (LibroONRemote) context.lookup(lookupName);  
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
	
	public void insertLibro(int id, String titulo, String autor, String editorial, String fecha) {
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
	
	public void updateLibro(int id, String titulo, String autor, String editorial, String fecha) {
		Libro l = new Libro();
		l.setId(id);
		l.settitulo(titulo);
		l.setAutor(autor);
		l.setEditorial(editorial);
		l.setFecha(fecha);
		
		try {
			libroRemote.updateLibro(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteLibro(int id, String titulo, String autor, String editorial, String fecha) {
		Libro l = new Libro();
		l.setId(id);
		l.settitulo(titulo);
		l.setAutor(autor);
		l.setEditorial(editorial);
		l.setFecha(fecha);
		
		try {
			libroRemote.deleteLibro(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		VentanaLibreria vtnLibro = new VentanaLibreria("Libreria");
		vtnLibro.setVisible(true);
		try {
			vtnLibro.intanciarMemberRegistration();
			//vtnLibro.crearLibro(0, "La metamorfosis", "Franz Kafka", "Anagrama", "2017");
			//vtnLibro.updateLibro(0, "La metamorfosis", "Franz Kafka", "UPS", "2019");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

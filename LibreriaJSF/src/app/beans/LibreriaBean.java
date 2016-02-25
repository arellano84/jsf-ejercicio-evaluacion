package app.beans;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import app.modelo.Autor;
import app.modelo.Direccion;
import app.modelo.Editorial;
import app.modelo.Libro;
import app.negocio.ItfzGestionLibreria;

/**
 * @author arellano84
 * @version 20150401
 * 
 * Bean de gestión entre vista y cotrolador. Se accesa por la inferfaz ItfzGestionLibreria inyectada.
 * 
 * Módulo JSF
 */

@ManagedBean
@RequestScoped
public class LibreriaBean {
	
	//Datos Autor
	private String nom_autor;
	private String nacionalidad;
	private String comentarios;
	//Datos Libro
	private String titulo;
	private String isbn;
	private int publicacion;
	private double precio;
	private String descripcion;
	//Datos Editorial
	private String nom_editorial;
	private String nif;
	//Datos Dirección
	private String calle;
	private int numero;
	private String poblacion;
	private int cp;
	private String provincia;
	
	//Mensaje de respuesta
	private String mensaje;
	
	//Objeto Libro de respuesta
	private Libro libro = new Libro();
	
	// Inyectamos la interfaz con Spring
	private ItfzGestionLibreria igestionlibreria;
	
	/*
	 * Método de acción/Metodo de navegación
	 * Método de Alta
	 * */
	public String alta(){
		
		Autor autor = new Autor(nom_autor, nacionalidad, comentarios);
		Libro libro = new Libro(titulo,isbn,publicacion,precio,descripcion);
		libro.addAutor(autor);
		Editorial editorial= new Editorial(nom_editorial, nif,new Direccion(calle,numero,poblacion,cp,provincia));
		editorial.addLibro(libro);
		
		boolean insertado=false;
		try{ 
			igestionlibreria.altaEditorial(editorial);
			insertado=true;
		}catch(Exception e){e.printStackTrace();}
		mensaje =  insertado?propertiesFile().getString("alta_ok"):propertiesFile().getString("alta_error");
		
		return "consultarTodos";
	}
	
	/*
	 * Método de acción
	 * Método de consulta todos los Libros
	 * */
	public List<Libro> consultarTodos(){
		return igestionlibreria.consultarTodos();
	}
	
	/*
	 * Método de acción/Metodo de navegación
	 * Método de busqueda de libro
	 * */
	public String buscarLibro(){
		libro = igestionlibreria.buscarLibro(isbn,titulo);
		return "mostrarLibro";
	}
	
	/*
	 * Método de acción/Metodo de navegación
	 * Método de modificación de libro
	 * */
	public String modificarLibro(){
		boolean modificado=false;
		modificado=igestionlibreria.modificarPrecio(libro.getIsbn(),libro.getPrecio());
		mensaje =  modificado?propertiesFile().getString("modificar_ok"):propertiesFile().getString("modificar_error");
		
		return "mostrarMensaje";
	}
	
	/*
	 * Método de acción/Metodo de navegación
	 * Método de consulta todos los Libros
	 * */
	public String eliminarLibro(){
		boolean eliminado=false;
		eliminado=igestionlibreria.eliminarLibro(isbn);
		mensaje =  eliminado?propertiesFile().getString("borrar_ok"):propertiesFile().getString("borrar_error");
		
		return "mostrarMensaje";
	}
	
	/*
	 * Método para Cargar el archivo de mensajes
	 * */
	public ResourceBundle propertiesFile() {
		FacesContext context = FacesContext.getCurrentInstance();
		Locale idioma = context.getViewRoot().getLocale();
		ResourceBundle properties = ResourceBundle.getBundle("mensajes", idioma);
		return properties;
	}
	
	public String getNom_autor() {
		return nom_autor;
	}

	public void setNom_autor(String nom_autor) {
		this.nom_autor = nom_autor;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(int publicacion) {
		this.publicacion = publicacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNom_editorial() {
		return nom_editorial;
	}

	public void setNom_editorial(String nom_editorial) {
		this.nom_editorial = nom_editorial;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public ItfzGestionLibreria getIgestionlibreria() {
		return igestionlibreria;
	}

	public void setIgestionlibreria(ItfzGestionLibreria igestionlibreria) {
		this.igestionlibreria = igestionlibreria;
	}
	
	
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	
}

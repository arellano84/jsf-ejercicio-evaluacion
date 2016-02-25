package app.modelo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author arellano84
 * @version 20150319
 * 
 * Modelo de la tabla Libro.
 */
public class Libro {
	
	private Long id;
	private String titulo;
	private String isbn;
	private int publicacion;
	private double precio;
	private String descripcion;
	private Set<Autor> autores= new HashSet<Autor>();
	private Editorial editoriales;
	
	public Libro(){}
	
	public Libro(String titulo, String isbn, int publicacion, double precio, String descripcion){
		
		this.titulo=titulo;
		this.isbn=isbn;
		this.publicacion=publicacion;
		this.precio=precio;
		this.descripcion=descripcion;
	}
	
	public void addAutor(Autor a){
		autores.add(a);
		a.getLibros().add(this);
	}
	
	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	public Editorial getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(Editorial editoriales) {
		this.editoriales = editoriales;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	@Override
    public String toString() {
        return "Libro{" 	
				+ "Titulo=" + titulo 
				+ " ISBN=" + isbn 
				+ " Publicacion=" + publicacion 
				+ " Precio=" + precio
				+ " Descripcion=" + descripcion
				+ '}';
    }
}

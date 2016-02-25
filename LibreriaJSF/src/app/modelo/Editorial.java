package app.modelo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author arellano84
 * @version 20150319
 * 
 * Modelo de la tabla Editorial.
 */
public class Editorial {
	
	private Long id;
	private String nombre;
	private Direccion direccion;
	private String nif;
	Set<Libro> libros= new HashSet<Libro>();
	
	public Editorial() {}
	
	public Editorial(String nombre, String nif, Direccion direccion) {
		this.nombre = nombre;
		this.nif = nif;
		this.direccion = direccion;
	}
	
	public void addLibro(Libro l){
		libros.add(l);
		l.setEditoriales(this);
	}
	
	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Override
	public String toString() {
		return "Editorial [nombre=" + nombre + ", nif=" + nif + "]";
	}
	
}

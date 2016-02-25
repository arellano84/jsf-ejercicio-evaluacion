package app.modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author arellano84
 * @version 20150319
 * 
 * Modelo de la tabla Autor.
 */
public class Autor {
	
	private Long id;
	private String nombre;
	private String nacionalidad;
	private String comentarios;
	Set<Libro> libros= new HashSet<Libro>();
	
	public Autor() {}
	
	public Autor(String nombre, String nacionalidad, String comentarios) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.comentarios = comentarios;
	}
	
	public void addLibro(Libro l){
		libros.add(l);
		l.getAutores().add(this);
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

	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", nacionalidad=" + nacionalidad
				+ ", comentarios=" + comentarios + "]";
	}

}

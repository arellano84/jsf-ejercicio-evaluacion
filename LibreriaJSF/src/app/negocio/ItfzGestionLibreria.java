/**
 * 
 */
package app.negocio;

import java.util.List;

import app.modelo.Autor;
import app.modelo.Editorial;
import app.modelo.Libro;
import app.persistencia.LibroNoEncontradoException;

/**
 * @author arellano84
 * @version 20150401
 * 
 * Interface de negocio para ejecución desde el cliente.
 */
public interface ItfzGestionLibreria {

	/** Crea un nuevo registro en la tabla con los datos del libro recibido como argumento
	  * @param libro el objeto a insertar
	  * @return true si el alta se ha realizado, false caso contrario
	  * @throws Excepcion
	  */
	public void altaLibro(Libro libro)  throws Exception;
	
	/** Crea un nuevo registro en la tabla con los datos del autor recibido como argumento
	  * @param libro el objeto a insertar
	  * @return true si el alta se ha realizado, false caso contrario
	  * @throws Excepcion
	  */
	public void altaAutor(Autor autor)  throws Exception;
	
	/** Crea un nuevo registro en la tabla con los datos de la editorial recibida como argumento
	  * @param libro el objeto a insertar
	  * @return true si el alta se ha realizado, false caso contrario
	  * @throws Excepcion
	  */
	public void altaEditorial(Editorial editorial)  throws Exception;
	
	/** Consulta todos los registros de la tabla Libro
	  * @return List de Libro
	  */
	public List<Libro> consultarTodos();
	
	/** Consulta el registro indicado de la tabla Libro
	  * @param isbn de registro a consultar
	  * @param titulo de registro a consultar
	  * @return Objeto de Libro
	  * @throws LibroNoEncontradoException
	  */
	public Libro buscarLibro(String isbn,String titulo);
	
	/** Consulta el registro indicado de la tabla Libro
	  * @param isbn de registro a consultar
	  */
	public void consultarISBN(String isbn);
	
	/** Consulta el registro indicado de la tabla Libro
	  * @param titulo de registro a consultar
	  */
	public void consultarTitulo(String titulo);
	
	/** Modifica precio del registro indicado en la tabla libro
	  * @param isbn del registro a eliminar, precio que se modifica
	  * @return true si se ha modificado correctamente, false caso contrario
	  */
	public boolean modificarPrecio(String isbn, double precio);
	
	/** Elimina el registro indicado en la tabla libro
	  * @param isbn del registro a eliminar
	  * @return true si se ha elimando correctamente, false caso contrario
	  */
	public boolean eliminarLibro(String ISBN);
	
}
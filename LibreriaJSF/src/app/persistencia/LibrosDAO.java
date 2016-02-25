package app.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.modelo.Autor;
import app.modelo.Editorial;
import app.modelo.Libro;

/**
 * @author arellano84
 * @version 20150401
 * 
 * Bean de ejecución del DAO que tendra acceso desde la interface del DAO.
 */
//Declaración del bean con anotaciones.
@Component
public class LibrosDAO implements ItfzLibrosDao{//Implementando la interface ItfzLibrosDao.
	
	//Inyectando objeto al bean con anotaciones.
	@Inject
	private HibernateTemplate plantilla;
	
	
	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public void altaLibro(Libro libro){
		
		plantilla.save(libro);
		plantilla.flush();
		
	}
	
	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public void altaAutor(Autor autor){
			
		plantilla.save(autor);
		plantilla.flush();
		
	}
	
	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public void altaEditorial(Editorial editorial){
		
		plantilla.save(editorial);
		plantilla.flush();
		
	}
	
	public List<Libro> consultarTodos(){
		
		String query = "select l from Libro l";
		List lista = plantilla.find(query);
        List<Libro> libros = new ArrayList<Libro>();
        for(Object obj : lista)
        	libros.add((Libro)obj);
        
        if(libros.size()>0)
			return libros;
		else
			throw new LibroNoEncontradoException("Is Empty");
        
	}
	
	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public Libro buscarLibro(String isbn,String titulo){
		try{
			String query="select l from Libro l where l.isbn=:isbn AND titulo like CONCAT('%',:titulo,'%')";
			String[] params= {"isbn" , "titulo"};
			Object[] values= {isbn , titulo};
			
			return (Libro)plantilla.findByNamedParam(query, params, values).get(0);
					
		}catch(Exception e){
			throw new LibroNoEncontradoException("isbn="+isbn);
		}
	}
	
	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public Libro consultarISBN(String isbn){
		try{
			
			String query="select l from Libro l where l.isbn=:isbn";
			return (Libro)plantilla.findByNamedParam(query, "isbn", isbn).get(0);
			
		}catch(Exception e){
			throw new LibroNoEncontradoException("isbn="+isbn);
		}
	}
	
	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public List<Libro> consultarTitulo(String titulo){
		String query = "select l from Libro l where titulo like CONCAT('%',:titulo,'%')";
		List lista = plantilla.findByNamedParam(query, "titulo", titulo);
        List<Libro> libros = new ArrayList<Libro>();
        for(Object obj : lista)
        	libros.add((Libro)obj);
        
        if(libros.size()>0)
			return libros;
		else
			throw new LibroNoEncontradoException("titulo="+titulo);
	}
	
	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public boolean modificarPrecio(String isbn, double precio){
		
		int modificado= plantilla.bulkUpdate("update Libro set precio=? where isbn=?",precio,isbn);
		
		return modificado>0?true:false;
	}

	@Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	public boolean eliminarLibro(String isbn){
		
		int eliminado= plantilla.bulkUpdate("delete from Libro where isbn=?",isbn);
		
		return eliminado>0?true:false;
		
	}
	
    public HibernateTemplate getTemplate() {
        return plantilla;
    }

    public void setTemplate(HibernateTemplate plantilla) {
        this.plantilla = plantilla;
    }

}

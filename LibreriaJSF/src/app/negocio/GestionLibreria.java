package app.negocio;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import app.modelo.Autor;
import app.modelo.Editorial;
import app.modelo.Libro;
import app.persistencia.ItfzLibrosDao;

/**
 * @author arellano84
 * @version 20150401
 * 
 * Bean de ejecución de negocio que tendra acceso desde la interface de negocio.
 */
//Declaración del bean con anotaciones.
@Component(value = "gestionLibreria")
public class GestionLibreria implements ItfzGestionLibreria{//Implementando la interface ItfzGestionLibreria.
	
	//Inyectando objeto al bean con anotaciones.
	@Inject
	ItfzLibrosDao ilibrosdao;

	public void altaLibro(Libro libro) throws Exception{
		try{
			ilibrosdao.altaLibro(libro);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("isbn="+libro.getIsbn());
		}
	}
	
	public void altaAutor(Autor autor) throws Exception{
		try{
			ilibrosdao.altaAutor(autor);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("autor="+autor.getNombre());
		}
	}
	
	public void altaEditorial(Editorial editorial) throws Exception{
		try{
			ilibrosdao.altaEditorial(editorial);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("editorial="+editorial.getNombre());
		}
	}
	
	public List<Libro> consultarTodos(){
		return ilibrosdao.consultarTodos();
	}
	
	public Libro buscarLibro(String isbn,String titulo) {
		return ilibrosdao.buscarLibro(isbn,titulo);
	}
	
	public void consultarISBN(String isbn) {
		try{
			System.out.println(ilibrosdao.consultarISBN(isbn));
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void consultarTitulo(String titulo){
		try{
			System.out.println(ilibrosdao.consultarTitulo(titulo));
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public boolean modificarPrecio(String isbn, double precio){
		return ilibrosdao.modificarPrecio(isbn,precio);
	}

	public boolean eliminarLibro(String isbn){
		return ilibrosdao.eliminarLibro(isbn);
	}
	
	public ItfzLibrosDao getIlibrosdao() {
		return ilibrosdao;
	}

	public void setIlibrosdao(ItfzLibrosDao ilibrosdao) {
		this.ilibrosdao = ilibrosdao;
	}
	
}

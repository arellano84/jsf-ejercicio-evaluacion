package app.modelo;

/**
 * @author arellano84
 * @version 20150319
 * 
 * Modelo de la tabla Dirección.
 */
public class Direccion {
	
	private Long id;
	private String calle;
	private int numero;
	private String poblacion;
	private int cp;
	private String provincia;
	private Editorial editorial;
	
	public Direccion() {}
	
	public Direccion(String calle, int numero, String poblacion, int cp,
			String provincia) {
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.cp = cp;
		this.provincia = provincia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
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

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero
				+ ", poblacion=" + poblacion + ", cp=" + cp + ", provincia="
				+ provincia + "]";
	}
	
}

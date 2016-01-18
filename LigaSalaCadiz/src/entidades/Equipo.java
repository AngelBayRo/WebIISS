package entidades;

public class Equipo {
	private int id;
	private String nombre;
	private String imagen;
	private String delegado;
	private int puntos;
	private int golesfavor;
	private int golescontra;
	private int categoria;
	
	public Equipo(int id, String nombre, String imagen, String delegado,
			int puntos, int golesfavor, int golescontra, int categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.delegado = delegado;
		this.puntos = puntos;
		this.golesfavor = golesfavor;
		this.golescontra = golescontra;
		this.categoria = categoria;
	}
	
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDelegado() {
		return delegado;
	}
	public void setDelegado(String delegado) {
		this.delegado = delegado;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getGolesfavor() {
		return golesfavor;
	}
	public void setGolesfavor(int golesfavor) {
		this.golesfavor = golesfavor;
	}
	public int getGolescontra() {
		return golescontra;
	}
	public void setGolescontra(int golescontra) {
		this.golescontra = golescontra;
	}
	
}

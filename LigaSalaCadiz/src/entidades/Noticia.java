package entidades;

import java.sql.Date;

public class Noticia {
	private int id;
	private String titular;
	private String subtitular;
	private String cuerpo;
	private Date fecha;
	private String autor;
	private String imagen;
	public Noticia(int id,String titular, String subtitular, String cuerpo,
			Date fecha, String autor,String imagen) {
		super();
		this.id=id;
		this.titular = titular;
		this.subtitular = subtitular;
		this.cuerpo = cuerpo;
		this.fecha = fecha;
		this.autor = autor;
		this.imagen=imagen;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getSubtitular() {
		return subtitular;
	}
	public void setSubtitular(String subtitular) {
		this.subtitular = subtitular;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
}

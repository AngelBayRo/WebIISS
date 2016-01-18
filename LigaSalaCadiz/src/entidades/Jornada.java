package entidades;

import java.sql.Date;
import java.util.ArrayList;

public class Jornada {
	private int id;
	private int num;
	private Date inicio;
	private Date fin;
	private boolean jugada;
	private ArrayList<Partido> partidos;
	private int categoria;
	
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public Jornada(int id, int num, Date inicio, Date fin, boolean jugada,int categoria) {
		super();
		this.id = id;
		this.num = num;
		this.inicio = inicio;
		this.fin = fin;
		this.jugada = jugada;
		this.categoria=categoria;
	}
	public Jornada(int id, int num, Date inicio, Date fin, boolean jugada,
			ArrayList<Partido> partidos,int categoria) {
		super();
		this.id = id;
		this.num = num;
		this.inicio = inicio;
		this.fin = fin;
		this.jugada = jugada;
		this.partidos = partidos;
		this.categoria=categoria;
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public boolean isJugada() {
		return jugada;
	}
	public void setJugada(boolean jugada) {
		this.jugada = jugada;
	}
	
}

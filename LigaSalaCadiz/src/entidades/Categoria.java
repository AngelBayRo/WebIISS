package entidades;

import java.util.ArrayList;

import entidades.Jornada;

public class Categoria {
	private int id;
	private String nombre;
	private ArrayList<Jornada> jornadas;
	
	public Categoria(int id, String nombre, ArrayList<Jornada> jornadas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.jornadas = jornadas;
	}
	public Categoria(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
	public ArrayList<Jornada> getJornadas() {
		return jornadas;
	}
	public void setJornadas(ArrayList<Jornada> jornadas) {
		this.jornadas = jornadas;
	}
	
}
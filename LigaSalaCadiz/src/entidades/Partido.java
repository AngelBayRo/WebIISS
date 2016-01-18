package entidades;
import java.sql.Date;
import java.sql.Time;

public class Partido {
	private int id;
	private Equipo equipolocal;
	private Equipo equipovisitante;
	private int goleslocal;
	private int golesvisitante;
	private Jornada jornada;
	private Date fecha;
	private Time hora;
	boolean jugado;
	public Partido(int id, Equipo equipolocal, Equipo equipovisitante,
			int goleslocal, int golesvisitante, Jornada jornada, Date fecha,Time hora,boolean jugado) {
		super();
		this.id = id;
		this.equipolocal = equipolocal;
		this.equipovisitante = equipovisitante;
		this.goleslocal = goleslocal;
		this.golesvisitante = golesvisitante;
		this.jornada = jornada;
		this.fecha = fecha;
		this.jugado =jugado;
		this.hora=hora;
	}
	
	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public boolean isJugado() {
		return jugado;
	}

	public void setJugado(boolean jugado) {
		this.jugado = jugado;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Equipo getEquipolocal() {
		return equipolocal;
	}
	public void setEquipolocal(Equipo equipolocal) {
		this.equipolocal = equipolocal;
	}
	public Equipo getEquipovisitante() {
		return equipovisitante;
	}
	public void setEquipovisitante(Equipo equipovisitante) {
		this.equipovisitante = equipovisitante;
	}
	public int getGoleslocal() {
		return goleslocal;
	}
	public void setGoleslocal(int goleslocal) {
		this.goleslocal = goleslocal;
	}
	public int getGolesvisitante() {
		return golesvisitante;
	}
	public void setGolesvisitante(int golesvisitante) {
		this.golesvisitante = golesvisitante;
	}
	public Jornada getJornada() {
		return jornada;
	}
	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}

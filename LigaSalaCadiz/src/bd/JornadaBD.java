package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import entidades.Equipo;
import entidades.Jornada;
import entidades.Noticia;
import entidades.Partido;
import entidades.Usuario;


public class JornadaBD extends Conexion{
	public ArrayList<Jornada> obtener_jornadas(int categoria) throws SQLException
    {
		Jornada j=null;
		ArrayList<Jornada> jornadas=new ArrayList<Jornada>();
		Statement st = con.createStatement();
        ResultSet rs = null;
    	String Consulta="Select * from jornada where categoria='"+categoria+"'";
    	rs = st.executeQuery(Consulta);
    	while(rs.next())
    	{
    		ArrayList<Partido> partidos= obtener_partidos(rs.getInt("id"));
    		j=new Jornada(rs.getInt("id"),rs.getInt("numero"),rs.getDate("fechaini"),rs.getDate("fechafin"),rs.getBoolean("jugada"),partidos,rs.getInt("categoria"));
    		jornadas.add(j);
    	}
    	return jornadas;
    }
    public ArrayList<Partido> obtener_partidos(int id) throws SQLException
    {
    	Partido p=null;
    	Equipo equipo1=null;
    	Equipo equipo2=null;
    	Jornada jornada=null;
    	
    	ArrayList<Partido> partidos = new ArrayList<Partido>();
        Statement st = con.createStatement();
        ResultSet rs = null;
    	String Consulta="Select * from partido where jornada='"+id+"'";
    	rs = st.executeQuery(Consulta);
    	while(rs.next())
    	{
    		equipo1= obtener_equipo_byid(rs.getInt("equipo1"));
    		equipo2= obtener_equipo_byid(rs.getInt("equipo2"));
    		jornada= obtener_jornada_byid(rs.getInt("jornada"));
    		p= new Partido(rs.getInt("id"),equipo1, equipo2, rs.getInt("goles1"), rs.getInt("goles2"),jornada,rs.getDate("fecha"),rs.getTime("fecha"),rs.getBoolean("jugado"));
    		partidos.add(p);
    	}
		return partidos;
    }
    public ArrayList<Partido> obtener_partidos() throws SQLException
    {
    	Partido p=null;
    	Equipo equipo1=null;
    	Equipo equipo2=null;
    	Jornada jornada=null;
    	
    	ArrayList<Partido> partidos = new ArrayList<Partido>();
        Statement st = con.createStatement();
        ResultSet rs = null;
    	String Consulta="Select * from jornada";
    	rs = st.executeQuery(Consulta);
    	while(rs.next())
    	{
    		equipo1= obtener_equipo_byid(rs.getInt("equipo1"));
    		equipo2= obtener_equipo_byid(rs.getInt("equipo2"));
    		jornada= obtener_jornada_byid(rs.getInt("jornada"));
    		p= new Partido(rs.getInt("id"),equipo1, equipo2, rs.getInt("goles1"), rs.getInt("goles2"),jornada,rs.getDate("fecha"),rs.getTime("fecha"),rs.getBoolean("jugado"));
    		partidos.add(p);
    	}
		return partidos;
    }

	public Jornada obtener_jornada_byid(int int1) throws SQLException {
		Jornada jornada=null;
		Statement st = con.createStatement();
        ResultSet rs = null;
    	String Consulta="Select * from jornada where id='"+int1+"'";
    	rs = st.executeQuery(Consulta);
    	if(rs.next())
    	{
    		jornada= new Jornada(rs.getInt("id"),rs.getInt("numero"), rs.getDate("fechaini"),rs.getDate("fechafin"),rs.getBoolean("jugada"),rs.getInt("categoria"));
    	}
		return jornada;
	}

	private Equipo obtener_equipo_byid(int int1) throws SQLException {
		Equipo equipo=null;
		Statement st = con.createStatement();
        ResultSet rs = null;
    	String Consulta="Select * from equipo where id='"+int1+"'";
    	rs = st.executeQuery(Consulta);
    	if(rs.next())
    	{
    		equipo= new Equipo(rs.getInt("id"),rs.getString("nombre"), rs.getString("imagen"),rs.getString("delegado"),rs.getInt("puntos"),rs.getInt("golesfavor"),rs.getInt("golescontra"),rs.getInt("categoria"));
    	}
		return equipo;
	}
	public void crear_jornada(int numero, Date date1, Date date2,int categoria) throws SQLException {
		Statement st = con.createStatement();
		String Consulta="Insert INTO jornada(numero,fechaini,fechafin,jugada,categoria) VALUES ('"+numero+"' ,'"+date1+"' ,'"+date2+"' ,"+false+",'"+categoria+"')";
    	st.execute(Consulta);
		
	}
	public void jugar_partido(int id, int goleslocal, int golesvisitante,
			boolean jugado) throws SQLException {
		Statement st = con.createStatement();
		String Consulta="UPDATE partido set goles1="+goleslocal+", goles2="+golesvisitante+" ,jugado="+jugado+" where id="+id+"";
    	st.execute(Consulta);
		
	}
	public void crear_partido(int equipo1, int equipo2,java.sql.Date sqlDate1,
			int jornada) throws SQLException {
		Statement st = con.createStatement();
		String Consulta="Insert INTO partido(equipo1,equipo2,fecha,jornada,jugado) VALUES ('"+equipo1+"' ,'"+equipo2+"' ,'"+sqlDate1+"' ,'"+jornada+"','"+0+"')";
    	st.execute(Consulta);
		
	}
	public void actualizar_equipo(int id1, int id2, int goles1,
			int goles2, int puntos1, int puntos2) throws SQLException {
		Statement st = con.createStatement();
		String Consulta1="UPDATE equipo set golesfavor=golesfavor+"+goles1+", golescontra=golescontra+"+goles2+" ,puntos=puntos+"+puntos1+" where id="+id1+"";
		String Consulta2="UPDATE equipo set golesfavor=golesfavor+"+goles2+", golescontra=golescontra+"+goles1+" ,puntos=puntos+"+puntos2+" where id="+id2+"";
    	st.execute(Consulta1);
    	st.execute(Consulta2);
	}
}

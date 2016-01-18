package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Categoria;
import entidades.Equipo;
import entidades.Partido;
import entidades.Usuario;

public class EquipoBD extends Conexion{

	public void insertar_equipo(String nombre, String delegado,
			String nombreimagen, int puntos, int favor, int contra,int categoria) throws SQLException {
		Statement st = con.createStatement();
		String Consulta="Insert INTO equipo(nombre,delegado,imagen,puntos,golesfavor,golescontra,categoria) VALUES ('"+nombre+"' ,'"+delegado+"' ,'"+nombreimagen+"' ,'"+puntos+"' ,'"+favor+"','"+contra+"','"+categoria+"')";
    	st.execute(Consulta); 
	}

	public ArrayList<Equipo> obtener_equipos_por_categoria(int categoria) throws SQLException {
		ArrayList<Equipo> equipos=new ArrayList<Equipo>();
		Equipo p=null;
        Statement st = con.createStatement();
        ResultSet rs = null;
    	String Consulta="Select * from equipo where categoria='"+categoria+"'";
    	rs = st.executeQuery(Consulta);
    	while(rs.next())
    	{
    		p= new Equipo(rs.getInt("id"), rs.getString("nombre"), rs.getString("imagen"), rs.getString("delegado"), rs.getInt("puntos"), rs.getInt("golesfavor"), rs.getInt("golescontra"), rs.getInt("categoria"));
    		equipos.add(p);
    	}
		return equipos;
    }

	public ArrayList<Equipo> obtener_clasificacion(String categoria) throws SQLException {
		ArrayList<Equipo> equipos=new ArrayList<Equipo>();
		Equipo p=null;
        Statement st = con.createStatement();
        ResultSet rs = null;
    	String Consulta="Select * from equipo where categoria='"+categoria+"' ORDER BY puntos DESC";
    	rs = st.executeQuery(Consulta);
    	while(rs.next())
    	{
    		p= new Equipo(rs.getInt("id"), rs.getString("nombre"), rs.getString("imagen"), rs.getString("delegado"), rs.getInt("puntos"), rs.getInt("golesfavor"), rs.getInt("golescontra"), rs.getInt("categoria"));
    		equipos.add(p);
    	}
		return equipos;	
	}
		
}

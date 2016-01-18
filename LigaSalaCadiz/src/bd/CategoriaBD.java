package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Categoria;
import entidades.Equipo;
import entidades.Jornada;
import entidades.Noticia;
import entidades.Partido;
import entidades.Usuario;

public class CategoriaBD extends Conexion{
	public ArrayList<Categoria> obtener_categorias() throws SQLException
	{
		JornadaBD jbd=new JornadaBD();
		ArrayList<Categoria> categorias=new ArrayList<Categoria>();
		ArrayList<Jornada> jornada=new ArrayList<Jornada>();
		Categoria cat=null;
		Statement st = con.createStatement();
        ResultSet rs = null;
    	String Consulta="Select * from categoria";
    	rs = st.executeQuery(Consulta);
    	while(rs.next())
    	{
    		jornada= jbd.obtener_jornadas(rs.getInt("id"));
    		cat = new Categoria(rs.getInt("id"), rs.getString("nombre"), jornada);
    		categorias.add(cat);
    	}
		return categorias;
	}
	public ArrayList<Categoria> obtener_categorias_id() throws SQLException
	{
		ArrayList<Categoria> categorias=new ArrayList<Categoria>();
		Categoria c=null;
		Statement st = con.createStatement();
        ResultSet rs = null;
    	String Consulta="Select * from categoria";
    	rs = st.executeQuery(Consulta);
    	while(rs.next())
    	{
    		c= new Categoria(rs.getInt("id"), rs.getString("nombre"));
    		categorias.add(c);
    	}
		return categorias;
	}

	public void insertar_categoria(String nombre) throws SQLException {
		Statement st = con.createStatement();
		String Consulta="Insert INTO categoria(nombre) VALUES ('"+nombre+"')";
    	st.execute(Consulta);
	}
}

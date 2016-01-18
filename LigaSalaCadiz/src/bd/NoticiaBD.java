package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Noticia;


public class NoticiaBD extends Conexion{
    public ArrayList<Noticia> obtener_noticias() throws SQLException
    {
    	Noticia n=null;
    	ArrayList<Noticia> noticias = new ArrayList<Noticia>();
        Statement st = con.createStatement();
        ResultSet rs = null;
    	String Consulta="Select * from noticias ORDER BY fecha DESC";
    	rs = st.executeQuery(Consulta);
    	while(rs.next())
    	{
    		n= new Noticia(rs.getInt("id"),rs.getString("titular"), rs.getString("subtitulo"), rs.getString("cuerpo"), rs.getDate("fecha"), rs.getString("autor"),rs.getString("imagen"));
    		noticias.add(n);
    	}
		return noticias;
    	
    }

	public void insertar_noticia(String titular, String subtitulo,String cuerpo, String fecha, String imagen,String autor) throws SQLException {
		Statement st = con.createStatement();
    	String Consulta="Insert INTO noticias(titular,subtitulo,cuerpo,fecha,autor,imagen) VALUES ('"+titular+"' ,'"+subtitulo+"' ,'"+cuerpo+"' ,'"+fecha+"' ,'"+autor+"','"+imagen+"')";
    	st.execute(Consulta); 
	}
	public Noticia noticia_byid(int id) throws SQLException {
		Noticia n=null;
    	Statement st=con.createStatement();
    	ResultSet rs=null;
    	String Consulta="Select * from noticias where id='"+id+"'";
    	rs=st.executeQuery(Consulta);
    	while(rs.next())
    	{
    		n= new Noticia(rs.getInt("id"), rs.getString("titular"), rs.getString("subtitulo"), rs.getString("cuerpo"), rs.getDate("fecha"), rs.getString("autor"), rs.getString("imagen")) ;
    	}
		return n;
	}
}

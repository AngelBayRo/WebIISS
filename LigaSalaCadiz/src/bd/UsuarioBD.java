package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Usuario;


public class UsuarioBD extends Conexion{
    public Usuario usuario_bynick(String nick) throws SQLException
    {
    	Usuario u=null;
        Statement st = con.createStatement();
        ResultSet rs = null;
    	String Consulta="Select * from usuarios where usuario='"+nick+"'";
    	rs = st.executeQuery(Consulta);
    	if(rs.next())
    	{
    		u= new Usuario(rs.getInt("id"),rs.getString("nombre"), rs.getString("apellido"),rs.getString("usuario"),rs.getString("contrasena"));
    	}
		return u;
    }
    public boolean autenticacion(String usuario,String contrasena) throws SQLException
    {
    	Statement st = con.createStatement();
        ResultSet rs = null;
        String Consulta = "Select * from usuarios";
        rs = st.executeQuery(Consulta);
        
        while(rs.next())
        {
            if(usuario.equals(rs.getString("usuario")) && contrasena.equals(rs.getString("contrasena")))
                return true;
        }
  
        return false;
    	
    }
}

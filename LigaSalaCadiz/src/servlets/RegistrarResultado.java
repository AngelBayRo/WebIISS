package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.JornadaBD;

/**
 * Servlet implementation class RegistarResultado
 */
public class RegistrarResultado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarResultado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JornadaBD jbd=new JornadaBD();
		try {
			jbd.jugar_partido(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("goleslocal")),Integer.parseInt(request.getParameter("golesvisitante")),true);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int goleslocal=Integer.parseInt(request.getParameter("goleslocal"));
		int golesvisitante=Integer.parseInt(request.getParameter("golesvisitante"));
		int puntos1 = 0;
		int puntos2 = 0;
		if(goleslocal==golesvisitante)
		{
			puntos1=1;
			puntos2=1;
		}
		if(goleslocal>golesvisitante)
		{
			puntos1=3;
			puntos2=0;
		}
		if(goleslocal<golesvisitante)
		{
			puntos1=0;
			puntos2=3;
		}
		try {
			jbd.actualizar_equipo(Integer.parseInt(request.getParameter("equipo1")),Integer.parseInt(request.getParameter("equipo2")),Integer.parseInt(request.getParameter("goleslocal")),Integer.parseInt(request.getParameter("golesvisitante")),puntos1,puntos2);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("FormularioResultado?jor="+Integer.parseInt(request.getParameter("jornada")));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

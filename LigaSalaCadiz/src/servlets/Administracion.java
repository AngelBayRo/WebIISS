package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Jornada;
import entidades.Partido;
import bd.JornadaBD;
import bd.UsuarioBD;

/**
 * Servlet implementation class ObtenerCalendario
 */
public class Administracion extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioBD ubd=new UsuarioBD();
		HttpSession session=request.getSession(true);
		try {
			if(ubd.autenticacion(request.getParameter("usuario"), request.getParameter("contrasena")))
			{
				response.sendRedirect("administracion.jsp");
				session.setAttribute("usuariologueado", "permiso");
			}
			else
			{
				response.sendRedirect("logadmin.html");
				session.setAttribute("usuariologueado", "denegado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
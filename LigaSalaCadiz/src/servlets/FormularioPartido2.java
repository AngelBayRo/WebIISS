package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Equipo;
import entidades.Jornada;
import bd.EquipoBD;
import bd.JornadaBD;

/**
 * Servlet implementation class FormularioPartido2
 */
public class FormularioPartido2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioPartido2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EquipoBD ebd= new EquipoBD();
		JornadaBD jbd= new JornadaBD();
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		ArrayList<Jornada> jornadas = new ArrayList<Jornada>();
		try {
			equipos=ebd.obtener_equipos_por_categoria(Integer.parseInt(request.getParameter("cat")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			jornadas=jbd.obtener_jornadas(Integer.parseInt(request.getParameter("cat")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(request.getParameter("cat"));
		request.setAttribute("equipos", equipos);
		request.setAttribute("categoria",request.getParameter("cat"));
		request.setAttribute("jornadas", jornadas);
		request.getRequestDispatcher("crearpartido.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

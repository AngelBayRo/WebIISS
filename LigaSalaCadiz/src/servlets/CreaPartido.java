package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.JornadaBD;

/**
 * Servlet implementation class CreaPartido
 */
public class CreaPartido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaPartido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date date1 = null;
		String s=request.getParameter("fecha").substring(0, 10);
		String s2 =s+" "+request.getParameter("fecha").substring(12);
		
		try {
			date1 = formatter.parse(s2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
		JornadaBD jbd=new JornadaBD();
		
		try {
			jbd.crear_partido(Integer.parseInt(request.getParameter("equipo1")),Integer.parseInt(request.getParameter("equipo2")),sqlDate1,Integer.parseInt(request.getParameter("jornada")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("FormularioPartido2?cat="+request.getParameter("categoria"));
	}

}

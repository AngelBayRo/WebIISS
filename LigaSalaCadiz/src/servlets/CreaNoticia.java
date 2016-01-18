package servlets;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import bd.NoticiaBD;

/**
 * Servlet implementation class CreaNoticia
 */
public class CreaNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
    private static BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT) {
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreimagen = null;
		Map<String,String> atributos=new HashMap<String,String>();
		String uploadPath=null;
		FileItem uploaded=null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		if (isMultipart)
        {
			try 
            {
                List items = null;
				try {
					items = upload.parseRequest(new ServletRequestContext(request));
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) 
                {
                    uploaded = (FileItem) iterator.next();

                    if (uploaded.isFormField()) //your code for getting form fields
                    {
                    	
                        String name = uploaded.getFieldName();
                        String value = uploaded.getString();
                        atributos.put(name, value);
                    }
                    if (!uploaded.isFormField()) 
                    {
                    	nombreimagen=uploaded.getName();
                    	uploadPath = getServletContext().getRealPath("")
        		                + "subidas";
                    	System.out.println(uploadPath);
        			   File uploadDir = new File(uploadPath);
        		        if (!uploadDir.exists()) {
        		            uploadDir.mkdir();
        		        }
        			      File fichero = new File(uploadPath, uploaded.getName());  
        			      try {
        					uploaded.write(fichero);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
                    }
                    
                }
            } finally {
        	    // ... cleanup that will execute whether or not an error occurred ...
        	}
           }
		String ruta=getServletContext().getRealPath("/")+"subidas/"+nombreimagen;
		BufferedImage original= ImageIO.read(new File(ruta));
		BufferedImage redimensionada= resizeImage(original, original.getType(), 1200, 800);
		ImageIO.write(redimensionada, "jpg",new File(getServletContext().getRealPath("/")+"subidas/"+nombreimagen));
		NoticiaBD nbd=new NoticiaBD();
		try {
			nbd.insertar_noticia(atributos.get("titular"),atributos.get("subtitular"),atributos.get("cuerpo"),atributos.get("fecha"),nombreimagen,atributos.get("autor"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("crearnoticias.html");
	}

}

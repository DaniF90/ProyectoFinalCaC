package com.codoacodo2.controllers;

/**
 *
 * @author Daniel
 */
import com.codoacodo2.dao.OradorDAO;
import com.codoacodo2.model.Orador;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/BuscarOradorController")
public class BuscarOradorController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombre = req.getParameter("nombre");
		
		//Crear ProductoDAO
		OradorDAO dao = new OradorDAO();
		
		//invocar el metodo buscar(clave)
		List<Orador> oradores = dao.getByNombre(nombre);
		
		//guardar en el request el producto
		req.setAttribute("oradores", oradores);
		
		//ir a la siguiente pagina
		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
}

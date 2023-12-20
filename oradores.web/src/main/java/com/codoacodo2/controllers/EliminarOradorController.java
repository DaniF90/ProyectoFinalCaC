package com.codoacodo2.controllers;

/**
 *
 * @author Daniel
 */
import com.codoacodo2.dao.OradorDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

@WebServlet("/api/EliminarOradorController")
public class EliminarOradorController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		int id = Integer.parseInt(req.getParameter("id"));
                
                OradorDAO dao = new OradorDAO();
                
                dao.eliminarOrador(id);
		
                resp.sendRedirect(req.getContextPath()+"/api/ListadoOradorController");
	}
}
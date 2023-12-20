package com.codoacodo2.controllers;

import com.codoacodo2.dao.OradorDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet("/api/CrearOradorController")
public class CrearOradorController extends HttpServlet {
    
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
            
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            String email = req.getParameter("email");
            int edad = Integer.parseInt(req.getParameter("edad"));
            String tema = req.getParameter("tema");
            
            //crear OradorDAO
		OradorDAO dao = new OradorDAO();
		
		//Asignarle sus variables
		dao.crearOrador(nombre, apellido, edad, email, tema);
		
		//ir a la siguiente pagina
		resp.sendRedirect(req.getContextPath()+"/api/ListadoOradorController");
        }
    
}

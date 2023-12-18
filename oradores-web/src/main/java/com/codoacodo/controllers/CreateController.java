package com.codoacodo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codoacodo.dao.OradorDAO;
import java.sql.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*HERENCIA*/
//Create Controller es hijo de :
@WebServlet("/api/CreateController")
public class CreateController extends HttpServlet {
static Logger logger = LoggerFactory.getLogger(CreateController.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		Integer edad = req.getIntHeader("edad");//borrar por si no funciona
		String email = req.getParameter("email");
		String tema = req.getParameter("tema");

		
		//crear ProductoDAO
		OradorDAO dao = new OradorDAO();
		
                logger.info("Entro a CreateController" + nombre);
		//ejecutar el metodo crearProducto(parametros...)
		dao.crearOrador(nombre, apellido, edad, email, tema);
		
		//ctrl+shit+o
		//ir a la siguiente pagina
		resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
	}
}

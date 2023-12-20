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
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@WebServlet("/api/EditarOradorController")
public class EditarOradorController extends HttpServlet {
	
        static Logger logger = LoggerFactory.getLogger(EditarOradorController.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
                
		
		//Crear ProductoDAO
		OradorDAO dao = new OradorDAO();
		
                logger.info("String Id: " + id);
		//Instanciar un Orador con el método getByID del OradorDAO.
		Orador oradorDB = dao.getById(id);
		
                logger.info(oradorDB.toString());
		//Guardar el Request                            
		req.setAttribute("orador", oradorDB);
		
		//ir a la siguiente pagina
		getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id_orador = req.getParameter("id");
                String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
                int edad = Integer.parseInt(req.getParameter("edad"));
		String email = req.getParameter("email");
		String tema = req.getParameter("tema");
                
		//Crear OradorDAO
		OradorDAO dao = new OradorDAO();
                Orador oraActualizado = new Orador(Integer.valueOf(id_orador), nombre, apellido, edad, email, tema);
		//Invocamos el Método 
                logger.info("id orador: "+id_orador);
		dao.actualizarOrador(oraActualizado);

		//ir a la siguiente pagina
		resp.sendRedirect(req.getContextPath()+"/api/ListadoOradorController");
	}
}

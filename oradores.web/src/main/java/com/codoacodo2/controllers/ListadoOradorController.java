package com.codoacodo2.controllers;

import com.codoacodo2.dao.OradorDAO;
import com.codoacodo2.model.Orador;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/api/ListadoOradorController")
public class ListadoOradorController extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException{
       
        //creo la instancia de oradorDAO
        OradorDAO dao = new OradorDAO();
        
        //invocar al metodo listarOradores()
        List<Orador> listado = dao.listaDeOradores();
        
        //grabar el listado en el request para que lo vea la siguiente pagina
        req.setAttribute("listado", listado);
		
	//ir a la siguiente pagina
	getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
    }
    
}

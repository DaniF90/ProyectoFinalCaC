package com.codoacodo.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codoacodo.connection.AdministradorDeConexiones;
import com.codoacodo.model.Orador;
import java.sql.Timestamp;

@WebServlet("/api/ConsultarController")
public class ConsultarController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		//validaciones!!!
		
		String sql = "SELECT * FROM ORADORES WHERE ID = " + id;
		
		//conexion OK
		Connection con = AdministradorDeConexiones.getConnection();
		
		try {
			//statement 
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {//�hay datos?
				// rs > sacando los datos
				Long idOrador = rs.getLong(1);//tomar la primer columna
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				int edad = rs.getInt(4);
				String email = rs.getString(5);
				String tema = rs.getString(6);
				Timestamp fechaAlta = rs.getTimestamp(7);
				
				//campos crear un objeto????
				Orador prodFromDb = new Orador(idOrador,nombre,apellido,edad,email,tema,fechaAlta);
				
				//ir a otra pagina y ademas pasarle datos
				
				req.setAttribute("orador", prodFromDb);
			}
			
			getServletContext().getRequestDispatcher("/detalle.jsp").forward(req, resp);
			
			//cierre de conexion
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

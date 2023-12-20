package com.codoacodo2.controllers;

/**
 *
 * @author Daniel
 */
import com.codoacodo2.connection.AdministradorDeConexiones;
import com.codoacodo2.model.Orador;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

@WebServlet("/api/ConsultarController")
public class ConsultarOradorController extends HttpServlet {
	
        @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
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
                                
				int id_orador = rs.getInt(1);//tomar la primer columna
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
                                int edad = rs.getInt(4);
				String email = rs.getString(5);
				String tema = rs.getString(6);
				Timestamp fecha_alta = rs.getTimestamp(7);
				
				//campos crear un objeto????
				Orador oradorDB = new Orador(id_orador,nombre,apellido,edad,email,tema, fecha_alta);
				
				//ir a otra pagina y ademas pasarle datos
				
				req.setAttribute("orador", oradorDB);
			}
			
			getServletContext().getRequestDispatcher("/detalle.jsp").forward(req, resp);
			
			//cierre de conexion
			con.close();
		}catch (ServletException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}

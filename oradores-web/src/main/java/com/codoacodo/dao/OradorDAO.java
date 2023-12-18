package com.codoacodo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.codoacodo.connection.AdministradorDeConexiones;
import com.codoacodo.model.Orador;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class OradorDAO {

        private static final String SQL_DELETE = "DELETE FROM oradores WHERE ID = ?";
	/*metodos del crud*/
	public Orador obtenerPorId(Long id) {
		String sql = "SELECT * FROM ORADORES WHERE ID="+id;
		
		//Connection
		Connection con = AdministradorDeConexiones.getConnection();
	
		Orador prodFromDb = null;
		
		//Statement
		try {
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			
			//VIENE UN SOLO REGISTRO!!!
			
			if(rs.next()) {//si existe, hay uno solo
				// rs > sacando los datos
				Long idOrador = rs.getLong(1);//tomar la primer columna
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				int edad = rs.getInt(4);
				String email = rs.getString(5);
				String tema = rs.getString(6);
				Timestamp fechaAlta = rs.getTimestamp(7);
				
				//campos crear un objeto????
				prodFromDb = new Orador(idOrador,nombre,apellido,edad,email,tema,fechaAlta);
			}			
		} catch (SQLException e) {
			// ERRORES
			e.printStackTrace();
		}
		return prodFromDb;
	}
	

	/*metodos del crud*/
	public List<Orador> listarOradores() {
		String sql = "SELECT * FROM ORADORES ";
		
		//Connection
		Connection con = AdministradorDeConexiones.getConnection();
	
		List<Orador> list = new ArrayList<>();
		
		//Statement
		try {
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			
			//VIENE UN SOLO REGISTRO!!!
			
			while(rs.next()) {//
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
				
				//agrego a la lista 
				list.add(prodFromDb);
			}			
			
			//cierro la conexion
			con.close();
		} catch (SQLException e) {
			// ERRORES
			e.printStackTrace();
		}
		return list;
	}

	/*crear un producto en la db*/
	public void crearOrador(String nombre, String apellido, Integer edad, String email, String tema) {
		
		Connection con = AdministradorDeConexiones.getConnection();
		
		if(con != null) { 
			// insert en la db > SQL: INSERT INTO....
			String sql = "INSERT INTO PRODUCTO (nombre, precio,fecha_creacion,imagen,codigo,hecho_en) ";
			sql += "VALUES('"+nombre+"',"+apellido+"',"+edad+"','"+email+"','"+tema+"')";
			
			//control de errores
			try {
				Statement st = con.createStatement();			
				st.execute(sql);
				
				//cierre de conexion
				con.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void actualizarOrador(String nombre, String apellido, String edad, String tema) {
		Connection con = AdministradorDeConexiones.getConnection();
		if(con != null) { 
			String sql = "UPDATE PRODUCTO "
					+ " set nombre='"+nombre+"',"
					+ " apellido='"+apellido+"',"
					+ " edad='"+ edad +"'"
					+ " WHERE codigo = '"+tema+"'";		
		
			try {
				Statement st = con.createStatement();			
				st.executeUpdate(sql);
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*metodos del crud*/
	public List<Orador> buscar(String clave) {
		String sql = "SELECT * FROM Oradores WHERE nombre LIKE '%"+clave+"%' ";
		
		//Connection
		Connection con = AdministradorDeConexiones.getConnection();
	
		List<Orador> listado = new ArrayList<Orador>();
		
		//Statement
		try {
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			
			//VIENE UN SOLO REGISTRO!!!
			
			while(rs.next()) {//si existe, hay uno solo
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
				
				listado.add(prodFromDb);
			}	
		} catch (SQLException e) {
			// ERRORES
			e.printStackTrace();
		}
		
		return listado;
	}
        
        public int eliminarOrador(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try{
            conn = AdministradorDeConexiones.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch(SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch(SQLException | NullPointerException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
}
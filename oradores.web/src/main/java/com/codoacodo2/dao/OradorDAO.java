package com.codoacodo2.dao;

/**
 *
 * @author Daniel
 */
import com.codoacodo2.connection.AdministradorDeConexiones;
import com.codoacodo2.model.Orador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.sql.Timestamp;

import java.sql.PreparedStatement;

public class OradorDAO {

    private static final String SQL_DELETE = "DELETE FROM oradores WHERE ID = ?";
    private static final String SQL_OBTENER_ID = "SELECT * FROM oradores WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE oradores SET nombre = ?, apellido = ?, edad = ?, email = ?, tema = ? WHERE ID = ?";

    //instancio el logger
    static Logger logger = LoggerFactory.getLogger(OradorDAO.class);
    //Métodos de Búsqueda
    //Búsqueda por ID
    public Orador getById(int idx) {
        //Conexión
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        Orador oradFromDb = null;

        //Statement
        try {
            con = AdministradorDeConexiones.getConnection();

            stmt = con.prepareStatement(SQL_OBTENER_ID);
            stmt.setInt(1, idx);
            ResultSet rs = stmt.executeQuery();

            //Recupera como máximo un sólo elemento
            if(rs.next()) {//si existe, hay uno solo
                    // rs > sacando los datos
                    int id = rs.getInt(1);//tomar la primer columna
                    String nombre = rs.getString(2);
                    String apellido = rs.getString(3);
                    int edad = rs.getInt(4);
                    String email = rs.getString(5);
                    String tema = rs.getString(6);
                    Timestamp fecha_alta = rs.getTimestamp(7);

                    logger.info(id+nombre+apellido+edad+email+tema+fecha_alta);
                    //Se instancia un Orador y se le asignan los valores  recuperados de la DB.
                    oradFromDb = new Orador(id,nombre,apellido,edad,email,tema, fecha_alta);
            }			
        } catch (SQLException e) {
                // ERRORES
                e.printStackTrace();
        }
        return oradFromDb;
    }

    //Búsqueda por Nombre
    public List<Orador> getByNombre(String id_orador) {
            String sql = "SELECT * FROM ORADORES WHERE nombre LIKE '%"+id_orador+"%' ";

            //Conexión
            Connection con = AdministradorDeConexiones.getConnection();

            List<Orador> oradores = new ArrayList<>();

            //Statement
            try {
                    Statement st = con.createStatement();

                    //resultset
                    ResultSet rs = st.executeQuery(sql);

                    //Puede que recuperemos ningún registro, uno solo o más de uno.

                    while(rs.next()) {
                            // rs > sacando los datos
                            int id = rs.getInt(1);
                            String nombre = rs.getString(2);
                            String apellido = rs.getString(3);
                            int edad = rs.getInt(4);
                            String email = rs.getString(5);
                            String tema = rs.getString(6);
                            Timestamp fecha_alta = rs.getTimestamp(7);


                            //Instanciamos el y se le asignan los valores  recuperados de la DB.
                            Orador oradorDB = new Orador(id,nombre,apellido,edad,email,tema, fecha_alta);

                            //Si el orador está vigente, se agrega a la lista
                            oradores.add(oradorDB);
                    }	
            } catch (SQLException e) {
                    // ERRORES
                    e.printStackTrace();
            }

            return oradores;
    }


    //métodos del CRUD

    //Create
    public void crearOrador(String nombre, String apellido, Integer edad, String email,String tema) {

            Connection con = AdministradorDeConexiones.getConnection();

            if(con != null) { 
                    // Se declara el INSERT a la base
                    String sql = "INSERT INTO ORADORES (nombre, apellido, edad, email, tema) ";
                    sql += "VALUES('"+nombre+"','"+apellido+"','"+edad+"','"+email+"','"+tema+"')";

                    //Try-Catch
                    try {
                            Statement st = con.createStatement();			
                            //Se ejecuta el insert
                            st.execute(sql);

                            //Se cierra la conexión
                            con.close();

                    }catch (Exception e) {
                            e.printStackTrace();
                    }
            }
    }

    //Read
    @SuppressWarnings("empty-statement")
    public List<Orador> listaDeOradores() {
            String sql = "SELECT * FROM ORADORES ";

            //Conexión
            Connection con = AdministradorDeConexiones.getConnection();

            List<Orador> list = new ArrayList<>();

            //Statement
            try {
                    Statement st = con.createStatement();

                    //resultset
                    ResultSet rs = st.executeQuery(sql);

                    //Devuelve todos los registros que haya (cero o más).

                    while(rs.next()) {//
                            // rs > sacando los datos
                            int id = rs.getInt(1);//tomar la primer columna
                            String nombre = rs.getString(2);
                            String apellido = rs.getString(3);
                            int edad = rs.getInt(4);
                            String email = rs.getString(5);
                            String tema = rs.getString(6);
                            Timestamp fecha_alta = rs.getTimestamp(7);


                            //Crear una instancia de orador
                            Orador oradorDB = new Orador(id,nombre,apellido,edad,email, tema, fecha_alta);

                            //Si el Orador está vigente (estado = True), lo agrego a la lista 
//				if(estado)
//                                {
//                                    list.add(oradorDB);
//                                }
                        list.add(oradorDB);
                    }			

                    //cierro la conexion
                    con.close();
            } catch (SQLException e) {
                    // ERRORES
                    e.printStackTrace();
            }
            return list;
    }


    //Update
    public int actualizarOrador(Orador ora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try{
            conn = AdministradorDeConexiones.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, ora.getNombre());
            stmt.setString(2, ora.getApellido());
            stmt.setInt(3, ora.getEdad());
            stmt.setString(4, ora.getEmail());
            stmt.setString(5, ora.getTema());
            stmt.setInt(6, ora.getId());
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

    //Delete	      
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
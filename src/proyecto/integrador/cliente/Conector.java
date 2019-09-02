/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.integrador.cliente;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conector {
     
    String url = "../base-de-prueva.db";
    Connection connect;
    Statement enun;
    
     
    public void connect(){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            if (connect!=null) {
                System.out.println("Conectado");
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
    }
    public void close(){
        try {
            connect.close();
            System.out.println("La base de datos se cerro correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("No se pudo serrar la conexion\n" + ex.getMessage() + "\nla base de datos esta\n" + ex.getSQLState());
        }
    }
    
    public void saveAlumno(Alumno alumno){
        try {
            PreparedStatement st = connect.prepareStatement("insert into alumnos (nombre, apellidos) values (?,?)");
            st.setString(1, alumno.getNombre());
            st.setString(2, alumno.getApellidos());
            st.execute();
        } catch (SQLException ex) {
            System.err.println("No se logro enviar los datos al servidor\n");
            System.err.println(ex.getMessage());
        }

    }
    
    public ResultSet mostrarDatos(){
        ResultSet resultados = null;
        try {
            enun = connect.createStatement();
            resultados = enun.executeQuery("SELECT * FROM alumnos;");
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return resultados;
    }    
}
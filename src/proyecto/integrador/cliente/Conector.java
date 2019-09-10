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
    
    public void saveCliente(Cliente cliente){
        try {
            PreparedStatement st = connect.prepareStatement("insert into cliente (name, club, DNI, gmail, pocision) values (?,?,?,?,?)");
            st.setString(1, cliente.getName());
            st.setString(2, cliente.getClub());
            st.setString(3, cliente.getDNI());
            st.setString(4, cliente.getGmail());
            st.setString(5, cliente.getPosicion());
            st.execute();
        } catch (SQLException ex) {
            System.err.println("No se logro enviar los datos al servidor\n");
            System.err.println(ex.getMessage());
        }

    }
    
    public void saveJugador(Jugador jugador){
        try {
            PreparedStatement st = connect.prepareStatement("insert into jugador (nombre, edad, DNI, gmail, pocision) values (?,?,?,?,?)");
            st.setString(1, jugador.getNombre());
            st.setString(2, jugador.getEdad());
            st.setString(3, jugador.getDNI());
            st.setString(4, jugador.getGmail());
            st.setString(5, jugador.getPosicion());
            st.execute();
        } catch (SQLException ex) {
            System.err.println("No se logro enviar los datos al servidor\n");
            System.err.println(ex.getMessage());
        }

    }
    
    public void savePartido(Partido partido){
        try {
            PreparedStatement st = connect.prepareStatement("insert into partido (miEquipo, misPuntos, fecha, susPuntos, suEquipo) values (?,?,?,?,?)");
            st.setString(1, partido.getMiEquipo());
            st.setString(2, partido.getMisPuntos());
            st.setString(3, partido.getFecha());
            st.setString(4, partido.getSusPuntos());
            st.setString(5, partido.getSuEquipo());
            st.execute();
        } catch (SQLException ex) {
            System.err.println("No se logro enviar los datos al servidor\n");
            System.err.println(ex.getMessage());
        }

    }
    
    
    public ResultSet mostrarDatosJugador(){
        ResultSet resultados = null;
        try {
            enun = connect.createStatement();
            resultados = enun.executeQuery("SELECT * From jugador;");
        } 
        catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return resultados;
    }

    public ResultSet mostrarDatosCliente(Mensaje m){
        ResultSet resultados = null;
        try {
            enun = connect.createStatement();
            resultados = enun.executeQuery("SELECT * From cliente where DNI = " + "'" + m.getDni() + "'");
        } 
        catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return resultados;
    }
    
    public ResultSet mostrarDatosPartido(){
        ResultSet resultados = null;
        try {
            enun = connect.createStatement();
            resultados = enun.executeQuery("SELECT * From partido;");
        } 
        catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return resultados;
    }
    
    public boolean controlarCredenciales(String nombre, String password)
    {
        connect();
        try
        {
            Statement stmt = connect.createStatement();
            ResultSet rs = 
                    stmt.executeQuery("select name from cliente where name = '" 
                            + nombre + "' and dni = '" 
                            + password + "'");
            if (rs.next())
            {
                connect.close();
                return true;
            }
            else
            {
                connect.close();
                return false;
            }
                
        }
        catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return false;      
    }
    
    public ResultSet borrarJugador(String n) throws SQLException{
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery("delete from jugador where DNI = " + "'"+ n +"'");
        return rs;
    }

    public ResultSet borrarPartido(String n) throws SQLException{
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery("delete from partido where fecha = " + "'"+ n +"'");
        return rs;
    }    
    
}
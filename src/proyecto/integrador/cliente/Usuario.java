/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.integrador.cliente;

/**
 *
 * @author nico
 */
public class Usuario {
    
    private String DNI;
    private String gmail;
    private String posicion;
    
    
    public Usuario(){
        DNI = "";
        gmail = "";
        posicion = "";
    }

    public Usuario(String DNI, String gmail, String posicion) {
        this.DNI = DNI;
        this.gmail = gmail;
        this.posicion = posicion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void save(){
        Conector con = new Conector();
        con.connect();
        con.close();
    }

    @Override
    public String toString() {
        return "Usuario{" + "DNI=" + DNI + ", gmail=" + gmail + ", posicion=" + posicion + '}';
    }
    
    

    
    
    
}

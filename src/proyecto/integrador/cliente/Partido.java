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
public class Partido {
    
    private String miEquipo;
    private String misPuntos;
    private String fecha;
    private String susPuntos;
    private String suEquipo;
    
    public Partido(){
        miEquipo="";
        misPuntos="";
        fecha="";
        susPuntos="";
        suEquipo="";
    }

    public Partido(String miEquipo, String misPuntos, String fecha, String susPuntos, String suEquipo) {
        this.miEquipo = miEquipo;
        this.misPuntos = misPuntos;
        this.fecha = fecha;
        this.susPuntos = susPuntos;
        this.suEquipo = suEquipo;
    }

    public String getMiEquipo() {
        return miEquipo;
    }

    public void setMiEquipo(String miEquipo) {
        this.miEquipo = miEquipo;
    }
    
    public String getMisPuntos() {
        return misPuntos;
    }

    public void setMisPuntos(String misPuntos) {
        this.misPuntos = misPuntos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSusPuntos() {
        return susPuntos;
    }

    public void setSusPuntos(String susPuntos) {
        this.susPuntos = susPuntos;
    }

    public String getSuEquipo() {
        return suEquipo;
    }

    public void setSuEquipo(String suEquipo) {
        this.suEquipo = suEquipo;
    }

    public void save(){
        Conector con = new Conector();
        con.connect();
        con.savePartido(this);
        con.close();
    }
    
    @Override
    public String toString() {
        return "Partido{" + "misPuntos=" + misPuntos + ", fecha=" + fecha + ", susPuntos=" + susPuntos + ", suEquipo=" + suEquipo + '}';
    }
    
    
    
    
}

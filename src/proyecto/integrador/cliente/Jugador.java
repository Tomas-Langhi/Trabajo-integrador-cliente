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
public class Jugador extends Usuario{
    
    private String nombre;
    private String edad;

    public Jugador(){
        super();
        nombre = "";
        edad = "";
    }

    public Jugador(String nombre, String edad, String DNI, String gmail, String posicion) {
        super(DNI, gmail, posicion);
        this.nombre = nombre;
        this.edad = edad;
        
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    @Override
        public void save(){
        Conector con = new Conector();
        con.connect();
        con.saveJugador(this);
        con.close();
        }

    @Override
    public String toString() {
        return "Jugador{" + super.toString() + "nombre=" + nombre + ", edad=" + edad + '}';
    }
        

    
    
    
    
    
}
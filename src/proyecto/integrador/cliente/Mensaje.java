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
public class Mensaje {
    
    private String nombre;
    private String dni;
    
    
    public Mensaje(){
        nombre = "";
        dni = "";
    }

    public Mensaje(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "nombre=" + nombre + ", dni=" + dni + '}';
    }
    
    
}

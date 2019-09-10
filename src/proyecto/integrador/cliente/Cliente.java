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
public class Cliente extends Usuario{
    
    private String name;
    private String club;
    
    public Cliente(){
        super();
        name = "";
        club = "";
    }

    public Cliente(String name, String club, String DNI, String gmail, String posicion) {
        super(DNI, gmail, posicion);
        this.name = name;
        this.club = club;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
    
    
    @Override
    public void save(){
        Conector con = new Conector();
        con.connect();
        con.saveCliente(this);
        con.close();
    }
    
    @Override
    public String toString() {
        return "Cliente{" +super.toString() +  "Name=" + name + ", club=" + club + '}';
    }
    
    
    
}

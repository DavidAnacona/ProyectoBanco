package Modelo;

import java.util.StringTokenizer;


public class Cliente {
    
    private Long numIdentidad;
    private String nombre;
    private String correo;
    private Long celular;
    private String direccion;

    public Cliente() {
    }

    public Cliente(Long numIdentidad, String nombre, String correo, Long celular, String direccion) {
        this.numIdentidad = numIdentidad;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
    }
    
    
    public Cliente(String linea){
        StringTokenizer token = new StringTokenizer(linea,"*");
        numIdentidad = Long.parseLong(token.nextToken());
        nombre = token.nextToken();
        correo = token.nextToken();
        celular = Long.parseLong(token.nextToken());
        direccion = token.nextToken();
    }

    public Long getNumIdentidad() {
        return numIdentidad;
    }

    public void setNumIdentidad(Long numIdentidad) {
        this.numIdentidad = numIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String toRegistro(){
        return "*" + numIdentidad + "*" + nombre + "*" + correo + "*" + celular + "*" + direccion; 
    }
    
    @Override
    public String toString(){
        return numIdentidad + "  " + nombre + "  " + celular ; 
    }
    
}

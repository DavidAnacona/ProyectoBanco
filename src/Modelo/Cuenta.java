
package Modelo;

import java.util.ArrayList;

public class Cuenta {
    
    private String clave;
    private String numeroCuenta;
    private double saldoPromedio;
    private Cliente cliente;
    private ArrayList<Movimiento> listaMovimientos;

    public Cuenta() {
    }

    public Cuenta(String clave, String numeroCuenta, double saldoPromedio, Cliente cliente) {
        this.clave = clave;
        this.numeroCuenta = numeroCuenta;
        this.saldoPromedio = saldoPromedio;
        this.listaMovimientos = new ArrayList();
    }

    public ArrayList<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(ArrayList<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldoPromedio() {
        return saldoPromedio;
    }

    public void setSaldoPromedio(double saldoPromedio) {
        this.saldoPromedio = saldoPromedio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
        
}

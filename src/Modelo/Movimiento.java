
package Modelo;

import java.util.Date;

public class Movimiento {
    
    private Date fecha;
    private double valor;
    private TipoMovimiento tipoMovimiento;

    public Movimiento() {
    }

    public Movimiento(Date fecha, double valor, TipoMovimiento tipoMovimiento) {
        this.fecha = fecha;
        this.valor = valor;
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
    
    
}

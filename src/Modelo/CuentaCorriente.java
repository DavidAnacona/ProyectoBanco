
package Modelo;

public class CuentaCorriente implements TipoCuenta{

    @Override
    public int getCostoChequera() {
        return 1;
    }

    @Override
    public int getCuotaManejo() {
        return 1;
    }

    @Override
    public float getInteres() {
       return 1;
    }

    @Override
    public double getSaldoMinimo() {
        return 1;
    }
    
}

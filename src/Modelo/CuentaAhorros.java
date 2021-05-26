
package Modelo;

public class CuentaAhorros implements TipoCuenta{

    @Override
    public int getCostoChequera() {
        return 2;
    }

    @Override
    public int getCuotaManejo() {
        return 2;
    }

    @Override
    public float getInteres() {
        return 2;
    }

    @Override
    public double getSaldoMinimo() {
        return 2;
    }
    
}

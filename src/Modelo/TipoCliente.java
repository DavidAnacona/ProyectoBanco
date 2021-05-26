
package Modelo;

public class TipoCliente {
    
    private int codigo;
    private String tipo;

    public TipoCliente() {
    }

    public TipoCliente(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}

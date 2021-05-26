
package Modelo;

import java.util.StringTokenizer;

public class TipoCliente {
    
    private int codigo;
    private String tipo;

    public TipoCliente() {
    }

    public TipoCliente(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public TipoCliente(String linea){
        StringTokenizer token = new StringTokenizer(linea,"*");
        codigo = Integer.parseInt(token.nextToken());
        tipo = token.nextToken();   
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
    
    public String toRegistro(){
        return "*" + codigo + "*" + tipo;
    }
    
    @Override
    public String toString(){
        return codigo + "    " + tipo;
    }
}

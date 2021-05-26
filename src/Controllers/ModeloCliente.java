
package Controllers;

import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import resources.ListaDoble;

public class ModeloCliente extends AbstractTableModel{
    
    private List<String> titulos;
    private ListaDoble<Cliente> lista;
    
    public ModeloCliente(){
        this.lista = new ListaDoble<>();
        titulos = new ArrayList();
        titulos.add("codigo");
        titulos.add("nombre");
        titulos.add("correo");
        titulos.add("celular");
        titulos.add("direccion");
    }
    public ModeloCliente(ListaDoble<Cliente> lista){
        this.lista = new ListaDoble<>();
        titulos = new ArrayList();
        titulos.add("codigo");
        titulos.add("nombre");
        titulos.add("precio");
        titulos.add("cantidad");
        titulos.add("descripcion");
    }
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = lista.contain(+1);
        switch(columnIndex){
            case 0:
                return cliente.getNumIdentidad();
            case 1:
                return cliente.getNombre();
            case 2:
                return cliente.getCorreo();
            case 3:
                return cliente.getCelular();
            case 4:
                return cliente.getDireccion();
            default:
                return null;
        }
    }
    
    public String getColumnName(int columnIndex){
        return titulos.get(columnIndex);
    }
    
    public Object getValueAt(int rowIndex){
        return lista.contain(rowIndex+1);
    }
}

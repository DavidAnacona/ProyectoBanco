
package Controllers;

import Modelo.TipoCliente;
import persist.TipoClienteDAO;
import resources.ListaDoble;
public class TipoClienteCtrl {
    
    private TipoCliente tipocliente;
    private ListaDoble<TipoCliente> listaTipos;
    private static TipoClienteCtrl tipoclienteCtrl;
    private int indexTipoClienteSelect;
    
    private TipoClienteCtrl(){
        listaTipos = cargarTiposClientes();
        tipocliente = null;
    }
    
    private ListaDoble<TipoCliente> cargarTiposClientes(){
        return TipoClienteDAO.instancia().consultarTipoClientes();
    }
    
    public static TipoClienteCtrl instancia(){
        
        if(tipoclienteCtrl == null){
            tipoclienteCtrl = new TipoClienteCtrl();
        }
        return tipoclienteCtrl;
    }

    public TipoCliente getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(TipoCliente tipocliente) {
        this.tipocliente = tipocliente;
    }

    public ListaDoble<TipoCliente> getListaTipos() {
        return listaTipos;
    }

    public void setListaTipos(ListaDoble<TipoCliente> listaTipos) {
        this.listaTipos = listaTipos;
    }
    
    public void addTipoCliente(String codigo, String tipo){
        this.tipocliente = new TipoCliente();
        this.tipocliente.setCodigo(Integer.parseInt(codigo));
        this.tipocliente.setTipo(tipo);
        this.listaTipos.add(tipocliente);
    }
    
    public void buscarTipoCliente(int index){
        tipocliente = listaTipos.contain(index + 1);
        indexTipoClienteSelect = index + 1;
    }
    
    public void buscarTipoClientePorCodigo(int codigo){
        tipocliente = null;
        TipoCliente tipcli = null;
        listaTipos.inicio();
        for(int i=0; i<listaTipos.size(); i++){
            tipcli = listaTipos.next();
            if(tipcli.getCodigo() == codigo){
                tipocliente = tipcli;
            }
        }
    }
    public void modificarTipoCliente(String codigo, String tipo){
        this.tipocliente.setCodigo(Integer.parseInt(codigo));
        this.tipocliente.setTipo(tipo);
        this.listaTipos.set(indexTipoClienteSelect, tipocliente);
    }
    
    public void guardarTipoCliente(){
        TipoClienteDAO.instancia().guardarTipoClientes(listaTipos);
    }
    
    public void eliminarTipoCliente(){
        listaTipos.remove(tipocliente);
    }
}

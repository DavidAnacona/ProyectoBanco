
package Controllers;

import resources.ListaDoble;
import persist.ClienteDAO;
import Modelo.Cliente;
import Modelo.TipoCliente;

public class ClienteCtrl {
    
    private Cliente cliente;
    private ListaDoble<Cliente> listaClientes;
    private static ClienteCtrl clienteCtrl;
    private int indexClienteSelect;
    
    public ClienteCtrl(){
        listaClientes = cargarClientes();
        cliente = null;
    }
    
    private ListaDoble<Cliente> cargarClientes(){
        return ClienteDAO.instancia().consultarCliente();
    }
    
    public static ClienteCtrl instancia(){
        if(clienteCtrl == null){
            clienteCtrl = new ClienteCtrl();
        }
        return clienteCtrl;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ListaDoble<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ListaDoble<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    public void addCliente(String codigo, String nombre, String correo,String celular, String direccion, TipoCliente tipoCliente) {
        this.cliente = new Cliente(); 
        this.cliente.setNumIdentidad(Long.parseLong(codigo));
        this.cliente.setNombre(nombre);       
        this.cliente.setCorreo(correo);
        this.cliente.setCelular(Long.parseLong(celular)); 
        this.cliente.setDireccion(direccion);
        this.cliente.setTipoCliente(tipoCliente);
        this.listaClientes.add(cliente);
    }
    
    public void buscarCliente(int index){
        cliente = listaClientes.contain(index+1);
        indexClienteSelect=index +1;
    }

    public void buscarClientePorCodigo(int codigo){
        cliente = null;
        Cliente cli = null;
        listaClientes.inicio();
        for(int i =0; i<listaClientes.size();i++){
            cli = listaClientes.next();
            if(cli.getNumIdentidad() == codigo){
                cliente = cli;
            }
        }
    }
    
    public void modificarCliente(String codigo, String nombre, String correo, String celular, String direccion, TipoCliente tipoCliente) {
        this.cliente = new Cliente(); 
        this.cliente.setNumIdentidad(Long.parseLong(codigo));
        this.cliente.setNombre(nombre);
        this.cliente.setCorreo(correo);
        this.cliente.setCelular(Long.parseLong(celular));
        this.cliente.setDireccion(direccion);
        this.cliente.setTipoCliente(tipoCliente);
        this.listaClientes.set(indexClienteSelect, cliente);
    }
    
    public void guardarCliente(){
        ClienteDAO.instancia().guardarCliente(listaClientes);
    }
    public void eliminarCliente(){
        listaClientes.remove(cliente);
    }
    
    public ModeloCliente buscarClientePorTipo(Object tipocliente){
        TipoCliente tipcli = (TipoCliente)tipocliente;
        ListaDoble<Cliente> listaFiltrada = new ListaDoble();
        listaClientes.inicio();
        for(int i = 0; i<listaClientes.size();i++){
            Cliente cli = listaClientes.next();
            if(cli.getTipoCliente().getCodigo() == tipcli.getCodigo()){
                listaFiltrada.add(cli);
            }
        }
        ModeloCliente modelo = new ModeloCliente(listaFiltrada);
        return modelo;
    }
}

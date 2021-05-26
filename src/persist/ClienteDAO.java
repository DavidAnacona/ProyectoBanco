package persist;

import Modelo.Cliente;
import java.io.*;
import Modelo.Cliente;
import resources.ListaDoble;


public class ClienteDAO {
    
    private String fileName;
    private BufferedReader br;
    private BufferedWriter bw;
    private static ClienteDAO clienteDAO;
    
    private ClienteDAO(){
        fileName = "Clientes.txt";
    }
    
    public static ClienteDAO instancia(){
        if(clienteDAO == null){
            clienteDAO = new ClienteDAO();
        }
        return clienteDAO;
    }
    
    public String guardarCliente(ListaDoble lista){
        String mensaje="";
        try{
            bw = new BufferedWriter(new FileWriter(fileName));
            lista.inicio();
            for(int i=1; i <=lista.size();i++){
                Cliente cliente = (Cliente)lista.contain(i);
                bw.append(cliente.toRegistro());
                bw.newLine();
            }
            bw.close();
            mensaje = "El registro se ha guardado con exito";
        }catch(IOException e){
            mensaje = "El registro tuvo un error al guardarse"+e;
        }
        return mensaje;
    }
    
    public ListaDoble<Cliente> consultarCliente(){
        Cliente cliente;
        ListaDoble<Cliente> lista = new ListaDoble();
        String linea;
        try{
            br = new BufferedReader(new FileReader(fileName));
            linea = br.readLine();
            while(linea!=null){
                cliente = new Cliente(linea);
                lista.add(cliente);
                linea = br.readLine();
            }
        }catch(IOException e){
            
        }
        return lista;
    }
    
    
}

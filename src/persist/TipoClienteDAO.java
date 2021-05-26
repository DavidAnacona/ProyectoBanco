
package persist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import Modelo.TipoCliente;
import resources.ListaDoble;

public class TipoClienteDAO {
    
    private String fileName;
    private BufferedWriter bw;
    private BufferedReader br;
    private static TipoClienteDAO tipoclienteDAO;
    
    public TipoClienteDAO(){
        fileName = "tipoCliente.txt";
    }
    
    public static TipoClienteDAO instancia(){
        
        if(tipoclienteDAO == null){
            tipoclienteDAO = new TipoClienteDAO();
        }
        return tipoclienteDAO;
    }
    
    public String guardarTipoClientes(ListaDoble lista){
        String mensaje="";
        try{
            bw = new BufferedWriter(new FileWriter(fileName));
            lista.inicio();
            for(int i=1; i<=lista.size(); i++){
                TipoCliente tipocliente = (TipoCliente)lista.contain(i);
                bw.append(tipocliente.toRegistro());
                bw.newLine();
            }
            bw.close();
            mensaje = "Registro agregado con exito";
        }catch(IOException e){
            mensaje = "Error al agregar el registro" + e.getMessage();
        }
        return mensaje;
    }
    public ListaDoble<TipoCliente> consultarTipoClientes(){
        
        TipoCliente tipocliente;
        ListaDoble<TipoCliente> lista = new ListaDoble();
        String linea;
        try{
            br = new BufferedReader(new FileReader(fileName));
            linea = br.readLine();
            while(linea!=null){
                tipocliente = new TipoCliente(linea);
                lista.add(tipocliente);
                linea = br.readLine();
            }
            br.close();
        }catch(IOException e){
            
        }
        return lista;
    }
}

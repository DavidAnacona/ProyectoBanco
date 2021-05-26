package resources;

public class ListaDoble<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private Nodo<T> aux;
    private int size;
    
    public ListaDoble(){
        cabeza=null;
        cola=null;
        size=0;
    }
    
    public void add(T dato){
        Nodo<T> nodo = new Nodo(dato);
        if(cabeza==null){
           cabeza = nodo; 
           cola =nodo;
        }else{
            cola.setSig(nodo);
            nodo.setAnt(cola);
            cola = nodo;
        }
        size++;
    }
    
    public void inicio(){
        aux = cabeza;
    }
    
    
    public T next(){
        T t;
        if(aux!=null){
            t = aux.getDato();
            aux = aux.getSig();
            return t;
        }
        return null;
    }
    
    public void fin(){
        aux = cola;
    }
    
    public T anterior(){
        T t;
        if(aux!=null){
            t= aux.getDato();
            aux = aux.getAnt();
            return t;
        }
        return null;
    }
    
    public int size(){
        return size;
    }
    
    public boolean remove(T t){
        boolean encontro = true;
        aux = seek(t);
        if(aux!=null){
            if(aux==cabeza){
                if(cabeza == cola){
                    cabeza=null;
                    cola=null;
                }else{
                    cabeza = cabeza.getSig();
                    aux.setSig(null);
                    cabeza.setAnt(null);
                }
            }else{
                if(aux==cola){
                    cola = cola.getAnt();
                    cola.setSig(null);
                    aux.setAnt(null);
                }else{
                    aux.getAnt().setSig(aux.getSig());
                    aux.getSig().setAnt(aux.getAnt());
                    aux.setAnt(null);
                    aux.setSig(null);
                }
            }
            size--;
        }else{
            encontro = false;
        }
        return encontro;
    }
    
    private Nodo<T> seek(T t){
        Nodo<T> encontro = cabeza;
        while(encontro!=null && !encontro.getDato().equals(t)){
            encontro = encontro.getSig();
        }
        return encontro;
    } 
    
    
    public T set(int index, T t){
        aux = cabeza;
        if(index>size || index<1 ){
            return null;
        }else{
            for(int i=1;i<index;i++){
                aux = aux.getSig();
            }
            aux.setDato(t);
            return aux.getDato();
        }
    }
    
    public T contain(int index){
       aux = cabeza;
        if (index > 0 && index <= size) {
            for (int i = 1; i < index; i++) {
                aux = aux.getSig();
            }
            return aux.getDato();
        }
        return null;
    }
    
    public boolean contain(T t){
        return seek(t)!=null;
    }
}

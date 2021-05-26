package resources;


public class Nodo<T> {
    private T dato;
    private Nodo<T> sig;
    private Nodo<T> ant;
    
    public Nodo(T dato){
        this.dato=dato;
        this.sig = null;
        this.ant = null;
    }
    
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSig() {
        return sig;
    }

    public void setSig(Nodo<T> sig) {
        this.sig = sig;
    }

    public Nodo<T> getAnt() {
        return ant;
    }

    public void setAnt(Nodo<T> ant) {
        this.ant = ant;
    }
    
}
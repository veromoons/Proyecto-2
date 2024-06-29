
package Clases;

/**
 *Clase para 
 *.
 * @author sofiagrateron
 */
public class Nodo {
    private String palabra;
    private Nodo next;
    /**
     * Constructor
     * @param r 
     */
    public Nodo(String r) {
        this.palabra = r;
        this.next = null;
    }

    /** Metodo para obtener la informacion del nodo
     * @return 
     */
    public String getInfo() {
        return palabra;
    }

    /**
     * Metodo para establecer la informacion de un nodo
     * @param info the info to set
     */
    public void setInfo(String palabra) {
        this.palabra = palabra;
    }

    /**
     * Metodo para obtener el nodo siguiente al actual
     * @return the next
     */
    public Nodo getNext() {
        return next;
    }

    /**
     * Metodo para establecer el nodo siguiente al actual
     * @param next the next to set
     */
    public void setNext(Nodo next) {
        this.next = next;
    }
    
}
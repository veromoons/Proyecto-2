
package Clases;

/**
 *Clase para implementar setters y getters del nodo que va a contener la lista de la clase Lista, estos van a ser los nodos que guarda la hashtable en sus indices o index
 * Esto es por si acaso hay colisiones, que se cree la lista de una vez.
 * @author veronicaluna
 */
public class Nodo {
    private Resumen resumen;
    private Nodo next;
    /**
     * Constructor
     * @param r 
     */
    public Nodo(Resumen r) {
        this.resumen = r;
        this.next = null;
    }

    /** Metodo para obtener la informacion del nodo
     * @return the info, el objeto resumen contenido en el nodo
     */
    public Resumen getInfo() {
        return resumen;
    }

    /**
     * Metodo para establecer la informacion de un nodo, el objeto resumen
     * @param info the info to set
     */
    public void setInfo(Resumen resumen) {
        this.resumen = resumen;
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
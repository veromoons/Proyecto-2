
package Clases;

/**
 *Clase para implementar setters y getters del nodo que va a contener la lista de la clase Lista, estos van a ser los nodos que guarda la hashtable en sus indices o index
 * Esto es por si acaso hay colisiones, que se cree la lista de una vez.
 * @author veronicaluna
 */
public class NodoStr {
    private String palabra;
    private NodoStr next;
    /**
     * Constructor
     * @param r 
     */
    public NodoStr(String p) {
        this.palabra = p;
        this.next = null;
    }

    /** Metodo para obtener la informacion del nodo
     * @return the info, el objeto resumen contenido en el nodo
     */
    public String getInfo() {
        return palabra;
    }

    /**
     * Metodo para establecer la informacion de un nodo, el objeto resumen
     * @param info the info to set
     */
    public void setInfo(String palabra) {
        this.palabra = palabra;
    }

    /**
     * Metodo para obtener el nodo siguiente al actual
     * @return the next
     */
    public NodoStr getNext() {
        return next;
    }

    /**
     * Metodo para establecer el nodo siguiente al actual
     * @param next the next to set
     */
    public void setNext(NodoStr next) {
        this.next = next;
    }
    
}
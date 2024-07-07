/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author verol
 */
public class NodoInt {
    
    private int i;
    private NodoInt next;
    /**
     * Constructor
     * @param r 
     */
    public NodoInt(int n) {
        this.i = n;
        this.next = null;
    }

    /** Metodo para obtener la informacion del nodo
     * @return 
     */
    public int getInfo() {
        return i;
    }

    /**
     * Metodo para establecer la informacion de un nodo
     * @param info the info to set
     */
    public void setInfo(int n) {
        this.i = n;
    }

    /**
     * Metodo para obtener el nodo siguiente al actual
     * @return the next
     */
    public NodoInt getNext() {
        return next;
    }

    /**
     * Metodo para establecer el nodo siguiente al actual
     * @param next the next to set
     */
    public void setNext(NodoInt next) {
        this.next = next;
    }
    

}

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
public class ListaInt {

    //Atributos
    private NodoInt first;
    private int iN;

    //Constructor
    public ListaInt() {             
        this.first = null;
        this.iN = 0;
    }

    /**
     * Metodo para revisar si la lista es vacia
     * @return verdadero si es vacia, falso si no lo es 
     */
    public boolean esVacia(){
        if (first == null){
            return true;
        }else{
            return false;
        }
    }
    
    /**
    * Procedimiento para preinsertar un nuevo nodo antes del primer nodo de una lista, es necesario entonces reubicar el apuntafor first de la lista al nuevo nodo anadido
    */
    public void preinsertarPrimero(int i){ 
        NodoInt nuevo = new NodoInt(i);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    
    /**
     * Metodo para buscar el ultimo elemento de la lista
     * @return 
     */
    public NodoInt buscarUltimo(){

        NodoInt aux = first;
        if (first== null){
            return null;
        }
        while(aux.getNext()!= null){
                aux=aux.getNext();
        }
        return aux;
    }

    /**
     * 
     * @param i
     * @return 
     */
    public NodoInt getPosicion(int i){
        int contador =0;
        NodoInt pAux = first;
        while (contador !=i){
            pAux=pAux.getNext();
            contador++;
        }
        return pAux;
    }
    
    /**
     * Metodo para insertar al final de la lista
     * @param palabra a insertar
     */
    public void insertarUltimo(int i){  
        
        NodoInt ult=buscarUltimo();                    
        NodoInt nuevo = new NodoInt(i); 
        if(ult == null){
           first = nuevo;
        }else{
            ult.setNext(nuevo);
        }
        iN++;   
    }
    
        /**
     * Metodo para guardar los elementos de la lista en un string
     * @return 
     */
    public String recorrer(){
        String imprimir = "";
        if (this.iN == 1){
            imprimir += getFirst().getInfo() + ", ";
        }
        else{
            NodoInt temp = getFirst();
            while (temp != null){
                imprimir += temp.getInfo() + ",";
                temp = temp.getNext();
            }
        }
        return imprimir;
    }
    
    public boolean buscar(Lista lista, String aBuscar){
        boolean encontrado = false;
        if (!lista.esVacia()){
            Nodo temp = lista.getFirst();
            while (temp != null){
                if(temp.getInfo().trim().equals(aBuscar.trim())){
                    encontrado = true;
                }
                temp = temp.getNext();
            }
        }
        return encontrado;
    }
    
    /**
     * Metodo para obtener el pimer elemento de la lista
     * @return the first
     */
    public NodoInt getFirst() {
        return first;
    }

    /**Metodo para fijar el primer elemento de la lista
     * @param first the first to set
     */
    public void setFirst(NodoInt first) {
        this.first = first;
    }

    /**
     * Metodo para obtener el tamaño de la lista
     * @return the iN, entero tamaño de la lista
     */
    public int getiN() {
        return iN;
    }

    /**
     * Metodo para fijar el tamaño de la lista
     * @param iN the iN to set
     */
    public void setiN(int iN) {
        this.iN = iN;
    }

 


}

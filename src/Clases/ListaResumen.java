
package Clases;

/**
 * Clase para implementar primitivas de una lista simplemente enlazada, en caso de que hayan colisiones en la hashtable
 * @author veronicaluna
 */

public class ListaResumen {
    
    //Atributos
    private NodoResumen first;
    private int iN;

    //Constructor
    public ListaResumen() {             
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
    public void preinsertarPrimero(Resumen resumen){ 
        NodoResumen nuevo = new NodoResumen(resumen);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    
    /**
     * Metodo para buscar el ultimo elemento de la lista
     * @return 
     */
    public NodoResumen buscarUltimo(){

        NodoResumen aux = first;
        if (first== null){
            return null;
        }
        while(aux.getNext()!= null){
                aux=aux.getNext();
        }
        return aux;
    }
    
    /**
     * Metodo para insertar al final de la lista
     * @param palabra a insertar
     */
    public void insertarUltimo(Resumen resumen){  
        
        NodoResumen ult=buscarUltimo();                    
        NodoResumen nuevo = new NodoResumen(resumen); 
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
    public String recorrerResumenes(){
        String imprimir = "";
        if (this.iN == 1){
            imprimir += getFirst().getInfo().getInfoResumen() + "\n";
        }
        else{
            NodoResumen temp = getFirst();
            //int contador=0;
            while (temp != null){
                imprimir += temp.getInfo().getInfoResumen() + "\n";
                //contador++;
                //System.out.println(contador);
                temp = temp.getNext();
            }
        }
        return imprimir;
    }
    
    
    
    /**
     * Metodo para obtener el pimer elemento de la lista
     * @return the first
     */
    public NodoResumen getFirst() {
        return first;
    }

    /**Metodo para fijar el primer elemento de la lista
     * @param first the first to set
     */
    public void setFirst(NodoResumen first) {
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
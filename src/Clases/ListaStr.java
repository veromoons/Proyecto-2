
package Clases;

/**
 * Clase para implementar primitivas de una lista simplemente enlazada, en caso de que hayan colisiones en la hashtable
 * @author veronicaluna
 */

public class ListaStr {
    
    //Atributos
    private NodoStr first;
    private int iN;

    //Constructor
    public ListaStr() {             
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
    public void preinsertarPrimero(String palabraClave){ 
        NodoStr nuevo = new NodoStr(palabraClave);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    
    /**
     * Metodo para buscar el ultimo elemento de la lista
     * @return 
     */
    public NodoStr buscarUltimo(){

        NodoStr aux = first;
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
    public void insertarUltimo(String palabra){  
        
        NodoStr ult=buscarUltimo();                    
        NodoStr nuevo = new NodoStr(palabra); 
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
    public String imprimir_lista(){
        String imprimir = "";
        if (this.iN == 1){
            imprimir += getFirst().getInfo() + "\n";
        }
        else{
            NodoStr temp = getFirst();
            while (temp != null){
            imprimir += temp.getInfo() + "\n";
            temp = temp.getNext();
            }
    }
        return imprimir;
    }
    
    
    /**
     * Metodo para obtener el pimer elemento de la lista
     * @return the first
     */
    public NodoStr getFirst() {
        return first;
    }

    /**Metodo para fijar el primer elemento de la lista
     * @param first the first to set
     */
    public void setFirst(NodoStr first) {
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

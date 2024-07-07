
package Clases;

/**
 * Clase para implementar primitivas de una lista simplemente enlazada
<<<<<<< HEAD
 * @author veronicaluna, ruthsenior
=======
 * @author veronicaluna
>>>>>>> 1054f4d0b1c5371602479bc670408fda0429a87f
 */

public class Lista {
    
    //Atributos
    private Nodo first;
    private int iN;

    //Constructor
    public Lista() {             
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
    public void preinsertarPrimero(String palabra){ 
        Nodo nuevo = new Nodo(palabra);                 
        nuevo.setNext(first);               
        first=nuevo;
        iN++;
    }
    
    /**
     * Metodo para buscar el ultimo elemento de la lista
     * @return 
     */
    public Nodo buscarUltimo(){

        Nodo aux = first;
        if (first== null){
            return null;
        }
        while(aux.getNext()!= null){
                aux=aux.getNext();
        }
        return aux;
    }
    
    public Nodo getPosicion(int i){
        int contador =0;
        Nodo pAux = first;
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
    public void insertarUltimo(String palabra){  
        
        Nodo ult=buscarUltimo();                    
        Nodo nuevo = new Nodo(palabra); 
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
            Nodo temp = getFirst();
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
    public Nodo getFirst() {
        return first;
    }

    /**Metodo para fijar el primer elemento de la lista
     * @param first the first to set
     */
    public void setFirst(Nodo first) {
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

    public String[] toArray() {
        String [] array = new String[iN];
        Nodo temp = first;
        int i = 0;
        while(temp != null) {
            array[i] = temp.getInfo();
            temp = temp.getNext();
            i++;
        }
        return array;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}


package Clases;

/**
 *Clase en donde se desarrolla la creacion de la hashtable, sus metodos (insertar, buscar y eliminar) y la funcion hash (necesaria para lo anterior)
 * @author veronicaluna
 */
public class Hashtable {
    
    // Atributos
    int tam;
    Nodo[] ArrayHash;

    // Constructor
    public Hashtable(int t) {
        this.tam = t;
        this.ArrayHash = new Nodo[tam];
        for (int i=0; i<ArrayHash.length; i++){
            ArrayHash[i]=null;
        }
    }
    
    private int funcionHash(String key) {  //no public para que solo lo usen metodos de esta clase (que son los unicos que deben usarla)
        
        int constante = 37;  //num primo que se usa con frecuencia y da buena dispersion en datos
        int suma= 0;
        for (int i=0; i<key.length(); i++){
            char ch = key.charAt(i);
            int ascii = (int) ch;
            suma += ascii+(suma*constante);
        }
        
        int indiceEnArray = suma % tam;
        
        return indiceEnArray;
    }
    
    public void insertarPorTitulo(Resumen resumen){ //insercion en lista se hace de primero para mantener O(1)
       
        int indice = funcionHash(resumen.getTitulo());
        Nodo nodoNuevo = new Nodo(resumen);
        nodoNuevo.setNext(ArrayHash[indice]); 
        ArrayHash[indice]=nodoNuevo;
    }
    
    public Nodo buscarPorTitulo(String tituloBuscado){
        
        int indice = funcionHash(tituloBuscado);
        Nodo pAux= null;
        
        if (ArrayHash[indice]!=null){
            pAux = ArrayHash[indice];
            while (pAux.getNext()!=null && pAux.getInfo().getTitulo()!=tituloBuscado){
                pAux=pAux.getNext();
                if (pAux.getInfo().getTitulo()!=tituloBuscado){  //si ya esta en el ultimo nodo de la lista del indice que corresponde o corresponderia al titulo, entonces asignarle null a pAux
                    pAux=null;
                }
            }   
        }
        return pAux;
    }
    
    public void insertarPorPalabraClave(Resumen resumen){
        NodoStr pAux= resumen.getPalabrasClave().getFirst();
        while (pAux!=null){
            
            pAux=pAux.getNext();
        }
        
        
        
    }
    
    
    
    
    
}

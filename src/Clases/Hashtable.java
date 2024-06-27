
package Clases;

/**
 *Clase en donde se desarrolla la creacion de la hashtable, sus metodos (insertar, buscar y eliminar) y la funcion hash (necesaria para lo anterior)
 * @author veronicaluna
 */
public class Hashtable {
    
    // Atributos
    int tam;
    NodoResumen[] ArrayHash;

    // Constructor
    public Hashtable(int t) {
        this.tam = t;
        this.ArrayHash = new NodoResumen[tam];
        for (int i=0; i<ArrayHash.length; i++){
            ArrayHash[i]=null;
        }
    }
    
    private int funcionHash(String key) {  //no public para que solo lo usen metodos de esta clase (que son los unicos que deben usarla)
        
        int constante = 37;  //num primo que se usa con frecuencia y da buena dispersion en datos
        int suma=0;
        for (int i=0; i<key.length(); i++){
            char ch = key.charAt(i);
            int ascii = (int) ch;
            suma += ascii+(suma*constante);
        }
        
        int indiceEnArray = suma % tam;
        
        return indiceEnArray;
    }
    
    public void insertar(Resumen resumen){ //insercion en lista se hace de primero para mantener O(1)
        int indice=funcionHash(resumen.getTitulo());
        NodoResumen nodoNuevo = new NodoResumen(resumen);
        nodoNuevo.setNext(ArrayHash[indice]); 
        ArrayHash[indice]=nodoNuevo;
    }
    
   
    
    
}

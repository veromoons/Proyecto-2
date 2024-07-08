
package Clases;

/**
 *Clase en donde se desarrolla la creacion de la hashtable, sus metodos (insertar, buscar y eliminar) y la funcion hash (necesaria para lo anterior)
 * @author veronicaluna, ruthsenior
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
    /**
     * Funcion
     * @param key
     * @return 
     */
    private int funcionHash(String key) {  //no public para que solo lo usen metodos de esta clase (que son los unicos que deben usarla)
        
        int constante = 37;  //num primo que se usa con frecuencia y da buena dispersion en datos
        int suma= 0;
        for (int i=0; i<key.length(); i++){
            char ch = key.charAt(i);
            int ascii = (int) ch;
            suma += ascii+(suma*constante);
        }
        
        int indiceEnArray = Math.abs(suma % tam);
        
        return indiceEnArray;
    }
    /**
     * Funcion para insertar resumenes por titulo en el hashtable
     * @param resumen 
     */
    public void insertarPorTitulo(Resumen resumen){ //insercion en lista se hace de primero para mantener O(1)
        int indice = funcionHash(resumen.getTitulo());  
        NodoResumen nodoNuevo = new NodoResumen(resumen);
        nodoNuevo.setNext(ArrayHash[indice]); 
        ArrayHash[indice]=nodoNuevo;
     
    }
    /**
     * Funcion para buscar resumenes por titulo almacenados en un hashtable
     * @param tituloBuscado
     * @return lista de resumenes encontrados
     */
    public ListaResumen buscarPorTitulo(String tituloBuscado){ //retorna lista vacia si no hay resumenes con el titulo buscado
        int indice = funcionHash(tituloBuscado);

        NodoResumen pAux= null;  
        ListaResumen resumConIgualTituloEncontr= new ListaResumen();
        
        if (ArrayHash[indice]!=null){
            pAux = ArrayHash[indice];
            while (pAux!=null){
                if (pAux.getInfo().getTitulo().equals(tituloBuscado)){
                    resumConIgualTituloEncontr.preinsertarPrimero(pAux.getInfo());
                }
                pAux=pAux.getNext();
                }
            }
        return resumConIgualTituloEncontr;
    }

    /**
     * Funcion para insertar resumenes por palabra clave en el hashtable
     * @param resumen 
     */
    public void insertarPorPalabraClave(Resumen resumen){
        Nodo pAux= resumen.getPalabrasClave().getFirst();
        //System.out.println(pAux.getInfo());
        while (pAux!=null){
            int indice = funcionHash(pAux.getInfo());
            NodoResumen nodoNuevo = new NodoResumen(resumen);
            nodoNuevo.setNext(ArrayHash[indice]); 
            ArrayHash[indice]=nodoNuevo;
            pAux=pAux.getNext();
        }
    }
    /**
     * Funcion para buscar resumenes por palabra clave almacenados en un hashtable
     * @param palabraClave
     * @return lista de resumenes encontrados
     */
    public ListaResumen buscarPorPalabraClave(String palabraClave){  
        int indice = funcionHash(palabraClave);
        NodoResumen pAux = null;
        ListaResumen resumenesEncontrados = new ListaResumen();
        
        if (ArrayHash[indice]!=null){
            pAux= ArrayHash[indice];
            while (pAux!=null){
                resumenesEncontrados.preinsertarPrimero(pAux.getInfo());
                pAux=pAux.getNext();
            }
        }
        return resumenesEncontrados;         
    }
    /**
     * Funcion para insertar por autor en el hashtable
     * @param resumen 
     */
    public void insertarPorAutor(Resumen resumen){
        Nodo pAux= resumen.getAutores().getFirst();
        while (pAux!=null){
            int indice = funcionHash(pAux.getInfo());
            NodoResumen nodoNuevo = new NodoResumen(resumen);
            nodoNuevo.setNext(ArrayHash[indice]); 
            ArrayHash[indice]=nodoNuevo;
            pAux=pAux.getNext();
        }
    }
    /**
     * Funcion para buscar resumenes por autor en el hashtable
     * @param autor
     * @return lista de resumenes encontrados
     */
    public ListaResumen buscarPorAutor(String autor){  
        int indice = funcionHash(autor);
        NodoResumen pAux = null;
        ListaResumen resumenesEncontrados = new ListaResumen();
        
        if (ArrayHash[indice]!=null){
            pAux= ArrayHash[indice];
            while (pAux!=null){
                resumenesEncontrados.preinsertarPrimero(pAux.getInfo());
                pAux=pAux.getNext();
            }
        }
       return resumenesEncontrados;         
    }

    
   
    

}

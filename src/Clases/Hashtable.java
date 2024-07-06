
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
    
    public void insertarPorTitulo(Resumen resumen){ //insercion en lista se hace de primero para mantener O(1)
        int indice = funcionHash(resumen.getTitulo());  //PROBAR CON DOS RESUMENES CON MISMO TITULO
        NodoResumen nodoNuevo = new NodoResumen(resumen);
        nodoNuevo.setNext(ArrayHash[indice]); 
        ArrayHash[indice]=nodoNuevo;
     
    }
    
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
//            while (pAux.getNext()!=null && pAux.getInfo().getTitulo()!=tituloBuscado){
//                pAux=pAux.getNext();
//                if (pAux.getInfo().getTitulo()!=tituloBuscado){  //si ya esta en el ultimo nodo de la lista del indice que corresponde o corresponderia al titulo, entonces asignarle null a pAux
//                    pAux=null;
//                }
//            }   
    
    public void insertarPorPalabraClave(Resumen resumen){
        Nodo pAux= resumen.getPalabrasClave().getFirst();
        System.out.println(pAux.getInfo());
        while (pAux!=null){
            int indice = funcionHash(pAux.getInfo());
            NodoResumen nodoNuevo = new NodoResumen(resumen);
            nodoNuevo.setNext(ArrayHash[indice]); 
            ArrayHash[indice]=nodoNuevo;
            pAux=pAux.getNext();
        }
    }
    
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

    public NodoResumen getNodo(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    

}

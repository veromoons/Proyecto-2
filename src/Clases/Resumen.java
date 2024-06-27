
package Clases;

/**
 *Clase para guardar cada documento (resumen) que se lea y se obtenga de un txt como un objeto de la clase Resumen
 * @author veronicaluna
 */
public class Resumen {
    
    //Atributos
    private String titulo;
    private ListaStr autores;
    private String cuerpo;
    private ListaStr palabrasClave;
    
    //Constructor
    public Resumen(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.autores = new ListaStr();
        this.cuerpo = cuerpo;
        this.palabrasClave = new ListaStr();
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the cuerpo
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * @param cuerpo the cuerpo to set
     */
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    /**
     * @return the autores
     */
    public ListaStr getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(ListaStr autores) {
        this.autores = autores;
    }

    /**
     * @return the palabrasClave
     */
    public ListaStr getPalabrasClave() {
        return palabrasClave;
    }

    /**
     * @param palabrasClave the palabrasClave to set
     */
    public void setPalabrasClave(ListaStr palabrasClave) {
        this.palabrasClave = palabrasClave;
    }
    
    
    
}

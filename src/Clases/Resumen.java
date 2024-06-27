
package Clases;

/**
 *Clase para guardar cada documento (resumen) que se lea y se obtenga de un txt como un objeto de la clase Resumen
 * @author veronicaluna
 */
public class Resumen {
    
    //Atributos
    private String titulo;
    private Lista autores;
    private String cuerpo;
    private Lista palabrasClave;
    
    //Constructor
    public Resumen(String titulo, String cuerpo, Lista autores, Lista palabrasClave) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autores = autores;
        this.palabrasClave = palabrasClave;
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

    public Lista getAutores() {
        return autores;
    }

    public Lista getPalabrasClave() {
        return palabrasClave;
    }

    public void setAutores(Lista autores) {
        this.autores = autores;
    }

    public void setPalabrasClave(Lista palabrasClave) {
        this.palabrasClave = palabrasClave;
    }
    
    
    
}


package Clases;

/**
 *Clase para guardar cada documento (resumen) que se lea y se obtenga de un txt como un objeto de la clase Resumen
 * @author veronicaluna
 */
public class Resumen {
    
    //Atributos
    private String titulo;
    //Lista autores;
    private String cuerpo;
    //Lista palabrasClave;
    
    //Constructor
    public Resumen(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
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
    
    
    
}

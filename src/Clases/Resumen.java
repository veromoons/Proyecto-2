
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
    public Resumen(String titulo, Lista autores, String cuerpo, Lista palabrasClave) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autores = autores;
        this.palabrasClave = palabrasClave;
    }
    /**
     * Funcion para obtener la informacion de un resumen en un string ordenado
     * @return string, con toda la informacion del resumen
     */
    public String getInfoResumen(){
        return "Titulo: " + this.titulo + "\n" + "Autores: "+ this.autores.recorrer() +"\n" + "Palabras clave: " + this.palabrasClave.recorrer();
    }
    /**
     * Funcion para escribir los datos de un resumen cargados en memoria en un string
     * @return string, resumen
     */
    public String mostrarResumen(){
        String resumenCargar = "";
        resumenCargar += titulo+"\n";
        resumenCargar += "AUTORES \n" + autores.recorrer() + "\n";
        resumenCargar += "RESUMEN \n" + cuerpo + "\n";
        resumenCargar += "PALABRAS CLAVES: \n" + palabrasClave.recorrer();
        return resumenCargar;
    }
    
    /**
     * Funcion para obtener el titulo del resumen
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Funcion para asignar el titulo de un resumen
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Funcion para obtener el cuerpo del resumen
     * @return the cuerpo
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * Funcion para asignar el cuerpo de un resumen
     * @param cuerpo the cuerpo to set
     */
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    /**
     * Funcion para obtener los autores del resumen
     * @return 
     */
    public Lista getAutores() {
        return autores;
    }
    /**
     * Funcion para obtener las palabras clave del resumen
     * @return 
     */
    public Lista getPalabrasClave() {
        return palabrasClave;
    }
    /**
     * Funcion para asignar los autores de un resumen
     * @param autores 
     */
    public void setAutores(Lista autores) {
        this.autores = autores;
    }
    /**
     * Funcion para asignar las palabras clave de un resumen
     * @param palabrasClave 
     */
    public void setPalabrasClave(Lista palabrasClave) {
        this.palabrasClave = palabrasClave;
    }
    
    
    
}

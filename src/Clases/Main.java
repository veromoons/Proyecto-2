/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Ventana1;
import Interfaces.VentanaPrueba;

/**
 *
 * @author veronicaluna
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Ventana1 v1 = new Ventana1();
//        v1.setVisible(true);
        
        VentanaPrueba vp = new VentanaPrueba();
        vp.setVisible(true);
        

        Lista palabrasClave1 = new Lista();
        palabrasClave1.preinsertarPrimero("vetiver");
        palabrasClave1.preinsertarPrimero("magia");

        Lista autores1 = new Lista();
        autores1.preinsertarPrimero("Veronica Luna");
        autores1.preinsertarPrimero("Julia Gomez");

        Resumen resumen1 = new Resumen("Vetiver: planta magica", autores1, "El vetiver es una planta maravillosa.", palabrasClave1);

        
        Lista palabrasClave2 = new Lista();
        palabrasClave2.preinsertarPrimero("ia");
        palabrasClave2.preinsertarPrimero("artificial");
        palabrasClave2.preinsertarPrimero("magia");

        Lista autores2 = new Lista();
        autores2.preinsertarPrimero("Julia Gomez");

        Resumen resumen2 = new Resumen("Influencia de la inteligencia artificial (IA) en los jovenes profesionales.", autores2, "La ayuda de la inteligencia artificial hace que no pensemos por nuestra cuenta.", palabrasClave2);
        
        Lista palabrasClave3 = new Lista();
        palabrasClave3.preinsertarPrimero("lol");
        
        Lista autores3 = new Lista();
        autores3.preinsertarPrimero("Juan Torres");
        
        Resumen resumen3 = new Resumen("Vetiver: planta magica", autores3, "AAAA", palabrasClave3);
        
        Hashtable hashTitulos = new Hashtable(5000);
        hashTitulos.insertarPorTitulo(resumen1);
        hashTitulos.insertarPorTitulo(resumen2);
        hashTitulos.insertarPorTitulo(resumen3);
        
        Hashtable hashPalabrasClave = new Hashtable(5000);
        hashPalabrasClave.insertarPorPalabraClave(resumen1);
        hashPalabrasClave.insertarPorPalabraClave(resumen2);

        Hashtable hashAutores = new Hashtable(5000);
        hashAutores.insertarPorAutor(resumen1);
        hashAutores.insertarPorAutor(resumen2);
                
//        System.out.println(hashTitulos.buscarPorTitulo("Vetiver: planta magica").recorrerResumenes());
//        System.out.println(hashAutores.buscarPorAutor("Julia Gomez").recorrerResumenes());
//        System.out.println(hashPalabrasClave.buscarPorPalabraClave("magia").recorrerResumenes());
        
    }
    
}

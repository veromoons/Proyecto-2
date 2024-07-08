/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Info;

import Clases.Hashtable;
import Clases.Lista;
import Clases.Resumen;
import Clases.ListaResumen;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import Clases.NodoResumen;

/**
 * 
 * @author sofiagrateron, ruthsenior
 */
public class LeerTxt {
    public static Hashtable hashTitulos;
    public static Hashtable hashPalabrasClave;
    public static Hashtable hashAutores;
    private Resumen resumen;
    private Lista cuerpos;
    public static ListaResumen listaDeResumenes;

    //Constructor
    public LeerTxt() {
        this.hashTitulos = new Hashtable(10000);
        this.hashPalabrasClave = new Hashtable(10000);
        this.hashAutores = new Hashtable(10000);
        this.resumen = null;
        this.cuerpos = new Lista();
        this.listaDeResumenes=new ListaResumen();
    }


    /**
     * Funcion que busca la siguiente linea no vacia en un txt
     * @param lineInput
     * @param br
     * @return string, linea
     * @throws IOException 
     */
    public String findNextNotEmpty(String lineInput, BufferedReader br) throws IOException {
        String line=lineInput;
        while (line.length() ==0 ){
            line = br.readLine();
        }
        return line;
    }
    
    /**
     * Funcion para cargar la informacion de un resumen nuevo al txt
     * @param abre, documento escogido en el JFileChooser por el usuario
     * @return booleano true, si fue guardada la informacion
     * @throws IOException 
     */
    public boolean cargarInfo(File abre) throws IOException {
    boolean guardado = false;
    String line;
    String titulo = "";
    StringBuilder cuerpo = new StringBuilder();
    StringBuilder palabras = new StringBuilder();
    Lista autores = new Lista();
    Lista palabrasClave = new Lista();
    
    

    if (abre != null) {
        try (FileReader fr = new FileReader(abre);
                
             BufferedReader br = new BufferedReader(fr)) {
            
            line = br.readLine();

            if (line != null ) {
                if (line.length()==0){
                    
                    line = findNextNotEmpty(line, br);
                }
                titulo = line.trim();
                


                                line = br.readLine();

                line = findNextNotEmpty(line, br); 
                
                while (line != null && !line.trim().equalsIgnoreCase("resumen")) {

                    if (!line.trim().equalsIgnoreCase("Autores") && !line.trim().isEmpty()) {
                        autores.preinsertarPrimero(line.trim());  //preinsertarprimero
                    }
                    
                    line = br.readLine();
                }

                // Leer resumen
                
                while (line != null && !line.trim().isEmpty() && !line.trim().split(":")[0].equalsIgnoreCase("Palabras Claves")) {
                    if (!line.trim().equalsIgnoreCase("resumen") && !line.trim().isEmpty()) {
                        cuerpo.append(line.trim()).append(" ");
                    }
                    line = br.readLine();
                }
                
                // Saltar líneas en blanco hasta encontrar "Palabras Claves:"
                while (line != null && line.trim().isEmpty()) {
                    line = br.readLine();
                }

                // Leer palabras clave

                if (line != null && line.trim().split(":")[0].equalsIgnoreCase("Palabras Claves")) {
                    palabras.append(line.trim());
                    String[] palabrasSplit = palabras.toString().split(",\\s*|\\sy\\s|:\\s*|\\.\\s*");
                    for (int i = 1; i < palabrasSplit.length; i++) {
                        palabrasClave.preinsertarPrimero(palabrasSplit[i].trim());   //preinsertarprimero
                    }
                }
            }

            if (!this.revisarRepetido(cuerpo.toString())){
             this.cuerpos.insertarUltimo(cuerpo.toString());

                Resumen resumen = new Resumen(titulo, autores, cuerpo.toString().trim(), palabrasClave);
                
                this.setResumen(resumen);
                this.cargarResumentxt(resumen);
                guardado = true;
            
                }
            
            else{
                guardado = false;
            }
            }
         catch (FileNotFoundException e) {
//            e.printStackTrace();
            guardado = false;
        } catch (IOException e) {
//            e.printStackTrace();
            guardado = false;
        }
        
    }
    return guardado;
    }
    

    /**
     * Funcion para cargar la informacion del resumen escogido por el usuario en el TXT de todos los resumenes guardados en el programa
     * @param resumen 
     */
    public boolean cargarResumentxt(Resumen resumen){
        boolean guardado = false;
       String resumenCargar;
       resumenCargar = resumen.mostrarResumen() + "\n%\n";
        try{
            File archivo = new File("resumenes.txt");
            if (!archivo.exists()){
                archivo.createNewFile();
            }
            PrintWriter pw = new PrintWriter(new FileWriter(archivo, true));
            pw.print(resumenCargar);
            pw.close();
            guardado = true;
            
        }
        catch (Exception err){
            JOptionPane.showMessageDialog(null, "ERROR" + err.getMessage());
        }
        return guardado;
    }
    
   /**
    * Funcion para leer los resumenes guardados en el TXT y guardar su informacion en el programa
    * @param abre, archivo txt
    * @return booleano true, si la informacion pudo ser leida
    * @throws IOException 
    */ 
   public boolean leerResumenesTxt(File abre) throws IOException {
    boolean guardado = false;
    if (abre != null) {
        try (FileReader fr = new FileReader(abre);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            StringBuilder texto = new StringBuilder();
            while ((line = br.readLine()) != null) {
                texto.append(line).append("\n");
            }
            if (!texto.toString().equals("") &&!texto.toString().equals("\n") ){
            int count = 0;
            //Separar los resumenes
            String[] resumenes = texto.toString().split("%");
            for (int i = 0; i < resumenes.length; i++) {
                String titulo = "";
            String cuerpo = "";
            Lista autores = new Lista();
            Lista palabrasClave = new Lista();
            //Separar cada resumen por salto de linea
            String[] resumenSeparado = resumenes[i].split("\n");
                for (int j = 0; j < resumenSeparado.length; j++) {
                //Leer titulo
               if(count == 0){
               titulo = resumenSeparado[0].trim();
               }
               else{
                   titulo = resumenSeparado[1].trim();
               }
               //Leer autores
                if (resumenSeparado[j].trim().equals("AUTORES")) {
                    String [] autoresSeparados = resumenSeparado[j+1].split(",");
                        for (int k = 0; k < autoresSeparados.length; k++) {

                            autores.preinsertarPrimero(autoresSeparados[k].trim());
                    }
                        }
                //Leer cuerpo  
                if (resumenSeparado[j].trim().equals("RESUMEN")) {
                     cuerpo = resumenSeparado[j + 1];
                    }
                //Leer palabras clave
                if (resumenSeparado[j].trim().equals("PALABRAS CLAVES:")) {
                    String [] palabrasSeparada = resumenSeparado[j+1].split(",");
                        for (int k = 0; k< palabrasSeparada.length; k++) {

                            palabrasClave.preinsertarPrimero(palabrasSeparada[k].trim());
                    }
                        }
                

                if (j == resumenSeparado.length -1){                    
                    Resumen resumenObj = new Resumen(titulo, autores, cuerpo, palabrasClave);
                    this.listaDeResumenes.insertarAlfabetico(resumenObj);
                    this.getHashTitulos().insertarPorTitulo(resumenObj);
                    this.getHashPalabrasClave().insertarPorPalabraClave(resumenObj);
                    this.getHashAutores().insertarPorAutor(resumenObj);
                    count++;
                    
                }
               
                
                }


            }
                
            
            if (count == resumenes.length-1){
                guardado = true;
            }
            }
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        }
    } 
    return guardado;
}

   /**
    * Funcion que guarda los cuerpos de los resumenes precargados en una lista
    * @param abre, documento de resumenes precargados
    * @throws IOException 
    */
   public void guardarCuerpos(File abre) throws IOException{
       boolean repetido= false;
       if (abre != null) {
        try (FileReader fr = new FileReader(abre);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            StringBuilder texto = new StringBuilder();
            while ((line = br.readLine()) != null) {
                texto.append(line).append("\n");
            }
            int count = 0;
            //Separar los resumenes
            String[] resumenes = texto.toString().split("%");
            
            for (int i = 0; i < resumenes.length; i++) {
            String cuerpo = "";
            
            //Separar cada resumen por salto de linea
            String[] resumenSeparado = resumenes[i].split("\n");
                for (int j = 0; j < resumenSeparado.length; j++) {
                    
                //Leer cuerpo  
                if (resumenSeparado[j].trim().equalsIgnoreCase("RESUMEN")) {
                     cuerpo = resumenSeparado[j + 1];
                     this.cuerpos.insertarUltimo(cuerpo);
                     
                    }
            
        
            }
                
        } 
            
            }catch (FileNotFoundException e) {
//            e.printStackTrace();
        }
           

   
   }
        
        
       }
   /**
    * Funcion que revisa si un resumen ingresado ya se encuentra en los precargados
    * @param cuerpo
    * @return booleano, verdadero si esta repetido
    */
   public boolean revisarRepetido(String cuerpo){
       boolean repetido = false;
       if (this.cuerpos.buscar(this.cuerpos, cuerpo)){
           repetido = true;
       }
       return repetido;
   }
   


   /**
    * Funcion que ordena los titulos de los resumenes
    * @param titulos 
    */
   private void ordenarTitulos(String[] titulos) {
       for (int i = 0; i< titulos.length -1; i++) {
           for (int j = 0; j< titulos.length -i-1; j++) {
               if (titulos[j].compareTo(titulos[j+1])>0) {
                   String temp = titulos[j];
                   titulos[j] = titulos[j+1];
                   titulos[j+1] = temp;
               }
           }
       }
   }

   /**
    * 
    * @param max
    * @return 
    */
   private int obtenerSeleccion(int max) {
       int seleccion = -1;
       do {
           try {
               String input = JOptionPane.showInputDialog("Seleccione el número del resumen que dessee analizar: ");
               if (input == null) {
                   return -1;
               }
               seleccion = Integer.parseInt(input);
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "ERROR. Seleccione un número válido: ");
           }
       } while (seleccion < 1 || seleccion> max);
       return seleccion;

   }   
   /**
    * Funcion que imprime la frecuencia con la que aparecen las palabras claves en un resumen
    * @param resumen 
    */
   private void imprimirEstadisticas(Resumen resumen) {
       System.out.println("Nombre del Trabajo: " + resumen.getTitulo());
       System.out.println("Autores: " + resumen.getAutores().recorrer());
       String cuerpo = resumen.getCuerpo();
       Lista palabrasClave = resumen.getPalabrasClave();
       int [] frecuencias = contarFrecuencias(cuerpo, palabrasClave);
       
       String[] palabras = palabrasClave.toArray();
       for (int i = 0; i< palabras.length; i++) {
           System.out.println(palabras[i] + ": " + frecuencias[i]);
       }
   }

   /**
    * Funcion que cuenta la frecuencia con la que aparecen las palabras clave en un resumen
    * @param texto
    * @param palabrasClave
    * @return 
    */
   private int [] contarFrecuencias(String texto, Lista palabrasClave) {
       String[] palabrasTexto = texto.split("\\W+");
       String[] palabras = palabrasClave.toArray();
       int [] frecuencias = new int[palabras.length];
       
       for (int i = 0; i< palabras.length; i++) {
           frecuencias [i] = 0;
           for (String palabraTexto: palabrasTexto) {
               if (palabraTexto.equalsIgnoreCase(palabras[i])) {
               frecuencias[i] ++;    
           }
          
         }
       }
       return frecuencias;
   }
   
   
   
   
   

    
    
    
   /**
    * Funcion para obtener el resumen
    * @return resumen
    */
    public Resumen getResumen() {
        return resumen;
    }
    /**
     * Funcion para asignar el resumen 
     * @param resumen 
     */
    public void setResumen(Resumen resumen) {
        this.resumen = resumen;
    }

    /** Funcion para obtener el hash table de los titulos
     * @return the hashTitulos
     */
    public static Hashtable getHashTitulos() {
        return hashTitulos;
    }

    /** Funcion para asignar el hash table de los titulos
     * @param aHashTitulos the hashTitulos to set
     */
    public static void setHashTitulos(Hashtable aHashTitulos) {
        hashTitulos = aHashTitulos;
    }

    /** Funcion para obtener el hash table de las palabras clave
     * @return the hashPalabrasClave
     */
    public static Hashtable getHashPalabrasClave() {
        return hashPalabrasClave;
    }

    /** Funcion para asignar el hash table de las palabras claves
     * @param aHashPalabrasClave the hashPalabrasClave to set
     */
    public static void setHashPalabrasClave(Hashtable aHashPalabrasClave) {
        hashPalabrasClave = aHashPalabrasClave;
    }

    /** Funcion para obtener el hash table de los autores
     * @return the hashAutores
     */
    public static Hashtable getHashAutores() {
        return hashAutores;
    }

    /**Funcion para asignar el hash table de los autores
     * @param aHashAutores the hashAutores to set
     */
    public static void setHashAutores(Hashtable aHashAutores) {
        hashAutores = aHashAutores;
    }
    




}
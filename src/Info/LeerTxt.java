/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Info;

import Clases.Hashtable;
import Clases.Lista;
import Clases.Resumen;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 * Clase para guardar y cargar informacion con documentos de texto en el programa
 * @author sofiagrateron
 */
public class LeerTxt {
    public static Hashtable hashTitulos;
    public static Hashtable hashPalabrasClave;
    public static Hashtable hashAutores;
    private Resumen resumen;
    private Lista cuerpos;

    
    public LeerTxt() {
        this.hashTitulos = new Hashtable(10000);
        this.hashPalabrasClave = new Hashtable(10000);
        this.hashAutores = new Hashtable(10000);
        this.resumen = null;
        this.cuerpos = new Lista();
    }


    public String findNextNotEmpty(BufferedReader br) throws IOException {
        String line = br.readLine();
        while (br.readLine().length() ==0 ){
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

            if ((line = br.readLine()) != null ) {
                if (line.length()==0){
                    
                    line = findNextNotEmpty(br);
                }
                titulo = line.trim();
                
                line = findNextNotEmpty(br);
                

                // Leer autores
                while (line != null && !line.trim().equalsIgnoreCase("resumen")) {
                    if (!line.trim().equalsIgnoreCase("autores") && !line.trim().isEmpty()) {
                        autores.preinsertarPrimero(line.trim());  //preinsertarprimero
                    }
                    System.out.println(line);
                    line = br.readLine();
                }

                // Leer resumen
                //System.out.println("line: "+line);
                while (line != null && !line.trim().isEmpty() && !line.trim().split(":")[0].equalsIgnoreCase("Palabras Claves")) {
                    if (!line.trim().equalsIgnoreCase("resumen") && !line.trim().isEmpty()) {
                        cuerpo.append(line.trim()).append(" ");
                    }
                    line = br.readLine();
                }
                //System.out.println("line: "+line);
                // Saltar líneas en blanco hasta encontrar "Palabras Claves:"
                while (line != null && line.trim().isEmpty()) {
                    line = br.readLine();
                }

                // Leer palabras clave
//                System.out.println("---line---");
//                System.out.println(line.trim().split(":")[0]);
//                System.out.println(line.trim().split(":")[0].equalsIgnoreCase("Palabras Claves"));

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
                //System.out.println(this.cuerpos.recorrer());
                Resumen resumen = new Resumen(titulo, autores, cuerpo.toString().trim(), palabrasClave);
                System.out.println(resumen.mostrarResumen());
                this.setResumen(resumen);
                this.cargarResumentxt(resumen);
                guardado = true;
                //this.getHashTitulos().insertarPorTitulo(resumen);
                //this.getHashPalabrasClave().insertarPorPalabraClave(resumen);
                //this.getHashAutores().insertarPorAutor(resumen);
                }
            
            else{
                guardado = false;
            }
            }
         catch (FileNotFoundException e) {
            e.printStackTrace();
            guardado = false;
        } catch (IOException e) {
            e.printStackTrace();
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
        //System.out.println("---resumen---");
       String resumenCargar;
       resumenCargar = resumen.mostrarResumen() + "\n%\n";
        //System.out.println(resumenCargar);
        try{
            File archivo = new File("resumenes.txt");
            if (!archivo.exists()){
                archivo.createNewFile();
            }
            PrintWriter pw = new PrintWriter(new FileWriter(archivo, true));
            pw.print(resumenCargar);
            pw.close();
            guardado = true;
            //JOptionPane.showMessageDialog(null, "Guardado exitoso en" + archivo.getAbsolutePath());
            
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
               titulo = resumenSeparado[0];}
               else{
                   titulo = resumenSeparado[1];
               }
               //Leer autores
                if (resumenSeparado[j].trim().equals("AUTORES")) {
                    String [] autoresSeparados = resumenSeparado[j+1].split(",");
                        for (int k = 0; k < autoresSeparados.length-1; k++) {
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
                        for (int k = 0; k< palabrasSeparada.length-1; k++) {
                            palabrasClave.preinsertarPrimero(palabrasSeparada[k].trim());
                    }
                        }
                
                if (j == resumenSeparado.length -1){
                    Resumen resumenObj = new Resumen(titulo, autores, cuerpo, palabrasClave);
                    //System.out.println("resumen" + i+ ":"+ resumenObj.mostrarResumen());
                    this.getHashTitulos().insertarPorTitulo(resumenObj);
                    //System.out.println(resumenObj.getPalabrasClave().recorrer());
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
            e.printStackTrace();
        }
    } 
    return guardado;
}
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
                //System.out.println("resumen" + i + ":  "+ resumenes[i]);
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
            e.printStackTrace();
        }
           
   
   }
        
        
       }
   public boolean revisarRepetido(String cuerpo){
       boolean repetido = false;
       //System.out.println(this.cuerpos.recorrer());
       if (this.cuerpos.buscar(this.cuerpos, cuerpo)){
           repetido = true;
       }
       return repetido;
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

    /**
     * @return the hashTitulos
     */
    public static Hashtable getHashTitulos() {
        return hashTitulos;
    }

    /**
     * @param aHashTitulos the hashTitulos to set
     */
    public static void setHashTitulos(Hashtable aHashTitulos) {
        hashTitulos = aHashTitulos;
    }

    /**
     * @return the hashPalabrasClave
     */
    public static Hashtable getHashPalabrasClave() {
        return hashPalabrasClave;
    }

    /**
     * @param aHashPalabrasClave the hashPalabrasClave to set
     */
    public static void setHashPalabrasClave(Hashtable aHashPalabrasClave) {
        hashPalabrasClave = aHashPalabrasClave;
    }

    /**
     * @return the hashAutores
     */
    public static Hashtable getHashAutores() {
        return hashAutores;
    }

    /**
     * @param aHashAutores the hashAutores to set
     */
    public static void setHashAutores(Hashtable aHashAutores) {
        hashAutores = aHashAutores;
    }
    




}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Info;

import Clases.Lista;
import Clases.Resumen;
import Clases.Hashtable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase para obtener la informacion de cada resumen
 * @author sofiagrateron
 */
public class LeerTxt {
    Hashtable tabla;
    
    public LeerTxt() {
        this.tabla = new Hashtable(10000);
    }
    
    public boolean cargarResumen(File abre) throws FileNotFoundException, IOException{
        boolean guardado = false;
        String line;
        String titulo = "";
        String cuerpo = "";
        String palabras = "";
        Lista autores = new Lista();
        Lista palabrasClave = new Lista();
        //Resumen resumen = new Resumen();
        if(abre!=null){
            try {
                FileReader fr = new FileReader(abre);
                BufferedReader br = new BufferedReader(fr);
                    
                while((line = br.readLine().toUpperCase()) != null){
                    line = line.trim();
                    titulo = line;
                    line = br.readLine();
                    if (line.isEmpty())continue;
                    else {
                        while (!line.toLowerCase().equals("resumen")){
                            if (!line.equalsIgnoreCase("autores") && !line.equalsIgnoreCase("")){
                                    autores.insertarUltimo(line);}
                            line = br.readLine();
                        }
                        while (!line.toLowerCase().equals("")){
                            if (!line.equalsIgnoreCase("resumen") && !line.equalsIgnoreCase("")){
                                cuerpo += line +" ";
                        }
                            line = br.readLine();
                        }
                        line = br.readLine();
                        palabras += line;
                        palabras = palabras.replace("Palabras Claves: ", " ");
                        palabras = palabras.replace(".", " ");
                        String [] palabrasSplit = palabras.split(",\\s*|\\sy\\s");
                        for (int i = 0; i < palabrasSplit.length; i++) {
                            //System.out.println(palabrasSplit[i]);
                            palabrasClave.insertarUltimo(palabrasSplit[i].trim());
                        }
                        
                            
                    }
                }
                     guardado = true;
                     Resumen resumen = new Resumen(titulo, cuerpo, autores, palabrasClave);
                     this.tabla.insertar(resumen);
                }
            
             catch(Exception err){
                    }
            System.out.println(titulo);
            System.out.println(autores.imprimir_lista());
            System.out.println(cuerpo);
            System.out.println(palabrasClave.imprimir_lista());
        }
          return guardado;  
    }
    public void guardarResumen(){
    
}
    
}

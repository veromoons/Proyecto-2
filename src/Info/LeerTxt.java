/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Info;

import Clases.Hashtable;
import Clases.Lista;
import Clases.Resumen;
import Clases.Hashtable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 * Clase para obtener la informacion de cada resumen
 * @author sofiagrateron
 */
public class LeerTxt {
    Hashtable tabla;
    Resumen resumen;

    public LeerTxt() {
        this.tabla = new Hashtable(10000);
        this.resumen = null;
    }
    
    public boolean cargarInfo(File abre) throws FileNotFoundException, IOException{
        boolean guardado = false;
        String line;
        String titulo = "";
        String cuerpo = "";
        String palabras = "";
        Lista autores = new Lista();
        Lista palabrasClave = new Lista();
        if(abre!=null){
            try {
                FileReader fr = new FileReader(abre);
                BufferedReader br = new BufferedReader(fr);
                    
                if((line = br.readLine().toUpperCase()) != null){
                    line = line.trim();
                    titulo = line;
                    line = br.readLine();
                    //if (line.isEmpty())continue;
                    //else {
                        while (!line.toLowerCase().equals("resumen")){
                    line= br.readLine();
                    //if (line.isEmpty()) continue;
                    //else {
                        while (!line.trim().equalsIgnoreCase("resumen")){
                            if (!line.equalsIgnoreCase("autores") && !line.equalsIgnoreCase("")){
                                    autores.insertarUltimo(line);}
                            line = br.readLine();
                        }
                        while (!line.trim().toLowerCase().equals("") && line.charAt(0)!='P'){
                            if (!line.equalsIgnoreCase("resumen") && !line.equalsIgnoreCase("")){
                                cuerpo += line +" ";
                        }
                            line = br.readLine();
                        }
                        while (line.equals("")){
                            line = br.readLine();
                        }
                        palabras += line;
                        String [] palabrasSplit = palabras.split(",\\s*|\\sy\\s|:\\s*|\\.\\s*");
                        for (int i = 1; i < palabrasSplit.length; i++) {
                            //System.out.println(palabrasSplit[i]);
                            palabrasClave.insertarUltimo(palabrasSplit[i].trim());
                        }
                        
                            
                    
                }
                
                guardado = true;
                
                  if (guardado){
            Resumen resumen =  new Resumen(titulo, cuerpo, autores, palabrasClave);
            this.tabla.insertar(resumen);
                  }
                     
                }
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
    
    public void cargarResumentxt(Resumen resumen){
       String resumenCargar;
       resumenCargar = "\n" + resumen.mostrarResumen() + "\n %";
        try{
            File archivo = new File("resumenes.txt");
            if (!archivo.exists()){
                archivo.createNewFile();
            }
            PrintWriter pw = new PrintWriter(new FileWriter(archivo, true));
            pw.print(resumenCargar);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitoso en" + archivo.getAbsolutePath());
            
        }
        catch (Exception err){
            JOptionPane.showMessageDialog(null, "ERROR" + err.getMessage());
        }
    }
    
    public boolean leerResumenesTxt(File abre) throws IOException{
       boolean guardado = false;
        if(abre!=null){
            try {
                String line;
                String texto = "";
                FileReader fr = new FileReader(abre);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    texto += line + "\n";
                }
                String[]resumenes= texto.split("%");
                for (int i = 0; i < resumenes.length; i++) {
                    //System.out.println(resumenes[i]);
                    String titulo = "";
                    String cuerpo = "";
                    String palabras = "";
                    Lista autores = new Lista();
                    Lista palabrasClave = new Lista();
                    String [] resumenSeparado = resumenes[i].split("\n");
                    titulo = resumenSeparado[1];
                    for (int j = 0; j < resumenSeparado.length; j++) {
                        //System.out.println(resumenSeparado[j]);
                        if (resumenSeparado[j].equals("AUTORES ")){
                            int z =j+1;
                            while(!resumenSeparado[z].equals("")){
                                //System.out.println(z);
                                autores.insertarUltimo(resumenSeparado[z]);
                                z++;
                            }
                            }
                        if (resumenSeparado[j].trim().equals("RESUMEN")){
                            //System.out.println(resumenSeparado[j+1]);
                            cuerpo += resumenSeparado[j+1];
                        }
                        if (resumenSeparado[j].trim().equals("PALABRAS CLAVES:")){
                            int x = j+1;
                            while (!resumenSeparado[x].equals("")){
                              palabrasClave.insertarUltimo(resumenSeparado[x]);
                            x++;
                            }
                        }
                        }
                        Resumen resumen =  new Resumen(titulo, cuerpo, autores, palabrasClave);
                        this.tabla.insertar(resumen);
                        System.out.println(titulo);
                System.out.println(autores.imprimir_lista());
                System.out.println(cuerpo);
                System.out.println(palabrasClave.imprimir_lista());
                        
                    
                }
                
                guardado = true;
                
            }
            catch(FileNotFoundException er){
                    
                    }
    }
        return guardado;
    }
    
    
    
    

    public Resumen getResumen() {
        return resumen;
    }

    public void setResumen(Resumen resumen) {
        this.resumen = resumen;
    }
    




}

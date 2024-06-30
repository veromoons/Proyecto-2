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
 * Clase para obtener la informacion de cada resumen
 * @author sofiagrateron
 */
public class LeerTxt {
    public static Hashtable hashTitulos;
    public static Hashtable hashPalabrasClave;
    public static Hashtable hashAutores;
    Resumen resumen;

    public LeerTxt() {
        this.hashTitulos = new Hashtable(10000);
        this.hashPalabrasClave = new Hashtable(10000);
        this.hashAutores = new Hashtable(10000);
        this.resumen = null;
    }


    public String findNextNotEmpty(BufferedReader br) throws IOException {
        String line = br.readLine();
        while (br.readLine().length() ==0 ){
            line = br.readLine();
        }
        return line;
    }

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
                        autores.insertarUltimo(line.trim());
                    }
                    line = br.readLine();
                }

                // Leer resumen
                System.out.println("line: "+line);
                while (line != null && !line.trim().isEmpty() && !line.trim().split(":")[0].equalsIgnoreCase("Palabras Claves")) {
                    if (!line.trim().equalsIgnoreCase("resumen") && !line.trim().isEmpty()) {
                        cuerpo.append(line.trim()).append(" ");
                    }
                    line = br.readLine();
                }
                System.out.println("line: "+line);
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
                        palabrasClave.insertarUltimo(palabrasSplit[i].trim());
                    }
                }
            }

            guardado = true;

            if (guardado) {
                Resumen resumen = new Resumen(titulo, autores, cuerpo.toString().trim(), palabrasClave);
                this.resumen = resumen;
                this.hashTitulos.insertarPorTitulo(resumen);
                this.hashPalabrasClave.insertarPorPalabraClave(resumen);
                this.hashAutores.insertarPorAutor(resumen);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            guardado = false;
        } catch (IOException e) {
            e.printStackTrace();
            guardado = false;
        }
    }
    return guardado;
}

    public void cargarResumentxt(Resumen resumen){
        System.out.println("---resumen---");
       String resumenCargar;
       resumenCargar = resumen.mostrarResumen() + "\n%\n";
        System.out.println(resumenCargar);
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
            String[] resumenes = texto.toString().split("%");
            for (String resumen : resumenes) {
                String titulo = "";
                String cuerpo = "";
                Lista autores = new Lista();
                Lista palabrasClave = new Lista();
                String[] resumenSeparado = resumen.split("\n");
                if (resumenSeparado.length > 1) {
                    titulo = resumenSeparado[1];
                }
                for (int j = 0; j < resumenSeparado.length; j++) {
                    if (resumenSeparado[j].equals("AUTORES ")) {
                        int z = j + 1;
                        while (z < resumenSeparado.length && !resumenSeparado[z].equals("")) {
                            autores.insertarUltimo(resumenSeparado[z]);
                            z++;
                        }
                    }
                    if (resumenSeparado[j].trim().equals("RESUMEN")) {
                        if (j + 1 < resumenSeparado.length) {
                            cuerpo = resumenSeparado[j + 1];
                        }
                    }
                    if (resumenSeparado[j].trim().equals("PALABRAS CLAVES:")) {
                        int x = j + 1;
                        while (x < resumenSeparado.length && !resumenSeparado[x].equals("")) {
                            palabrasClave.insertarUltimo(resumenSeparado[x]);
                            x++;
                        }
                    }
                }
                Resumen resumenObj = new Resumen(titulo, autores, cuerpo, palabrasClave);
                this.hashTitulos.insertarPorTitulo(resumenObj);
                this.hashPalabrasClave.insertarPorPalabraClave(resumenObj);
                this.hashAutores.insertarPorAutor(resumenObj);
            }
            guardado = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
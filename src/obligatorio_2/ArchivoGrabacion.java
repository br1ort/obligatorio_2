package obligatorio_2;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Formatter;
/**
 *
 * @author bruno
 */
public class ArchivoGrabacion {
    private Formatter out;
    public ArchivoGrabacion(String unNombre,boolean ext) {
        
        //si el parametro viene en true
        //se extiende, si es false se sobreescribe
        try{
            FileWriter w=new FileWriter(unNombre,ext);
            out=new Formatter(w);
            
        } catch (IOException e) {
            System.out.println("no se puede write/extender");
            System.exit(1);
        }
    }
    public void grabarLinea(String linea) {
        out.format("%s%n", linea);
        
    }
    public void cerrar() {
        out.close();
    }
    
}
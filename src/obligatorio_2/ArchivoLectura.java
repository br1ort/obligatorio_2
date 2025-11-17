package obligatorio_2;

import java.io.IOException;
import static java.lang.System.out;
import java.nio.file.Paths;
import java.util.Scanner;


public class ArchivoLectura {
        private Scanner in;
        private String linea;
        public ArchivoLectura(String unNombre) {
            try {
                in=new Scanner(Paths.get(unNombre));
            } catch (IOException e) {
                System.out.println("Error");
                System.exit(1);
            }
        }
        
        public boolean hayMasLineas() {
            boolean hay=false;
            linea=null;
            if (in.hasNext()) {
                linea=in.nextLine();
                hay=true;
            }
        return hay;
        }
        public String linea() {
            return linea;
        }
        public void cerrar(){
            out.close();
        }
    }

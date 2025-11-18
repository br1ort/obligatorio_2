package obligatorio_2;
import java.util.ArrayList;

public class Manager extends Persona {
    
    private int antiguedad;
    
    
    public Manager(String nombre, String cedula, int antiguedad, String celular) {
        super(nombre, cedula, celular);
        this.antiguedad = antiguedad;
       
    }
    
   
    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
   
    
    
}

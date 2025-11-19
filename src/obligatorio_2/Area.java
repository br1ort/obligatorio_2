package obligatorio_2;
import java.util.*;

public class Area {
    private String nombre;
    private String descripcion; 
    private double presupuesto;
   
    
    public Area(String nombre, String descripcion, double presupuesto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presupuesto = presupuesto;
       
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
   
    public double getPresupuesto() {
        return presupuesto;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    } 
    
    
    
    
}

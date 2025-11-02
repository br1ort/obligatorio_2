package obligatorio_2;
import java.util.*;

public class Area {
    private String nombre;
    private String descripcion; 
    private double presupuesto;
    private ArrayList<Empleado> listaEmpleados;  
    
    public Area(String unaArea,String unaDescripcion, double unPresupuesto) {
        this.setNombre(unaArea);
        this.setDescripcion(unaDescripcion);
        this.setPresupuesto(unPresupuesto);
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public double getPresupuesto() {
        return presupuesto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
    
    
    public void agregarEmpleado(Empleado unEmpleado){
        listaEmpleados.add(unEmpleado);
    }
}

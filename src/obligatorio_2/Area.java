package obligatorio_2;
import java.util.*;

public class Area {
    private String nombre;
    private String descripcion; 
    private double presupuesto;
    private ArrayList<Empleado> listaEmpleados;  
    
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
    
    public void agregarEmpleado(Empleado unEmpleado){
        listaEmpleados.add(unEmpleado);
    }
}

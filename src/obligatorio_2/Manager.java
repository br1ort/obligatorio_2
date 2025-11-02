package obligatorio_2;
import java.util.ArrayList;

public class Manager {
    private String nombre;
    private String cedula;
    private int antiguedad;
    private int celular;
    private ArrayList<Empleado> empleadoACargo;

    public String getNombre() {
        return nombre;
    }
    public ArrayList<Empleado> getEmpleadoACargo() {
        return empleadoACargo;
    }
}

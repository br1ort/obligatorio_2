package obligatorio_2;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Area> listaArea = new ArrayList<Area>();
    private ArrayList<Empleado>listaEmpleados= new ArrayList<Empleado>();

    public boolean validarNombreUnico(String nombre,String caracteristica) {
        boolean esValido=true;
        for(Empleado empleado: listaEmpleados) {
            if(empleado.getNombre().equals(nombre)) {
                esValido=false;
                break;
            }
        }
    return esValido;
    }
    
    public void cargarDatosArea(String nombreArea, String descripcion, double presupuesto) {
       Area area= new Area(nombreArea,descripcion,presupuesto);
        listaArea.add(area);
    }
    
    
}

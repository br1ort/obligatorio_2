package obligatorio_2;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Area> listaArea = new ArrayList<Area>();
    private ArrayList<Empleado>listaEmpleados= new ArrayList<Empleado>();
    private ArrayList<Manager>listaManagers=new ArrayList<Manager>();

    public boolean validarNombreUnico(String validar, String tipo) {
        
        String v = validar.trim();
        
        

        switch (tipo) {
            case "AREA":
                for (Area area: listaArea) {
                    if (area.getNombre() != null && area.getNombre().equalsIgnoreCase(v)) {
                        return false;
                    }
                }
                break;
            case "MANAGER":
                for (Manager manager: listaManagers) {
                    System.out.print(manager.getCedula());
                    if (manager.getCedula() != null && manager.getCedula().equalsIgnoreCase(v)) {
                        return false;
                    }
                }
                break;
            case "EMPLEADO":
                for (Empleado empleado: listaEmpleados) {
                    if (empleado.getCedula() != null && empleado.getCedula().equalsIgnoreCase(v)) {
                        return false;
                    }
                }
                break;
            default:
                // opcional: manejar fallback o lanzar excepción por tipo desconocido
                break;
        }
        return true;
    }
    
    public void cargarDatosArea(String nombreArea, String descripcion, double presupuesto) {
       Area area= new Area(nombreArea,descripcion,presupuesto);
        listaArea.add(area);
    }
    
    public void cargarDatosEmpleado(String nombre, String cedula,String celular, String curriculum, double salarioMensual, Manager manager, Area area) {
        Empleado empleado=new Empleado( nombre,  cedula,  celular, curriculum,  salarioMensual,  manager,  area);
        listaEmpleados.add(empleado);
        
    }
    
    public void cargarDatosManager(String nombre, String cedula, int antiguedad, String celular) {
        Manager manager=new Manager(nombre,cedula,antiguedad,celular);
        listaManagers.add(manager);
        
    }
    
    public java.util.ArrayList<Area> getListaAreas() {
        return this.listaArea;
    }
    
    public java.util.ArrayList<Empleado> getListaEmpleados() {
        return this.listaEmpleados;
    }
    
    public void cargarDatos(String datos) {
        ArchivoLectura archivo = new ArchivoLectura(datos);
        while (archivo.hayMasLineas()) {
            String linea = archivo.linea();
            if (linea == null) continue;
            String[] partes = linea.split("\\|"); // escapar pipe
            if (partes.length == 0) continue;
            String queEs = partes[0];

            // CORRECCIÓN: debe ser == "AREA"
            if (queEs.equals("AREA")) {
                if (partes.length < 4) continue;
                String nombreArea = partes[1];
                String descripcion = partes[2];
                double presupuesto = Double.parseDouble(partes[3]);
                cargarDatosArea(nombreArea, descripcion, presupuesto);
            }
            if (queEs.equals("MANAGER")) {
                if (partes.length < 5) continue;
                String nombre = partes[1];
                String cedula = partes[2];
                int antiguedad = Integer.parseInt(partes[3]);
                String celular = partes[4];
                cargarDatosManager(nombre, cedula, antiguedad, celular);
            }
        }

        ArchivoLectura archivo2 = new ArchivoLectura(datos);
        while (archivo2.hayMasLineas()) {
            String linea = archivo2.linea(); // usar archivo2
            if (linea == null) continue;
            String[] partes = linea.split("\\|");
            if (partes.length == 0) continue;
            String queEs = partes[0];
            if (queEs.equals("EMPLEADO")) {
                if (partes.length < 8) continue;
                String nombre = partes[1];
                String cedula = partes[2];
                String celular = partes[3];
                String curriculum = partes[4];
                double salarioMensual = Double.parseDouble(partes[5]);
                String strmanager = partes[6];
                String strarea = partes[7];
                Manager manager = null;
                Area area = null;
                for (Manager m: listaManagers) {
                    if (m.getNombre() != null && m.getNombre().equals(strmanager)) {
                        manager = m;
                        break;
                    }
                }
                for (Area a: listaArea) {
                    if (a.getNombre() != null && a.getNombre().equals(strarea)) {
                        area = a;
                        break;
                    }
                }
                cargarDatosEmpleado(nombre, cedula, celular, curriculum, salarioMensual, manager, area);
            }
        }
    }
    
    public void guardadDatosFinales()  {
      ArchivoGrabacion archivo=new ArchivoGrabacion("datos.txt",true);
        for(Area area: listaArea) {
            archivo.grabarLinea("AREA|"+area.getNombre()+"|"+area.getDescripcion()+"|"+area.getPresupuesto());
        }
        for(Manager manager: listaManagers) {
            archivo.grabarLinea("MANAGER|"+manager.getNombre()+"|"+manager.getCedula()+"|"+manager.getAntiguedad()+"|"+manager.getCelular());
        }
        for(Empleado empleado: listaEmpleados) {
            archivo.grabarLinea("EMPLEADO|"+empleado.getNombre()+"|"+empleado.getCedula()+"|"+empleado.getCurriculum()+"|"+empleado.getSalarioMensual()+"|"+empleado.getManager().getNombre()+"|"+empleado.getArea().getNombre());
        }
        archivo.cerrar();

    }

    


    
}

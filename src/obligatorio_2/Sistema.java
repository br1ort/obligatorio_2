package obligatorio_2;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Area> listaArea = new ArrayList<Area>();
    private ArrayList<Empleado>listaEmpleados= new ArrayList<Empleado>();
    private ArrayList<Manager>listaManagers=new ArrayList<Manager>();

    public boolean validarNombreUnico(String validar, String tipo) {
        boolean esValido=true;
        switch(tipo) {
            case "AREA":
                for(Area area: listaArea) {
                    if(area.getNombre().equals(validar)) {
                        esValido=false;
                        break;
                    }
                }
                break;
            case "MANAGER":
                for(Manager manager: listaManagers) {
                    if(manager.getCedula().equals(validar)) {
                        esValido=false;
                        break;
                    }
                }
                break;
            case "EMPLEADO":
                for(Empleado empleado: listaEmpleados) {
                    if(empleado.getCedula().equals(validar)) {
                        esValido=false;
                        break;
                    }
                }
            }
        
    return esValido;
    }
    
    public void cargarDatosArea(String nombreArea, String descripcion, double presupuesto) {
       Area area= new Area(nombreArea,descripcion,presupuesto);
        listaArea.add(area);
    }
    
    public void cargarDatosEmpleado(String nombre, String cedula, String curriculum, double salarioMensual, Manager manager, Area area) {
        Empleado empleado=new Empleado(nombre,cedula,curriculum,salarioMensual,manager,area);
        listaEmpleados.add(empleado);
        
    }
    
    public void cargarDatosManager(String nombre, String cedula, int antiguedad, int celular) {
        Manager manager=new Manager();
        listaManagers.add(manager);
    }
    
    public void cargarDatos(String datos) {
        ArchivoLectura archivo=new ArchivoLectura(datos);
        while(archivo.hayMasLineas()) {
            String linea=archivo.linea();
            String[] partes=linea.split("|");
            String queEs=partes[0];

            if(!queEs.equals("AREA")) {
            String nombreArea=partes[1];
            String descripcion=partes[2];
            double presupuesto=Double.parseDouble(partes[3]);
            cargarDatosArea(nombreArea,descripcion,presupuesto);
            }
            if(queEs.equals("MANAGER")) {
                String nombre=partes[1];
                String cedula=partes[2];
                int antiguedad=Integer.parseInt(partes[3]);
                int celular=Integer.parseInt(partes[4]);
                //Faltan empleados a cargo
                cargarDatosManager(nombre,cedula,antiguedad,celular);
            }
            
        }
        ArchivoLectura archivo2=new ArchivoLectura(datos);
        while (archivo2.hayMasLineas()) {
            String linea=archivo.linea();
            String[] partes=linea.split("|");
            String queEs=partes[0];
            if(queEs.equals("EMPLEADO")) {
                String nombre=partes[1];
                String cedula=partes[2];
                String curriculum=partes[3];
                double salarioMensual=Double.parseDouble(partes[4]);
                String strmanager=partes[5];
                String strarea=partes[6];
                Manager manager=null;
                Area area=null;
                for(Manager m: listaManagers) {
                    if(m.getNombre().equals(strmanager)) {
                         manager=m;
                        break;
                    }
                }
                for(Area a: listaArea) {
                    if(a.getNombre().equals(strarea)) {
                         area=a;
                        break;
                    }
                }
                cargarDatosEmpleado(nombre,cedula,curriculum,salarioMensual,manager,area);
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

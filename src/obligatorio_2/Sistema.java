package obligatorio_2;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Area> listaArea = new ArrayList<Area>();
    private ArrayList<Empleado>listaEmpleados= new ArrayList<Empleado>();
    private ArrayList<Manager>listaManagers=new ArrayList<Manager>();
    private ArrayList<String>listaMovimientos=new ArrayList<String>();

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
        case "EMPLEADO":
            
            for (Empleado empleado: listaEmpleados) {
                if (empleado.getCedula() != null && empleado.getCedula().equalsIgnoreCase(v)) {
                    return false;
                }
            }
           
            for (Manager manager: listaManagers) {
                if (manager.getCedula() != null && manager.getCedula().equalsIgnoreCase(v)) {
                    return false;
                }
            }
            break;
            
        default:
            break;
    }
    return true;
}
    
    public void cargarDatosArea(String nombreArea, String descripcion, double presupuesto) {
       Area area= new Area(nombreArea,descripcion,presupuesto);
        listaArea.add(area);
    }
    
    public void cargarDatosEmpleado(String nombre, String cedula, String celular, String curriculum, double salarioMensual, Manager manager, Area area) {
        Empleado empleado = new Empleado(nombre, cedula, celular, curriculum, salarioMensual, manager, area);
        listaEmpleados.add(empleado);
    }

    public void cargarDatosManager(String nombre, String cedula, int antiguedad, String celular) {
        Manager manager = new Manager(nombre, cedula, antiguedad, celular);
        listaManagers.add(manager);
    }
    
    public java.util.ArrayList<Area> getListaAreas() {
        return this.listaArea;
    }
    
    public java.util.ArrayList<Manager> getListaManagers() {
        return this.listaManagers;
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
        archivo.cerrar();

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
        archivo2.cerrar();
    }
    
    public void cargarDatosGuardados() {
    try {
        // Verificar si el archivo existe antes de intentar cargarlo
        java.io.File archivo = new java.io.File("datos.txt");
        if (archivo.exists()) {
            cargarDatos("datos.txt");
        } else {
            System.out.println("No se encontró archivo de datos guardados. Iniciando sistema vacío.");
        }
    } catch (Exception e) {
        System.out.println("Error al cargar datos guardados: " + e.getMessage());
    }
}
    
    public void guardarDatosFinales()  {
      ArchivoGrabacion archivo=new ArchivoGrabacion("datos.txt",false);
      
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
    
    public void cargarDatosPrecargados() {
        try {
            // Limpiar sistema actual
            limpiarSistema();

            // Intentar cargar desde archivo precargados.txt
            java.io.File archivoPrecargados = new java.io.File("precargados.txt");
            if (archivoPrecargados.exists()) {
                cargarDatos("precargados.txt");
            } 
        } catch (Exception e) {
            System.out.println("Error al cargar datos precargados: " + e.getMessage());
        }
    }
    
    public void limpiarSistema() {
        listaArea.clear();
        listaEmpleados.clear();
        listaManagers.clear();
    }
    
        public boolean realizarMovimiento(Empleado empleado, Area areaDestino, int mes) {
        
        Area areaOrigen = empleado.getArea();

        if (areaOrigen == null || areaDestino == null || empleado == null) {
            return false;
        }

        if (areaOrigen.equals(areaDestino)) {
            return false;
        }

        double salarioRestante = empleado.calcularSalarioRestante(mes);

        if (!areaDestino.puedeAceptarSalario(salarioRestante)) {
            return false;
        }
        areaOrigen.removerSalario(salarioRestante);
        areaDestino.agregarSalario(salarioRestante);
        empleado.setArea(areaDestino);
        registrarMovimiento(mes, areaOrigen, areaDestino, empleado);
        
        return true;
    }
    
    // Método de registrar movimientos en arrayList, para el reporte
    private void registrarMovimiento(int mes, Area areaOrigen, Area areaDestino, Empleado empleado) {
        listaMovimientos.add(mes+"|"+areaOrigen.getNombre()+"|"+areaDestino.getNombre()+"|"+empleado.getNombre());
    }
    
    public java.util.ArrayList<Empleado> getEmpleadosPorArea(Area area) {
        java.util.ArrayList<Empleado> empleadosArea = new java.util.ArrayList<>();
        for (Empleado emp : listaEmpleados) {
            if (emp.getArea().equals(area)) {
                empleadosArea.add(emp);
            }
        }
        return empleadosArea;
    }
    
    public double calcularReintegroAreaOrigen(Empleado empleado, int mes) {
        return empleado.calcularSalarioRestante(mes);
    }
    
    public double calcularCostoAreaDestino(Empleado empleado, int mes) {
        return empleado.calcularSalarioRestante(mes);
    }
    
    public String getInformacionMovimiento(Empleado empleado, Area areaDestino, int mes) {
        double salarioRestante = empleado.calcularSalarioRestante(mes);
        double reintegroOrigen = calcularReintegroAreaOrigen(empleado, mes);
        double costoDestino = calcularCostoAreaDestino(empleado, mes);

        return String.format(
            "Salario restante: US$ %.2f\nReintegro área origen: US$ %.2f\nCosto área destino: US$ %.2f",
            salarioRestante, reintegroOrigen, costoDestino
        );
    }
}

package obligatorio_2;


public class Area {
    private String nombre;
    private String descripcion; 
    private double presupuesto;
    private double presupuestoUtilizado;
   
    
    public Area(String nombre, String descripcion, double presupuesto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presupuesto = presupuesto;
        this.presupuestoUtilizado = 0;
       
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

    public double getPresupuestoUtilizado() {
        return presupuestoUtilizado;
    }
    
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    } 
    
    public void setPresupuestoUtilizado(double presupuestoUtilizado) {
        this.presupuestoUtilizado = presupuestoUtilizado;
    }
    
    public void agregarSalario(double salarioAnual) {
        this.presupuestoUtilizado += salarioAnual;
    }
    
    // Método para remover salario del presupuesto utilizado (reintegro)
    public void removerSalario(double salario) {
        this.presupuestoUtilizado -= salario;
    }
    
    // Método para obtener presupuesto disponible
    public double getPresupuestoDisponible() {
        return this.presupuesto - this.presupuestoUtilizado;
    }
    
    // Método para verificar si puede aceptar un salario adicional
    public boolean puedeAceptarSalario(double salarioAdicional) {
        return (this.presupuestoUtilizado + salarioAdicional) <= this.presupuesto;
    }
    
}   
    
  
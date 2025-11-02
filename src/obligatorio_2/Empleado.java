package obligatorio_2;

public class Empleado {
    private String nombre;
    private String cedula;
    private String curriculum;
    private double salarioMensual;
    private Manager manager;
    private Area area;

    public Empleado(String nombre, String cedula, String curriculum, double salarioMensual, Manager manager, Area area) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.curriculum = curriculum;
        this.salarioMensual = salarioMensual;
        this.manager = manager;
        this.area = area;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getCurriculum() {
        return curriculum;
    }
    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }
    public double getSalarioMensual() {
        return salarioMensual;
    }
    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }
    public Manager getManager() {
        return manager;
    }
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
    
}

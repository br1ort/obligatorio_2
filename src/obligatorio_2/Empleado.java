package obligatorio_2;

public class Empleado extends Persona {
    private String curriculum;
    private double salarioMensual;
    private Manager manager;
    private Area area;

    public Empleado(String nombre, String cedula, String celular,String curriculum, double salarioMensual, Manager manager, Area area) {
        super(nombre, cedula, celular);
        this.curriculum = curriculum;
        this.salarioMensual = salarioMensual;
        this.manager = manager;
        this.area = area;
    }
    
    public String getCurriculum() {
        return curriculum;
    }
    
    public double getSalarioMensual() {
        return salarioMensual;
    }
    
    public Manager getManager() {
        return manager;
    }
    
    public Area getArea() {
        return area;
    }
    
    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    public double calcularSalarioRestante(int mes) {
        int mesesRestantes = 12 - mes + 1; // Se incluye el mes actual
        return this.salarioMensual * mesesRestantes;
    }
}

package obligatorio_2;

public class Persona {
    private String nombre;
    private String cedula;
    private String cecular;

    public Persona(String nombre, String cedula, String celular) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.cecular = celular;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public String getCelular() {
        return cecular;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setCelular(String cecular) {
        this.cecular = cecular;
    }

}

public class Persona {

    // Atributos
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private char sexo;
    private int edad;
    private String direccion;

    // Constructor por defecto
    public Persona() {
    }

    // Constructor de copia
    public Persona(Persona persona) {
        this.nombre = persona.nombre;
        this.apellidoPaterno = persona.apellidoPaterno;
        this.apellidoMaterno = persona.apellidoMaterno;
        this.sexo = persona.sexo;
        this.edad = persona.edad;
        this.direccion = persona.direccion;
    }

    // Constructor común
    public Persona(String nom, String app, String apm, char sexo, int edad, String dir) {
        this.nombre = nom;
        this.apellidoPaterno = app;
        this.apellidoMaterno = apm;
        this.sexo = sexo;
        this.edad = edad;
        this.direccion = dir;
    }

    // Método corregido: usa el atributo de la instancia
    public void verificarMayorEdad() {
        if (this.edad >= 18) {
            System.out.println(this.nombre + " es mayor de edad.");
        } else {
            System.out.println(this.nombre + " es menor de edad.");
        }
    }

    // Método mejorado: usa el estándar toString() para mostrar datos
    @Override
    public String toString() {
        return "Datos de la Persona:\n" +
               "  Nombre: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + "\n" +
               "  Sexo: " + sexo + "\n" +
               "  Edad: " + edad + "\n" +
               "  Dirección: " + direccion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

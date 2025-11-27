public class Principal {
    public static void main(String[] args) {

        // Creación de una instancia de Persona usando el constructor común
        Persona persona1 = new Persona("Linda", "Gómez", "Pérez", 'F', 28, "Calle Ariban, Madrid");

        // Impresión de datos usando el método toString() mejorado
        System.out.println("--- Datos de Persona 1 ---");
        System.out.println(persona1.toString());
        persona1.verificarMayorEdad();
        
        System.out.println("\n--- Datos de Persona 2 (Copia) ---");
        // Creación de una instancia de Persona usando el constructor de copia
        Persona persona2 = new Persona(persona1);
        // Modificamos un dato para demostrar que es una copia
        persona2.setNombre("Carlos");
        persona2.setSexo('M');
        persona2.setEdad(17);
        
        System.out.println(persona2.toString());
        persona2.verificarMayorEdad();
        
        System.out.println("\n--- Datos de Persona 1 (Original) ---");
        System.out.println(persona1.toString());
        
        // Demostración del constructor por defecto y setters
        Persona persona3 = new Persona();
        persona3.setNombre("Ana");
        persona3.setEdad(35);
        System.out.println("\n--- Datos de Persona 3 (Constructor por defecto) ---");
        System.out.println(persona3.toString());
        persona3.verificarMayorEdad();
    }
}

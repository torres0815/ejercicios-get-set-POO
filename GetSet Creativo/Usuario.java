import java.util.Random;

// La clase Usuario debe heredar de Persona para ser un "Usuario" de cuenta bancaria.
// Se corrige la falta de la palabra clave 'public' en la declaración de la clase.
public class Usuario extends Persona {

    // Atributos privados específicos de Usuario
    private long numeroCuenta;
    private double saldo;

    // Constructor que llama al constructor de la superclase (Persona)
    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, char sexo, int edad, String direccion, double saldoInicial) {
        super(nombre, apellidoPaterno, apellidoMaterno, sexo, edad, direccion);
        Random aleatorio = new Random();
        this.saldo = saldoInicial;
        // Se cambia el nombre de la variable a camelCase: numero_cuenta -> numeroCuenta
        this.numeroCuenta = Math.abs(aleatorio.nextLong());
    }

    // Constructor simplificado para el ejercicio de CuentaCorriente
    public Usuario(String titular, double saldoInicial) {
        // Asume que el titular es el nombre completo y llama al constructor por defecto de Persona
        // Esto es un parche temporal, lo ideal es usar el constructor completo.
        // Para el ejercicio, se mantiene la estructura original lo más posible.
        super(); // Llama al constructor por defecto de Persona
        this.setNombre(titular); // Usamos el setter de Persona para el nombre
        Random aleatorio = new Random();
        this.saldo = saldoInicial;
        this.numeroCuenta = Math.abs(aleatorio.nextLong());
    }

    // Métodos estáticos (se mantienen, aunque se recomienda que sean métodos de instancia)
    // Se cambia el nombre de los métodos a camelCase: setRetiros -> realizarRetiro
    public static void realizarRetiro(Usuario cliente, double cantidad) {
        if (cliente.saldo >= cantidad) {
            cliente.saldo -= cantidad;
            System.out.println("Retiro de " + cantidad + " realizado con éxito.");
        } else {
            System.out.println("Error: Saldo insuficiente para el retiro de " + cantidad + ".");
        }
    }

    // Se cambia el nombre de los métodos a camelCase: setTransferencia -> realizarTransferencia
    public static void realizarTransferencia(Usuario origen, Usuario destino, double cantidad) {
        if (origen.saldo >= cantidad) {
            origen.saldo -= cantidad;
            destino.saldo += cantidad;
            System.out.println("Transferencia de " + cantidad + " de " + origen.getNombre() + " a " + destino.getNombre() + " realizada con éxito.");
        } else {
            System.out.println("Error: Saldo insuficiente para la transferencia.");
        }
    }

    // Getter para el saldo
    public double getSaldo() {
        return saldo;
    }

    // Método para mostrar datos de la cuenta (se mantiene la lógica original, pero se usa el nombre de la superclase)
    public String getDatosCuenta() {
        return "Titular: " + getNombre() + // Usamos el getter de Persona
               "\nNúmero de cuenta: " + numeroCuenta +
               "\nSaldo: " + saldo;
    }

    // Se elimina el método getRetiro() ya que su nombre no es descriptivo y su función se cubre con getDatosCuenta()
}

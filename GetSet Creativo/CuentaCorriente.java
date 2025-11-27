import java.util.Scanner;

public class CuentaCorriente {

    public static void main(String[] args) {

        double monto;
        Usuario cuenta1 = null, cuenta2 = null, cuenta3 = null;

        try (Scanner scn = new Scanner(System.in)) {

            System.out.println("***********************************");
            System.out.println("  BIENVENIDO AL BANCO MANUS  ");
            System.out.println("***********************************");

            // 1. Solicitar datos de las 3 cuentas al usuario (Simplificado)
            for (int i = 1; i <= 3; i++) {
                System.out.println("\n--- Configuración de Cuenta " + i + " ---");
                System.out.print("Ingrese el nombre del titular: ");
                String titular = scn.nextLine();
                
                double saldo = -1;
                while (saldo < 0) {
                    System.out.print("Ingrese el saldo inicial: ");
                    try {
                        saldo = Double.parseDouble(scn.nextLine());
                        if (saldo < 0) System.out.println("El saldo no puede ser negativo.");
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Ingrese un número.");
                    }
                }

                if (i == 1) cuenta1 = new Usuario(titular, saldo);
                else if (i == 2) cuenta2 = new Usuario(titular, saldo);
                else if (i == 3) cuenta3 = new Usuario(titular, saldo);
            }

            System.out.println("\n--- Cuentas Configuradas ---");
            System.out.println("1: " + cuenta1.getNombre() + " | 2: " + cuenta2.getNombre() + " | 3: " + cuenta3.getNombre());
            System.out.println("----------------------------");

            // 2. Iniciar el cuestionario de operaciones
            System.out.println("\n¿Qué operación desea realizar?");
            System.out.println(" A = Consultar datos de cuenta");
            System.out.println(" B = Retiros");
            System.out.println(" T = Transferencias");
            System.out.println(" C = Simular Operación Creativa (Cálculo de Intereses)");
            
            System.out.print("Seleccione una opción: ");
            String seleccion = scn.nextLine().toUpperCase();

            // Función auxiliar para obtener la cuenta por número
            Usuario[] cuentas = {null, cuenta1, cuenta2, cuenta3};
            
            // toUpperCase para que ignore minúscula y mayúscula
            switch (seleccion) {

                case "A": // Consultar datos
                    System.out.print("Número de cuenta a consultar (1-3): ");
                    int cuen = Integer.parseInt(scn.nextLine());
                    if (cuen >= 1 && cuen <= 3) {
                        System.out.println(cuentas[cuen].getDatosCuenta());
                    } else {
                        System.out.println("Error: Cuenta no válida.");
                    }
                    break;

                case "B": // Retiros
                    System.out.print("Número de cuenta de origen (1-3): ");
                    int cuenRetiro = Integer.parseInt(scn.nextLine());
                    Usuario cuentaOrigen = (cuenRetiro >= 1 && cuenRetiro <= 3) ? cuentas[cuenRetiro] : null;

                    if (cuentaOrigen != null) {
                        System.out.print("Monto a retirar: ");
                        monto = Double.parseDouble(scn.nextLine());
                        Usuario.realizarRetiro(cuentaOrigen, monto);
                        System.out.println(cuentaOrigen.getDatosCuenta());
                    } else {
                        System.out.println("Error: Cuenta no válida.");
                    }
                    break;

                case "T": // Transferencias
                    System.out.print("Cuenta de origen (1-3): ");
                    int cuenOrigen = Integer.parseInt(scn.nextLine());
                    System.out.print("Cuenta de destino (1-3): ");
                    int cuenDestino = Integer.parseInt(scn.nextLine());

                    Usuario origen = (cuenOrigen >= 1 && cuenOrigen <= 3) ? cuentas[cuenOrigen] : null;
                    Usuario destino = (cuenDestino >= 1 && cuenDestino <= 3) ? cuentas[cuenDestino] : null;

                    if (origen != null && destino != null && origen != destino) {
                        System.out.print("Monto a transferir: ");
                        monto = Double.parseDouble(scn.nextLine());
                        Usuario.realizarTransferencia(origen, destino, monto);
                        System.out.println("Saldo de origen (" + origen.getNombre() + "):\n" + origen.getDatosCuenta());
                        System.out.println("\nSaldo de destino (" + destino.getNombre() + "):\n" + destino.getDatosCuenta());
                    } else {
                        System.out.println("Error: Transferencia no válida (misma cuenta o cuenta inexistente).");
                    }
                    break;
                
                case "C": // Parte creativa: Simular Intereses
                    System.out.print("Número de cuenta para calcular intereses (1-3): ");
                    int cuenInteres = Integer.parseInt(scn.nextLine());
                    Usuario cuentaInteres = (cuenInteres >= 1 && cuenInteres <= 3) ? cuentas[cuenInteres] : null;

                    if (cuentaInteres != null) {
                        double tasaInteres = 0.05; 
                        double saldoActual = cuentaInteres.getSaldo();
                        double interesGanado = saldoActual * tasaInteres;
                        double nuevoSaldo = saldoActual + interesGanado;

                        System.out.println("Cálculo de Intereses para " + cuentaInteres.getNombre() + ":");
                        System.out.printf("  Saldo Actual: %.2f\n", saldoActual);
                        System.out.printf("  Interés Ganado (Simulado): %.2f\n", interesGanado);
                        System.out.printf("  Nuevo Saldo (Simulado): %.2f\n", nuevoSaldo);
                    } else {
                        System.out.println("Error: Cuenta no válida.");
                    }
                    break;

                default:
                    System.out.println("Opción no válida. El programa ha finalizado.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado en la entrada de datos. Asegúrese de ingresar números donde se solicitan.");
            // e.printStackTrace(); // Se comenta para simplificar la salida
        }

    } // fin main
}

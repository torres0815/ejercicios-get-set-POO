import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== SISTEMA DE FACTURACIÓN ===");
        System.out.print("Ingrese la cantidad de artículos: ");
        double cant = entrada.nextDouble();

        System.out.print("Ingrese el precio por artículo: ");
        double price = entrada.nextDouble();

        // Objeto con datos ingresados
        Facturar factura = new Facturar(cant, price);

        // Se llama al nuevo método creativo
        factura.mostrarResumen();

        entrada.close();
    }
}

public class Facturar {
    private double cantidad;
    private double precio;

    // Constructor sin parámetros
    public Facturar() {
        cantidad = 0;
        precio = 0;
    }

    // Constructor con parámetros
    public Facturar(double cantidad, double precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Setters
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(double cantidad){
        this.cantidad = cantidad;
    }

    // Getters
    public double getPrecio(){
        return this.precio;
    }

    public double getCantidad(){
        return this.cantidad;
    }

    // Método que calcula el total de la venta
    public double calcularVenta(){
        double subtotal = cantidad * precio;
        double iva = subtotal * 0.13;
        double total = subtotal + iva;
        return total;
    }

    // 👉 Método creativo añadido (no modifica lo original)
    public void mostrarResumen() {
        System.out.println("\n---- RESUMEN DE LA FACTURA ----");
        System.out.println("Cantidad comprada: " + cantidad);
        System.out.println("Precio unitario: $" + precio);
        System.out.printf("Total con IVA: $%.2f%n", calcularVenta());
        System.out.println("¡Gracias por preferir nuestro servicio!");
        System.out.println("-------------------------------");
    }
}




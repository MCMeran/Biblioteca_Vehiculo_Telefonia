/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telefonia;
public class Factura {
    // Tarifas por exceso (ajústalas a tu gusto)
    private static final double COSTO_MINUTO_EXTRA = 2.50;
    private static final double COSTO_GB_EXTRA = 150.00;

    private Cliente cliente;
    private int minutosUsados;
    private double datosUsadosGB;

    public Factura(Cliente cliente, int minutosUsados, double datosUsadosGB) {
        this.cliente = cliente;
        this.minutosUsados = minutosUsados;
        this.datosUsadosGB = datosUsadosGB;
    }

    public int getMinutosExtra() {
        return Math.max(0, minutosUsados - cliente.getPlan().getMinutosIncluidos());
    }

    public double getDatosExtraGB() {
        return Math.max(0, datosUsadosGB - cliente.getPlan().getDatosGB());
    }

    public double calcularCargosExtras() {
        return getMinutosExtra() * COSTO_MINUTO_EXTRA
             + getDatosExtraGB() * COSTO_GB_EXTRA;
    }

    public double calcularTotal() {
        return cliente.getPlan().getPrecioMensual() + calcularCargosExtras();
    }

    public void generarFactura() {
        Plan plan = cliente.getPlan();
        System.out.println("=========== FACTURA ===========");
        System.out.println("Cliente:  " + cliente.getNombre());
        System.out.println("Teléfono: " + cliente.getNumeroTelefonico());
        System.out.println("-------------------------------");
        System.out.printf("Minutos incluidos: %d | usados: %d | extra: %d%n",
                plan.getMinutosIncluidos(), minutosUsados, getMinutosExtra());
        System.out.printf("Datos incluidos:   %.1f GB | usados: %.1f GB | extra: %.1f GB%n",
                plan.getDatosGB(), datosUsadosGB, getDatosExtraGB());
        System.out.println("-------------------------------");
        System.out.printf("Precio base:       $%.2f%n", plan.getPrecioMensual());
        System.out.printf("Cargos por exceso: $%.2f%n", calcularCargosExtras());
        System.out.printf("TOTAL A PAGAR:     $%.2f%n", calcularTotal());
        System.out.println("===============================");
    }
}

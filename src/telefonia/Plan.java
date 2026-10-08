/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telefonia;
public class Plan {
    private int minutosIncluidos;
    private double datosGB;
    private double precioMensual;

    public Plan(int minutosIncluidos, double datosGB, double precioMensual) {
        this.minutosIncluidos = minutosIncluidos;
        this.datosGB = datosGB;
        this.precioMensual = precioMensual;
    }

    public int getMinutosIncluidos() { return minutosIncluidos; }
    public double getDatosGB() { return datosGB; }
    public double getPrecioMensual() { return precioMensual; }
}
